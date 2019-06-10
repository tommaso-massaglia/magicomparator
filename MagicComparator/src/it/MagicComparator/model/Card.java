package it.MagicComparator.model;

public class Card {

	private int amountof;
	private String cardname;

	public Card(int amountof, String cardname) {
		this.amountof = amountof;
		this.cardname = cardname;
	}

	public int getAmountof() {
		return amountof;
	}

	public String getCardname() {
		return cardname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardname == null) ? 0 : cardname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardname == null) {
			if (other.cardname != null)
				return false;
		} else if (!cardname.equals(other.cardname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return amountof +" "+ cardname + "\n";
	}
	
	

}
