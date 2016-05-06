import java.util.*;

public class JYUtil // no need to be abstract. it's never extended
{
	private JYUtil()
	{

	}

	
	 // Purpose: get a random number from min to max
	 //
	 // Param: int - min and max
	 //
	 // Return: a random number btwn min and max
	public static int randomNumber(int min, int max) {

	    Random rand = new Random();
	    int randomNum = rand.nextInt(max - min + 1) + min;

	    return randomNum;
	}

	public static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {

		// Convert Map to List
		List<Map.Entry<String, Integer>> list = 
			new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
                                           Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// Convert sorted map back to a Map
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
			Map.Entry<String, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	public static Map.Entry getEntry(Map<String, Integer> mapData, int id) {
        Iterator iterator = mapData.entrySet().iterator();
        int n = 0;
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            if(n == id){
                return entry;
            }
            n++;
        }
        return null;
    }

	public static List<String> getKeyFromValue(Map<String, Integer> mapData, int nValue) {
		
		List<String> lsReturn = new ArrayList<String>();
		
		for (Map.Entry<String, Integer> entry : mapData.entrySet()) {
			if (entry.getValue().equals(nValue))
			{
				lsReturn.add(entry.getKey());
			}
		}

		return lsReturn;
	}

	public static Map<String, Integer> createMapData(int nGroupNumber, int nCardNumber)
	{
		Map<String, Integer> mapReturn = new HashMap<String, Integer>();

		// Number of groups
		for (int nGroup = 1; nGroup <= nGroupNumber; nGroup++)
		{
			// Number of cards
			for (int nCard = 1; nCard <= nCardNumber; nCard++)
			{
				// Check duplicates
				boolean bExist = false;
				while (!bExist)
				{
					// A(1), 2-10, J(11), Q(12), K(13)
					int nRandomNumber = JYUtil.randomNumber(1, 13);

					// Spade(1), Heart(2) Diamond(3), Club(4)
					int nRandomSuit = JYUtil.randomNumber(1, 4);

					String szCard = JYUtil.convertCardNumber(nRandomNumber) + " " + JYUtil.convertCardSuit(nRandomSuit);

					// check if szCard is already in mapReturn. If not, add it in
					// and get out of while loop
			        	if (!mapReturn.containsKey(szCard))
			        	{
			            		mapReturn.put(szCard, nGroup);
			        		bExist = true;
			        	}
				}
			}
		}

		return mapReturn;
	}

	public static Map<String, Integer> regroupWithSelectedGroup(int nGroupNumber, int nCardNumber, List<String> lsCards)
	{
		Map<String, Integer> mapReturn = new HashMap<String, Integer>();

		int nIndexSelectedCard = 0;
		for (int nNewGroup = 1; nNewGroup <= nGroupNumber; nNewGroup++)
		{
			int nAddSelectedCard = JYUtil.randomNumber(1, 4);
			//System.out.println("nAddSelectedCard: " + nAddSelectedCard);
			for (int nCard = 1; nCard <= nCardNumber; nCard++)
			{
				if (nCard == nAddSelectedCard)
				{
					mapReturn.put(lsCards.get(nIndexSelectedCard).toString(), nNewGroup);
					nIndexSelectedCard++;
				}
				else
				{
					// Check duplicates
					boolean bExist = false;
					while (!bExist)
					{
						// A(1), 2-10, J(11), Q(12), K(13)
						int nRandomNumber = JYUtil.randomNumber(1, 13);

						// Spade(1), Heart(2) Diamond(3), Club(4)
						int nRandomSuit = JYUtil.randomNumber(1, 4);

						String szCard = JYUtil.convertCardNumber(nRandomNumber) + " " + JYUtil.convertCardSuit(nRandomSuit);

				        if (!mapReturn.containsKey(szCard) && !lsCards.contains(szCard))
				        {
				            mapReturn.put(szCard, nNewGroup);
				        	bExist = true;
				        }
					}
				}
			}
		}

		return mapReturn;
	}
	
	 // Purpose: creates a string representation of nCardNumber. If 2 <= nCardNumber <= 10,
	 // no need to enter switch statement
	 //
	 // Param: Integer - the card number (1-13)
	 //
	 // Return: string representation of nCardNumber
	public static String convertCardNumber(Integer nCardNumber)
	{
		String szReturn = nCardNumber.toString();

		switch (nCardNumber)
		{
			case 1:
				szReturn = "A";
				break;

			case 11:
				szReturn = "J";
				break;

			case 12:
				szReturn = "Q";
				break;

			case 13:
				szReturn = "K";
				break;
		}

		return szReturn;
	}
	
	 // Purpose: creates a string representation of nCardSuit. 
	 // Card is either Spade, Heart, Diamond, Club
	 // 
	 // Param: Integer - Card suit (1-4)
	 //
	 // Return: string representation of nCardSuit
	public static String convertCardSuit(Integer nCardSuit)
	{
		String szReturn = "";

		switch (nCardSuit)
		{
			case 1:
				szReturn = "Spade";
				break;

			case 2:
				szReturn = "Heart";
				break;

			case 3:
				szReturn = "Diamond";
				break;

			case 4:
				szReturn = "Club";
				break;
		}

		return szReturn;
	}
}
