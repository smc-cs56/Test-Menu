import java.util.*;

public class JYCardTrick
{
	protected final int nGroupNumber = 4;
	protected final int nCardNumber = 4;
	private Map<String, Integer> mapCards;
	private List<String> selectedCards;
	private int nSelectedGroup;

	private JYCardTrick()
	{
		mapCards = JYUtil.createMapData(nGroupNumber, nCardNumber);

		if (mapCards.size() > 0)
		{
			// Sort map by value
			mapCards = JYUtil.sortByComparator(mapCards);

			// Sort cards by group
			JYOutputHelper.showCardsByGroup(mapCards);

			System.out.println("");
			System.out.print("Choose your card & Select a group(1~" + nGroupNumber + "): ");
			nSelectedGroup = JYInputHelper.showUserInput(nGroupNumber);

			// Replace data with cards from selected group
			selectedCards = JYUtil.getKeyFromValue(mapCards, nSelectedGroup);

			// Create new groups and split selected group cards
			mapCards = JYUtil.regroupWithSelectedGroup(nGroupNumber, nCardNumber, selectedCards);

			// Sort cards by group
			mapCards = JYUtil.sortByComparator(mapCards);

			JYOutputHelper.showCardsByGroup(mapCards);

			System.out.println("");
			System.out.print("Where is your card? Select a group(1~" + nGroupNumber + "): ");
			nSelectedGroup = JYInputHelper.showUserInput(nGroupNumber);

			for (Map.Entry<String, Integer> entry : mapCards.entrySet()) {
				if (entry.getKey() == selectedCards.get(nSelectedGroup - 1))
				{
					System.out.println("Your card is " + entry.getKey());
					break;
				}
			}
		}
	}

	public static void main(String[] args) {

		JYCardTrick cardTrick = new JYCardTrick();

	}

	
}