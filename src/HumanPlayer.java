public class HumanPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	
	public int playerID;
	public int row;
	public int col;
	
	public int tokencolumn;
	static int columncheck [];
	public Board gameboard;
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public HumanPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		this.row = row;
		this.col = col;
		gameboard = new Board(row, col);
		/*for (int i = 0; i < this.row; i++) // this will be used as rows
		{
			for (int j = 0; j < this.col; j++) // this will be used as columns
			{
				
			}
		}*/
		columncheck = new int [this.col];
		for (int i = 0; i < columncheck.length; i++)
		{
			columncheck[i] = 0;
		}
	}
	
	//used to notify your AI player of the other players last move; use this to the value of the last players column number
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
			
		//System.out.println(columncheck[c]);
		
		/*if (getPlayerID() == 1)
		{
			columncheck[c] = countp1++;
			countp2 = countp1;
		}
		else if (getPlayerID() == 2)
		{
			columncheck[c] = countp2++;
			countp1 = countp2;
		}*/
		
			
		
	}
	
	//returns column of where to play a token
	public int playToken(){
		System.out.println("Player " + getPlayerID() + ", where would you like to insert a token?");
		tokencolumn = IO.readInt();
		while (tokencolumn < 0 || tokencolumn >= this.col || columncheck[tokencolumn] >= this.row || gameboard.play(getPlayerID(), tokencolumn) == false)
		{
			IO.reportBadInput();
			tokencolumn = IO.readInt();
		}
		
		return tokencolumn;
	}
	
	//get this player's id
	public int getPlayerID(){
		return playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		gameboard = new Board(row, col);
		/*for (int i = 0; i < this.row; i++)
		{
			for (int j = 0; j < this.col; j++)
			{
				
				//System.out.print(" ");
			}
			//System.out.println();
		}*/
		      
	}

	
}