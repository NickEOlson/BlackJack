package BlackJack;

public class BlackJackPlayer 
{

	public static void main(String[] args) 
	{
		Game play = new Game();
		while(play.getPlayAgain())
		{	
			play.action();
			if(play.getPlayAgain())
			{
				play = new Game();
			}
		}
	}

}
