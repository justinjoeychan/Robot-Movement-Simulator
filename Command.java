/*
 *	 This class contains specific commands for each arm of the Robot to perform. Commands include
 * 	 setting the speed of each arm, setting each arm on or off, and moving each arm in a veritcal or 
 * 	 horizontal direction.
 */

public class Command
{
		Command() { Reset(); }
		void setOffOn(String value) { offon = value; }
		void setError(String value) { errorcode = value; }
		void setSpeed(String value) { speed = value; }
		void setHorizontal(String value) { horizontal = value; }
		void setVertical(String value) { vertical = value; }
		void setTime(int value) { time = value; }
		void Execute()
		{
                    Output();
                    try
                    {
                        Thread.sleep(time);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println("Interrupted");
                    }
                    Reset();
		}
		void Output()
		{
			System.out.print("Command = On: " + offon + '\t');
			System.out.print("Speed: " + speed + '\t');
			System.out.print("Horizontal: " + horizontal + '\t');
			System.out.print("Vertical: " + vertical + '\t');
			System.out.print("Time: " + time + '\n');
		}
		boolean testValue(int value)
		{
			if (value != 0)
				return true;
			return false;
		}
		void Reset()
		{
			offon = "Off";
			errorcode = "OK";
			speed = null;
			horizontal = null;
			vertical = null;
			time = 0;
		}
		// 0 = off 1 = on
		String offon;
		// 0 = invalid 1 = ok
		String errorcode;
		// 1 = low 2 = high
		String speed;
		// 1 = clockwise 2 = counter-clockwise
		String horizontal;
		// 1 = up 2 = down
		String vertical;
		// time (maximum 255 ms)
		int time;
}