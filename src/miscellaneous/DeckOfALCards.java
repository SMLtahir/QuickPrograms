package miscellaneous;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class DeckOfALCards {

	public static void main(String[] args) {

		DeckOfALCards deck = new DeckOfALCards();
//		deck.dealCard();
		System.out.println("Testing");

	}

	private ArrayList<Card> deck;
	 
	  public DeckOfALCards ()
	  {
	    this.deck = new ArrayList<Card>();
	    for (int i=0; i<13; i++)
	    {
	      CardValue value = CardValue.values()[i];
	 
	      for (int j=0; j<4; j++)
	      {
	        Card card = new Card(value, Suit.values()[j]);
	        this.deck.add(card);
	      }
	    }
	    
	    Iterator<Card> cardIterator = deck.iterator();
	    while (cardIterator.hasNext())
	    {
	      Card aCard = cardIterator.next();
	      System.out.println(aCard.getCardValue() + " of " + aCard.getSuit());
	    }
	 
	  }
	  
	  public void shuffle()	{
		  Collections.shuffle(deck, new SecureRandom());  
	  }
	  
	  public Card dealCard()	{
		  if(deck.size() != 0)	{
			Card card = deck.get(0);
			deck.remove(0);
			return card;
		  }
		  return null;
	  }
}

enum CardValue	{
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  EIGHT(8),
  NINE(9),
  TEN(10),
  JACK(11),
  QUEEN(12),
  KING(13),
  ACE(14);
 
  private int cardValue;
 
  private CardValue (int value)
  {
    this.cardValue = value;
  }
 
  public int getCardValue() {
    return cardValue;
  }
}

enum Suit	{
	  HEARTS,
	  SPADES,
	  CLUBS,
	  DIAMONDS;
}

class Card
{
  private Suit suit;
  private CardValue cardValue;
 
  public Card (CardValue cardValue, Suit suit)
  {
    this.cardValue = cardValue;
    this.suit = suit;
  }
 
  public Suit getSuit()
  {
    return suit;
  }
 
  public void setSuit(Suit suit)
  {
    this.suit = suit;
  }
 
  public CardValue getCardValue()
  {
    return cardValue;
  }
 
  public void setCardValue(CardValue cardValue)
  {
    this.cardValue = cardValue;
  }
}