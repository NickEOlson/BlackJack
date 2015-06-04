package BlackJack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Game 
{
	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> dealerHand = new ArrayList<Card>();
	private Deck deck = new Deck();
	private boolean playerDone = false;
	private boolean dealerDone = false;
	private boolean playAgain = true;
	private Card dealerFirst = null;
	
	public Game()
	{
		hand = new ArrayList();
		dealerHand = new ArrayList();
		deck.shuffle();
		drawCard(deck.draw());
		dealerFirst = deck.draw();
		dealerDrawCard(dealerFirst);
		drawCard(deck.draw());
		dealerDrawCard(deck.draw());
	}
	
	public void drawCard(Card draw)
	{
		System.out.println("You drew a " + draw.getNum() + " of " + draw.getSuit());
		hand.add(draw);
	}
	
	public void dealerDrawCard(Card draw)
	{
		System.out.println("Dealer drew a card");
		dealerHand.add(draw);
	}
	
	public int getTotal()
	{
		int total = 0;
		for(Card x: hand)
		{
			total += x.getVal();
		}
		return total;
	}
	
	public int getDealerTotal()
	{
		int total = 0;
		for(Card x: dealerHand)
		{
			total += x.getVal();
		}
		return total;
	}
	
	public boolean isPlayerDone()
	{
		return playerDone;
	}
	
	public boolean isDealerDone()
	{
		return dealerDone;
	}
	
	public boolean getPlayAgain()
	{
		return playAgain;
	}
	
	public int numCardsDealer()
	{
		int num = 0;
		for(Card x: dealerHand)
		{
			num++;
		}
		return num - 1;
	}
	
	public String getHand()
	{
		String temp = "\n";
		for(Card x: hand)
		{
			temp += x.getNum() + " of " + x.getSuit() + "\n";
		}
		return temp;
	}
		
	public boolean bust()
	{
		if(getTotal() > 21)
			return true;
		else return false;
	}
	
	public boolean dealerBust()
	{
		if(getDealerTotal() > 21)
			return true;
		else return false;
	}
	
	public boolean blackjack()
	{
		if(getTotal() == 21)
			return true;
		else return false;
	}
	
	public boolean dealerBlackjack()
	{
		if(getDealerTotal() == 21)
			return true;
		else return false;
	}

	public void action()
	{
		Scanner scan = new Scanner(System.in);
		if(playerDone && dealerDone)
		{
			if(getDealerTotal() > getTotal())
			{
				System.out.println("Dealer wins with " + getDealerTotal() + " to your " + getTotal());
				playAgain();
			}
			else if(getDealerTotal() < getTotal())
			{
				System.out.println("You win with " + getTotal() + " to the dealers " + getDealerTotal());
				playAgain();
			}
			else
			{
				System.out.println("Tie. You both had " + getTotal() + ". No one wins");
				playAgain();
			}
		}
		else
		{
			System.out.print("\nYour hand:" + getHand());
			System.out.println("Your total: " + getTotal() + "\n");
			System.out.println("The dealers has " + dealerFirst.getNum() + " of " + dealerFirst.getSuit() + " and " + numCardsDealer() + " other card(s)\n");
			System.out.println("Please enter h to hit or s to stay");
			String input = scan.nextLine();
			if(playerDone)
			{
				dealerAction();
			}
			else if(input.equalsIgnoreCase("h"))
			{
				drawCard(deck.draw());
				if(bust())
				{
					System.out.println("Bust!\nYou lose");
					playAgain();
				}
				else if(blackjack())
				{
					System.out.println("Blackjack!\nYou win");
					playAgain();
				}
				else dealerAction();
			}
			else if(input.equalsIgnoreCase("s"))
			{
				playerDone = true;
				dealerAction();
			}
			else
			{
				System.out.println("Please enter s or h to hit or stay");
				action();
			}
		}
	}
	
	public void dealerAction()
	{
		if(getDealerTotal() < 17)
		{
			dealerDrawCard(deck.draw());
			if(dealerBust())
			{
				System.out.println("Dealer busts!\nYou win");
				playAgain();
			}
			else if(dealerBlackjack())
			{
				System.out.println("Dealer has blackjack!\nYou lose");
				playAgain();
			}
			action();
		}
		else
		{
			dealerDone = true;
			action();
		}		
	}
	
	public void playAgain()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to play again?(y/n)");
		String input = scan.nextLine();
		if(input.equalsIgnoreCase("y"))
		{
			deck.shuffle();
		}
		else if(input.equalsIgnoreCase("n"))
		{
			playAgain = false;
		}
		else
		{
			System.out.println("Please enter y or n");
			playAgain();
		}
	}
}