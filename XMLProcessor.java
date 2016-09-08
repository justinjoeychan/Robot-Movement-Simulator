/*
    Justin Chan
    July 25th, 2015
    XMLProcessor.java
    This class will read the XML file RobotData.xml and extract its nodes into
    a data structure. It will create four ArrayLists to organize the nodes so
    that each ArrayList represents a certain arm.
*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLProcessor 
{
    private ArrayList<Node> a1list;
    private ArrayList<Node> a2list;
    private ArrayList<Node> a3list;
    private ArrayList<Node> a4list;
    
    public XMLProcessor()
    {
        a1list = new ArrayList<Node>();
        a2list = new ArrayList<Node>();
        a3list = new ArrayList<Node>();
        a4list = new ArrayList<Node>();
    }
    
    public void loadCommands()
    {
        ArrayList<Node> nlist = loadXML();
        for (Node n : nlist)
        {
            if (((Element) n).getElementsByTagName("robot").item(0).getTextContent().equals("A1"))
                a1list.add(n);
            else if (((Element) n).getElementsByTagName("robot").item(0).getTextContent().equals("A2"))
                a2list.add(n);
            else if (((Element) n).getElementsByTagName("robot").item(0).getTextContent().equals("A3"))
                a3list.add(n);
            else if (((Element) n).getElementsByTagName("robot").item(0).getTextContent().equals("A4"))
                a4list.add(n);
        }
    }
    
    public ArrayList<Node> loadXML()
    {
        XMLReader reader = new XMLReader();
        Document doc = null;
        
        try
        {
            doc = reader.ReadXML(System.getProperty("user.dir") + File.separator + "RobotData.xml");
        }
        catch (Exception e)
        {
            e.printStackTrace();;
        }
        
        NodeList nlist = reader.GetNodes(doc, "command");
        ArrayList<Node> alist = new ArrayList<Node>();
        
        for (int i = 0; i < nlist.getLength(); i++) 
        {
            Node n = nlist.item(i);
            alist.add(n);
        }
        
        return alist;
    }
    
    public ArrayList<Node> getA1List()
    {
        return a1list;
    }
    
    public ArrayList<Node> getA2List()
    {
        return a2list;
    }
    
    public ArrayList<Node> getA3List()
    {
        return a3list;
    }
    
    public ArrayList<Node> getA4List()
    {
        return a4list;
    }
}
