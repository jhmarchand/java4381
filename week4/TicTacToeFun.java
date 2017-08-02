
public class TicTacToeFun {

	public static void main(String[] args) {
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		char winner = ' ';
		int turnCount = 1;
		char turn = 'X';
		
		char [] topRow = new char [3];
		char []	middleRow = new char [3];
		char [] bottomRow = new char [3];

		initializeBoard(topRow, middleRow, bottomRow);
		System.out.println("Lets play tic tac toe, X goes first, enter your move.  (example 1 2 is top row middle column)");
	
		while ( turnCount++ < 10 && winner == ' ' ) {
			printBoard(topRow, middleRow, bottomRow);
			
			getMove(input, topRow, middleRow, bottomRow, turn);
			
			winner = checkForWinner(topRow, middleRow, bottomRow);
		
			if ( turn == 'X')
				turn = 'O';
			else
				turn = 'X';
		}
		
		printBoard(topRow, middleRow, bottomRow);	
		
		if ( winner != ' ' )
			System.out.println("Winner is " + winner);
		else
			System.out.println("Cats Game");
		
		input.close();
	}

	private static void getMove(java.util.Scanner input, char[] topRow, char[] middleRow, char[] bottomRow, char turn) {

		int row;
		int column;
		System.out.print("Your Move=>");
		row = input.nextInt();
		column = input.nextInt();
		
		if ( row == 1)
			topRow[column -1] = turn;
		
		if ( row == 2)
			middleRow[column -1] = turn;

		if ( row == 3)
			bottomRow[column -1] = turn;
	}

	private static void printBoard(char[] topRow, char[] middleRow, char[] bottomRow) {
		
		System.out.println(topRow[0] + "_|_" + topRow[1] + "_|_" + topRow[2]);
		System.out.println(middleRow[0] + "_|_" + middleRow[1] + "_|_" + middleRow[2]);
		System.out.println(bottomRow[0] + " | " + bottomRow[1] + " | " + bottomRow[2]);
	}

	private static char checkForWinner(char[] topRow, char[] middleRow, char[] bottomRow) {
		
		char winner = ' ';
		// check for a winner!
		// top row win?
		if ( topRow[0] == topRow[1] && topRow[1] == topRow[2] && topRow[0] != ' ' )
		{
			winner = topRow[0];
		}
		
		// middle row win?
		if ( middleRow[0] == middleRow[1] && middleRow[1] == middleRow[2] && middleRow[0] != ' ' )
		{
			winner = middleRow[0];
		}

		//bottom row win?
		if ( bottomRow[0] == bottomRow[1] && bottomRow[1] == bottomRow[2] && bottomRow[0] != ' ' )
		{
			winner = bottomRow[0];
		}
		
		// check for column win
		for ( int j = 0; j < 3; j++)
		{
			if (topRow[j] == middleRow[j] && middleRow[j] == bottomRow[j] && topRow[j] != ' '  )
			{
				winner = topRow[j];
				break;
			}
		}
		
		// check for a diagnol win
		if (topRow[0] == middleRow[1] && middleRow[1] == bottomRow[2] && topRow[0] != ' ')
		{
			winner = topRow[0];
		}
		
		// check for a diagnol win
		if (topRow[2] == middleRow[1] && middleRow[1] == bottomRow[0] && topRow[2] != ' ')
		{
			winner = topRow[2];
		}
		
		return winner;
	}

	private static void initializeBoard(char[] topRow, char[] middleRow, char[] bottomRow) {
		
		topRow[0] = ' ';
		topRow[1] = ' ';
		topRow[2] = ' ';
		
		middleRow[0] = ' ';
		middleRow[1] = ' ';
		middleRow[2] = ' ';
		
		bottomRow[0] = ' ';
		bottomRow[1] = ' ';
		bottomRow[2] = ' ';
	}

}
