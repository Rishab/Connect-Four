
public class Board {
	
	private char [][] gameboard; //this is the gameboard 
	private int rows; //this will store the number of rows on the gameboard and return it for use in the get methods 
	private int cols; //this will store the number of columns on the gameboard and return it for use in the get methods
	private char player1; //token representing player1
	private char player2; //token representing player2
	private int count = 0; //will keep track if there is a connect 4
	
	private int winner;

	public Board () //creates a default board of size 7 column x 6 rows
	{
		gameboard = new char [6][7]; // creates an array gameboard of 6 rows and 7 columns
		for (int i = 0; i < 6; i++) // this will be used as rows
		{
			for (int j = 0; j < 7; j++) // this will be used as columns
			{
				gameboard[i][j] = ' ';
				System.out.print(' ');
			}
			System.out.println();
		}
		player1 = 'o';
		player2 = 't';
		rows = 6;
		cols = 7;
		
	}
	
	public Board (int row, int col) //creates a board of size row x col
	{
		if (row <= 0 || col <= 0)
		{
			gameboard = new char [6][7];
			row = 6;
			col = 7;
		}
		gameboard = new char [row][col]; // this creates a gameboard of size of the users choice
		for (int i = 0; i < row; i++) //this will be used as rows 
		{
			for (int j = 0; j < col; j++) // this will be used as columns
			{
				gameboard[i][j] = ' ';
			}
		}
		rows = row; //this will set the parameter equal to 
		cols = col;
		player1 = 'o';
		player2 = 't';
		
	}
	
	public int getNumRows() //returns the number of rows in board
	{
		return rows;	
	}
	
	public int getNumCols() //returns the number of columns in board
	{
		return cols;
	}
	
	public char getPlayerOne() // returns the char representing player 1
	{
		return player1;
	}
	
	public char getPlayerTwo() //returns the char representing player 2
	{
		return player2;	
	}
	
	public void setPlayerOne(char o) // set char representing player1
	{
		player1 = o;
	}
	
	public void setPlayerTwo(char t) //set char representing player 2
	{
		player2 = t;
	}
	
	public char getToken(int row, int col)  
	{
		
		if (row >= rows || col >= cols || row < 0 || col < 0)
		{
			
			return '\0';
		}
		
		else 
		{
			
			return gameboard [row][col];
		}
	}
	
	public boolean canPlay() 
	{
		if (checkHorizontal() == true || checkVertical() == true || checkLeftDiagonal() == true || checkRightDiagonal() == true)
		{
			return false;
		}
		
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				if (gameboard[i][j] == ' ')
				{
					return true;
				}
				
			}
		}
		
		return false;
	}
	
	public boolean play(int p, int c) //places the appropriate token for place p in column c, returns true if successful, false otherwise 
	{
		if (c < 0 || c >= cols)
		{
			return false;
		}
		
		for (int i = rows - 1; i >= 0 ; i--)
		{
			
			if (c < 0 || c >= cols)
			{
				return false;
			}
			if (c <= cols && gameboard[i][c] == ' ')
			{
				if (p == 1)
				{
					gameboard[i][c] = player1;
				
					return true;
				}
				else if (p == 2)
				{
					gameboard[i][c] = player2;
				
					return true;
				}
				else if (p != 1 || p !=2 )
				{
					
					return false;
				}
			}
		}
		return false;
	}
	
	public int isFinished() //returns either the ID of the player who has won (1 or 2) OR 0 if the game has ended in a tie OR -1 if nobody has won yet
	{
		
		if (checkHorizontal() == true || checkVertical() == true || checkLeftDiagonal() == true || checkRightDiagonal() == true)
		{
			return winner;
		}
		
		if (canPlay() == false)
		{
			return 0;
		}
		
		if (canPlay() == false && checkHorizontal() == false && checkVertical() == false && checkLeftDiagonal() == false && checkRightDiagonal() == false)
		{
			return 0;
		}
		
		if (canPlay() == true && checkHorizontal() == false && checkVertical() == false && checkLeftDiagonal() == false && checkRightDiagonal() == false)
		{
			return -1;
		}
		
		return -1;
	}
	
	public boolean checkHorizontal() 
	{
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{	
				if (gameboard[i][j] == getPlayerTwo())
				{
					if (j + 3 < cols && gameboard[i][j] == gameboard[i][j+1] && gameboard[i][j+1] ==  gameboard[i][j+2] && gameboard[i][j+2] ==  gameboard[i][j+3])
					{
						winner = 2;
						return true;
					}
				}
				else if (gameboard[i][j] == getPlayerOne())
				{
					if (j + 3 < cols && gameboard[i][j] == gameboard[i][j+1] && gameboard[i][j+1] ==  gameboard[i][j+2] && gameboard[i][j+2] ==  gameboard[i][j+3])
					{
						winner = 1;
						return true;
					}
				}	
				
			}
		}
			return false;
	}
	
	public boolean checkVertical()
	{
		for (int j = 0; j < cols; j++)
		{
			for (int i = 0; i < rows; i++)
			{
				
				if (gameboard[i][j] == getPlayerTwo())
				{
					if (i + 3 < rows && gameboard[i][j] == gameboard[i+1][j] && gameboard[i+1][j] ==  gameboard[i+2][j] && gameboard[i+2][j] ==  gameboard[i+3][j])
					{
						winner = 2;
						return true;
					}
					
				}
				else if (gameboard[i][j] == getPlayerOne())
				{
					if (i + 3 < rows && gameboard[i][j] == gameboard[i+1][j] && gameboard[i+1][j] ==  gameboard[i+2][j] && gameboard[i+2][j] ==  gameboard[i+3][j])
					{
						winner = 1;
						return true;
					}
				}	
			}
	}
		if (count == 4)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean checkLeftDiagonal()
	{
		int r = 0; //this variable represents the row count as we run through the board. We need it because we cannot change i and j and cover the entire gameboard
		int c = 0; //this variable represents the column count as we run through the board. We need it because we cannot change i and j and cover the entire gameboard
		
		for (int i = 0; i < rows; i++) //this loop will go through the rows and will end once we reach all the rows
		{
			r = i;
			for (int j = 0; j < cols; j++) //this loop will go through the columns and end once we reach the end of a row
			{
				c = j;
				while (r < rows && c < cols) //this loop will go through rows and columns of one diagonal 
				{
						if (gameboard[r][c] == getPlayerOne() && r + 3 < rows && c + 3 < cols && gameboard[r][c] == gameboard[r+1][c+1] && gameboard[r+1][c+1] == gameboard[r+2][c+2] && gameboard[r+2][c+2] == gameboard[r+3][c+3]) // this conditional will check for the condition: is there a connect four or not
						{
							winner = 1;
							return true; //will return true if connect four has been achieved 
						}
						
						if (gameboard[r][c] == getPlayerTwo() && r + 3 < rows && c + 3 < cols && gameboard[r][c] == gameboard[r+1][c+1] && gameboard[r+1][c+1] == gameboard[r+2][c+2] && gameboard[r+2][c+2] == gameboard[r+3][c+3]) // this conditional will check for the condition: is there a connect four or not
						{
							winner = 2;
							return true; //will return true if connect four has been achieved 
						}
						
					else //if no connect four
					{
						r++; //rows will be incremented
						c++; //columns will be incremented
						if (r >= rows || c>= cols)
						{
							r = 0;
							c = 0;
							break;
						}
					}
				}
			}
		}
		return false;
	}    
	
	public boolean checkRightDiagonal()
	{
		int r = 0; //this variable represents the row count as we run through the board. We need it because we cannot change i and j and cover the entire gameboard
		int c = 0; //this variable represents the column count as we run through the board. We need it because we cannot change i and j and cover the entire gameboard
		
		for (int i = 0; i < rows; i++) //this loop will go through the rows and will end once we reach all the rows
		{
			r = i;
			for (int j = cols - 1; j >= 0; j--) //this loop will go through the columns and end once we reach the end of a row
			{
				c = j;
				while (r < rows && c < cols && c >= 0) //this loop will go through rows and columns of one diagonal 
				{
						if (gameboard[r][c] == getPlayerOne() && r + 3 < rows && c - 3 >= 0 && gameboard[r][c] == gameboard[r+1][c-1] && gameboard[r+1][c-1] == gameboard[r+2][c-2] && gameboard[r+2][c-2] == gameboard[r+3][c-3]) // this conditional will check for the condition: is there a connect four or not
						{
							winner = 1;
							return true; //will return true if connect four has been achieved 
						}		
					
						if (gameboard[r][c] == getPlayerTwo() && r + 3 < rows && c - 3 >= 0 && gameboard[r][c] == gameboard[r+1][c-1] && gameboard[r+1][c-1] == gameboard[r+2][c-2] && gameboard[r+2][c-2] == gameboard[r+3][c-3]) // this conditional will check for the condition: is there a connect four or not
						{
							winner = 2;
							return true; //will return true if connect four has been achieved 
						}
					else //if no connect four
					{
						r++; //rows will be incremented
						c--; //columns will be decremented
						if (r >= rows || c < 0)
						{
							r = 0;
							c = 0;
							break;
						}
					}
				}
			}
		}
		return false;
	}   
	
	public void printBoard()
	{
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				System.out.print(gameboard[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println();
	}
}