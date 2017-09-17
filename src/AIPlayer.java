public class AIPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	public int playerID;
	public int row;
	public int col;
	Board gameboard;
	static int columncheck [];
	int [] column;
	
	private int AIPlay = 0;
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		gameboard = new Board(row, col);
		this.row = gameboard.getNumRows();
		this.col = gameboard.getNumCols();
		columncheck = new int [this.col];
		for (int i = 0; i < columncheck.length; i++)
		{
			columncheck[i] = 0;
		}
		if (playerID == 1)
		{
			gameboard.setPlayerOne('o');
			gameboard.setPlayerTwo('t');
		}
		else if (playerID == 2)
		{
			gameboard.setPlayerTwo('o');
			gameboard.setPlayerOne('t');
		}
	
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		columncheck[c]++;
		if (getPlayerID() == 1)
		{
			gameboard.play(2, c);
		}
		else if (getPlayerID() == 2)
		{
			gameboard.play(1, c);
		}
	}
	
	//returns column of where to play a token
	public int playToken(){
		if (gameboard.getToken(0, AIPlay) != ' ' /*&& gameboard.canPlay() == true && gameboard.play(getPlayerID(), AIPlay) == true*/)
		{
			if (AIPlay + 1 >= 0 && AIPlay + 1 < gameboard.getNumCols())
			{
				AIPlay++;
			}
		}
		
		gameboard.play(getPlayerID(), AIPlay);
		return AIPlay;
	}
	
	//get this player's id
	public int getPlayerID(){
		return playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		gameboard = new Board(row, col);
	}
}