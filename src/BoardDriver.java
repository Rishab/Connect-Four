
public class BoardDriver {
	public static void main(String[] args)
	{
		
		Board test = new Board(4, 4);
	
		//LeftDiagonal Test Case
		/*test.play(1, 1);
		test.play(2, 1);
		test.play(2, 1);
		test.play(2, 1);
		test.play(1, 1);
		test.play(2, 1);
		test.play(2, 2);
		test.play(2, 2);
		test.play(2, 2);
		test.play(1, 2);
		test.play(2, 3);
		test.play(2, 3);
		test.play(2, 3);
		test.play(1, 3);
		test.play(1, 4);
		test.play(1, 4);
		test.play(1, 4);
		test.play(2, 5);
		test.play(1, 5);
		test.play(1, 2);
		*/
		
		//Right Diagonal Test Case
		
		test.play(1, 0);
		test.play(2, 1);
		test.play(1, 2);
		test.play(2, 3);
		test.play(1, 1);
		test.play(2, 2);
		test.play(1, 3);
		test.play(1, 2);
		test.play(2, 3);
		test.play(1, 3);
		
		System.out.println("The winner is Player " + test.isFinished() + ".");
	
	}
}
