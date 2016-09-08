# Robot Movement Simulator

This project contains a utilizes threading in order to emulate the actions performed by a robot.

XMLReader 	       - reads an XML file of instructions and stores them into a NodeList
XMLProcessor           - stores the contents of each NodeList into four individual ArrayLists, each representing one arm
Command		       - contains the commands for the robot as well as the code that executes each command
Robot		       - the runner class that utilizes all the classes in this project to simulate robot movement
Arm1, Arm2, Arm2, Arm4 - contains code that will run a thread that is able to execute the functions in the Command class
