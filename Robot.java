/*
    Justin Chan
    Robot.java
    July 25th, 2015
    This class will ultimately run all of the classes involved in this project.
    It will read data from the XML file and start 4 threads that will output 
    this data onto the console.
*/

public class Robot
{
    Command order;
    Arm1 arm1;
    Arm2 arm2;
    Arm3 arm3;
    Arm4 arm4;
    
    public Robot()
    {
        order = new Command();
        order.Reset();
    }
    
    public void runRobot()
    {
        XMLProcessor pro = new XMLProcessor();
        pro.loadCommands();
        
        arm1 = new Arm1(pro.getA1List(), order);
        arm2 = new Arm2(pro.getA2List(), order);
        arm3 = new Arm3(pro.getA3List(), order);
        arm4 = new Arm4(pro.getA4List(), order);
        
        arm1.thread.start();
        arm2.thread.start();
        arm3.thread.start();
        arm4.thread.start();
    }
    
    public static void main (String[] args)
    {
        Robot irobot = new Robot();
        irobot.runRobot();
    }
}


