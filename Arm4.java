/*
    Justin Chan
    July 25th, 2015
    Arm2.java
    This class is meant to simulate a single arm of the "robot" of this project.
*/

import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Arm4 implements Runnable
{
    private ArrayList<Node> a4list;
    Command give;
    Integer position;
    Thread thread;
    
    public Arm4 (ArrayList<Node> nlist, Command in)
    {
        position = new Integer(0);
        give = in;
        a4list = nlist;
        thread = new Thread(this);
    }
    
    public void run()
    {
        do
        {
            synchronized (give)
            {
                giveCommand();
                System.out.println("\n\nArm 4 is commanded.");
                give.Execute();
            }
        } while (getPosition() < a4list.size());
    }
    
    public void giveCommand()
    {
        give.setOffOn(((Element)a4list.get(position.intValue())).getElementsByTagName("offon").item(0).getTextContent());
        give.setSpeed(((Element)a4list.get(position.intValue())).getElementsByTagName("speed").item(0).getTextContent());
        give.setHorizontal(((Element)a4list.get(position.intValue())).getElementsByTagName("horizontal").item(0).getTextContent());
        give.setVertical(((Element)a4list.get(position.intValue())).getElementsByTagName("vertical").item(0).getTextContent());
        give.setTime(Integer.parseInt(((Element)a4list.get(position.intValue())).getElementsByTagName("time").item(0).getTextContent()));
        
        position = new Integer(position.intValue() + 1);
    }
    
    public int getPosition()
    {
        return position.intValue();
    }
}
