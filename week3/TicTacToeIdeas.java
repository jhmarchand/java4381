
public class TicTacToeIdeas {

	public static void main(String[] args) {
		
		// here 0 is O, 1 is blank, 2 is X
		int[] tic = new int[3]; // top row
		int[] tac = new int[3]; // middle row
		int[] toe = new int[3]; // bottom row
		
		tic[0] = 0;
		tic[1] = 2;
		tic[2] = 1;

		tac[0] = 2;
		tac[1] = 0;
		tac[2] = 1;
		
		toe[0] = 2;
		toe[1] = 1;
		toe[2] = 0;
		
		char[] topRow = new char[3];
		char[] middleRow = new char[3];
		char[] bottomRow = new char[3];
		
		topRow[0] = 'X';
		topRow[1] = ' ';
		topRow[2] = 'O';
		// and on and on.
		
		char[] board = new char[9];
		for( int i = 0; i < board.length ; i++)
			board[i] = ' ';
		
		char[][] tttBoard = new char[3][3];
		tttBoard[1][1] = 'X';

	}

}
