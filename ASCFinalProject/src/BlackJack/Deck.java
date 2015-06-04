package BlackJack;

import java.util.ArrayList;
import java.util.LinkedList;

public class Deck 
{
	ArrayList<Card> cards = new ArrayList<Card>();
	LinkedList<Card> deck = new LinkedList<Card>();
	
	public Deck()
	{
		
	}
	
	public void shuffle()
	{
		cards.add(new Card("Spades","Ace",11));
		cards.add(new Card("Spades","Two",2));
		cards.add(new Card("Spades","Three",3));
		cards.add(new Card("Spades","Four",4));
		cards.add(new Card("Spades","Five",5));
		cards.add(new Card("Spades","Six",6));
		cards.add(new Card("Spades","Seven",7));
		cards.add(new Card("Spades","Eight",8));
		cards.add(new Card("Spades","Nine",9));
		cards.add(new Card("Spades","Ten",10));
		cards.add(new Card("Spades","Jack",10));
		cards.add(new Card("Spades","Queen",10));
		cards.add(new Card("Spades","King",10));
		cards.add(new Card("Hearts","Ace",11));
		cards.add(new Card("Hearts","Two",2));
		cards.add(new Card("Hearts","Three",3));
		cards.add(new Card("Hearts","Four",4));
		cards.add(new Card("Hearts","Five",5));
		cards.add(new Card("Hearts","Six",6));
		cards.add(new Card("Hearts","Seven",7));
		cards.add(new Card("Hearts","Eight",8));
		cards.add(new Card("Hearts","Nine",9));
		cards.add(new Card("Hearts","Ten",10));
		cards.add(new Card("Hearts","Jack",10));
		cards.add(new Card("Hearts","Queen",10));
		cards.add(new Card("Hearts","King",10));
		cards.add(new Card("Clubs","Ace",11));
		cards.add(new Card("Clubs","Two",2));
		cards.add(new Card("Clubs","Three",3));
		cards.add(new Card("Clubs","Four",4));
		cards.add(new Card("Clubs","Five",5));
		cards.add(new Card("Clubs","Six",6));
		cards.add(new Card("Clubs","Seven",7));
		cards.add(new Card("Clubs","Eight",8));
		cards.add(new Card("Clubs","Nine",9));
		cards.add(new Card("Clubs","Ten",10));
		cards.add(new Card("Clubs","Jack",10));
		cards.add(new Card("Clubs","Queen",10));
		cards.add(new Card("Clubs","King",10));
		cards.add(new Card("Diamonds","Ace",11));
		cards.add(new Card("Diamonds","Two",2));
		cards.add(new Card("Diamonds","Three",3));
		cards.add(new Card("Diamonds","Four",4));
		cards.add(new Card("Diamonds","Five",5));
		cards.add(new Card("Diamonds","Six",6));
		cards.add(new Card("Diamonds","Seven",7));
		cards.add(new Card("Diamonds","Eight",8));
		cards.add(new Card("Diamonds","Nine",9));
		cards.add(new Card("Diamonds","Ten",10));
		cards.add(new Card("Diamonds","Jack",10));
		cards.add(new Card("Diamonds","Queen",10));
		cards.add(new Card("Diamonds","King",10));
		for(int i = 52; i > 0; i--)
		{
				int randy = (int)(Math.random()*i);
				deck.add(cards.get(randy));
				cards.remove(randy);
		}
	}
	
	public Card draw()
	{
		return deck.pop();
	}
}
