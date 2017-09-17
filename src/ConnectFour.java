public class ConnectFour{
	
	
	public static void main(String[] args){	
		//Create new board object
		Board gameboard = new Board(6,7);
		CFGUI C4Interface = new CFGUI(gameboard, ChipColor.BLACK, ChipColor.RED);
		//Set player tokens for player 1 and player 2
		gameboard.setPlayerOne('x');
		gameboard.setPlayerTwo('o');
		int playp1;
		int playp2 = 0;
		//Create Player objects
		//Note, the code below works because of the interface Player. All classes that "implement" Player can be
		// typed as Player. Makes switching from Human to AI Players really easy. For a challenge, you might
		// consider:
		//		1. asking the user whether he/she wants to play against a human or a computer
		//		2. implementing multiple AI players (easy, med, hard) that the user can choose to play against
		
		Player p1 = new HumanPlayer(1,6,7);
		Player p2 = new HumanPlayer(2,6,7); //comment this line when testing AIPlayer
		Player reset = null;	
		//Player p2 = new AIPlayer(2,6,7); //uncomment this line when testing AIPlayer
		
		
		//Print your empty board
		gameboard.printBoard();
		
		//WHILE the board is still playable
		//	get a column to play from player 1
		//	play that token on the board
		//  print the board
		//		has anyone won yet?
		// do the above for player 2
		while (gameboard.isFinished() == -1)
		{
			p1.getPlayerID();
			playp1 = p1.playToken();
			gameboard.play(p1.getPlayerID(), playp1);
			p2.lastMove(playp1);
			gameboard.printBoard();
			C4Interface.redraw();
			if (gameboard.isFinished() == p1.getPlayerID())
			{
				break;
			}
			else if (gameboard.isFinished()  == p2.getPlayerID())
			{
				break;
			}
			
			p2.getPlayerID();
			playp2 = p2.playToken();
			gameboard.play(p2.getPlayerID(), playp2);
			p1.lastMove(playp2);
			gameboard.printBoard();
			C4Interface.redraw();
			if (gameboard.isFinished() == p1.getPlayerID())
			{
				break;
			}
			else if (gameboard.isFinished()  == p2.getPlayerID())
			{
				break;
			}
			
		}
		// Get the status code from the board (isFinished())
		if (gameboard.isFinished() == 1)
		{
			C4Interface.gameOver(p1.getPlayerID());
			System.out.println("Player 1 wins");
		}
		else if (gameboard.isFinished() == 2)
		{
			C4Interface.gameOver(p2.getPlayerID());
			System.out.println("Player 2 wins");
		}
		else if (gameboard.isFinished() == 0)
		{
			System.out.println("Player 1 and PLayer 2 have tied.");
		}
		// Print out the results of the game
		gameboard.printBoard();
		
		
		/*if (IO.readString().equalsIgnoreCase("Yes"))
		{
			if (gameboard.isFinished() == 1)
			{
				gameboard = new Board(gameboard.getNumRows(), gameboard.getNumCols());
				p1.reset();
			}
			else if (gameboard.isFinished() == 2)
			{
				gameboard = new Board(gameboard.getNumRows(), gameboard.getNumCols());
				p2.reset();
			}
		}*/
		
	}	
}