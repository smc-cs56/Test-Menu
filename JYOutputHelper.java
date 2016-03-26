import java.util.*;

public abstract class JYOutputHelper
{
	public static void showCardsByGroup(Map<String, Integer> mapData)
	{
		int nIndex = 0;
		int nGroup = 1;
		for (Map.Entry<String, Integer> entry : mapData.entrySet()) {
			
			if (nIndex % 4 == 0)
			{
				System.out.println("---------------");
				System.out.println("Group: " + nGroup);
				System.out.println("");
				nGroup++;
			}

			// Display card
			System.out.println(entry.getKey());

			nIndex++;
		}
	}
}