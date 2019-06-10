package it.MagicComparator.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Model {

	public List<Card> merge(String first, String second) {

		Map<String, Card> firstl = new HashMap<String, Card>();
		Map<String, Card> secondl = new HashMap<String, Card>();
		List<Card> merged = new LinkedList<Card>();

		String[] split = first.split("\n");

		for (String line : split) {
			if (!line.equals("Sideboard") && !line.equals("")) {
				String[] card = line.split(" ", 2);
				firstl.put(card[1], new Card(Integer.parseInt(card[0]), card[1]));
			}
		}

		System.out.println(firstl.values());
		System.out.println("Second List:\n");

		split = second.split("\n");

		for (String line : split) {
			if (!line.equals("Sideboard") && !line.equals("")) {
				String[] card = line.split(" ", 2);
				secondl.put(card[1], new Card(Integer.parseInt(card[0]), card[1]));
			}
		}

		System.out.println(secondl.values());

		for (Card c : firstl.values()) {
			if (c.getCardname().equals("Mountain") || c.getCardname().equals("Swamp")
					|| c.getCardname().equals("Island") || c.getCardname().equals("Forest")
					|| c.getCardname().equals("Plains"))
				merged.add(new Card((c.getAmountof() + secondl.get(c.getCardname()).getAmountof()), c.getCardname()));
			else if (secondl.containsKey(c.getCardname())) {
				if ((c.getAmountof() < secondl.get(c.getCardname()).getAmountof()))
					merged.add(secondl.get(c.getCardname()));
				else
					merged.add(c);
			} else {
				merged.add(c);
			}
		}
		for (Card c : secondl.values()) {
			if (!merged.contains(c)) {
				merged.add(c);
			}
		}

		System.out.println(merged);

		return merged;
	}

}
