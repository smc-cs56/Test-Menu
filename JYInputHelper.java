import java.util.*;

public class JYInputHelper // why use abstract class, when this is never extended
{
	public static int showUserInput(int nGroupNumber)
	{
		int nReturn = 0;

		boolean bUserInput = false;
		while (!bUserInput)
		{
			try
		    {
		        nReturn = Integer.parseInt(System.console().readLine());
		        if (nReturn > 0 && nReturn < nGroupNumber)
	        	{
	        		bUserInput = true;
	        	}
	        	else
	        	{
	        		System.out.println("\nERROR: Number should be between 1 and " + nGroupNumber + "!");
		        	System.out.print("Please re-enter:");
	        	}
		    }
		    catch (NumberFormatException ex)
		    {
		        System.out.println("\nERROR: Please enter only numbers from 1 to " + nGroupNumber + "!");
		        System.out.print("Please re-enter:");
		    }
		}

		return nReturn;
	}
}
