package objectOrientedPrograms;

public class BlackjackCard extends Card {

	public BlackjackCard(Suit suit, int rank) {
		super(suit, rank);
	}
	
	public int getRank() {
		int value = super.getRank();
		if(value == 1) { return 11;}	// Aces are 11
		if(value < 10) { return value;}
		return 10;
	}
	
	public boolean isAce() {
		return (super.getRank() == 1);
	}
	
}

class Card {
	
	private int rank;
	private Suit suit;
	
	public enum Suit {
		Spades(1),
		Clubs(2),
		Hearts(3),
		Diamonds(4);
		
		int value;
		private Suit(int v) {value = v;}
	}
	
	//Constructor
	public Card(Suit suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public int getRank() { return this.rank;}
	public Suit getSuit() { return this.suit;}
}


