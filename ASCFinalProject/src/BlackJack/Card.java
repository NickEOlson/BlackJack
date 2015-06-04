package BlackJack;

public class Card 
{
	private String suit;
	private String num;
	private int val;
	
	public Card(String suit1, String num1, int val1)
	{
		suit = suit1;
		num = num1;
		val = val1;
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	public String getNum()
	{
		return num;
	}
	
	public int getVal()
	{
		return val;
	}
}
