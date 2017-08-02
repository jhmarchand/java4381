public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		int row = 0;
		int column = 0;
		boolean weHaveAWinner = false;
		char winner = ' ';
		
		char [] topRow = new char [3];
		char []	middleRow = new char [3];
		char [] bottomRow = new char [3];
		
		char turn = 'X';
	
		topRow[0] = ' ';
		topRow[1] = ' ';
		topRow[2] = ' ';
		
		middleRow[0] = ' ';
		middleRow[1] = ' ';
		middleRow[2] = ' ';
		
		bottomRow[0] = ' ';
		bottomRow[1] = ' ';
		bottomRow[2] = ' ';

		System.out.println("Lets play tic tac toe, X goes first, enter your move.  (example 1 2 is top row middle column)");
	
		for ( int i = 1; i < 10; i++)
		{
			// Show the board and get the users move
			System.out.println(topRow[0] + "_|_" + topRow[1] + "_|_" + topRow[2]);
			System.out.println(middleRow[0] + "_|_" + middleRow[1] + "_|_" + middleRow[2]);
			System.out.println(bottomRow[0] + " | " + bottomRow[1] + " | " + bottomRow[2]);
			
			System.out.print("Your Move=>");
			row = input.nextInt();
			column = input.nextInt();
			
			if ( row == 1)
				topRow[column -1] = turn;
			
			if ( row == 2)
				middleRow[column -1] = turn;

			if ( row == 3)
				bottomRow[column -1] = turn;
			
			// check for a winner!
			// top row win?
			if ( topRow[0] == topRow[1] && topRow[1] == topRow[2] && topRow[0] != ' ' )
			{
				weHaveAWinner = true;
				winner = turn;
			}
			
			// middle row win?
			if ( middleRow[0] == middleRow[1] && middleRow[1] == middleRow[2] && middleRow[0] != ' ' )
			{
				weHaveAWinner = true;
				winner = turn;
			}

			//bottom row win?
			if ( bottomRow[0] == bottomRow[1] && bottomRow[1] == bottomRow[2] && bottomRow[0] != ' ' )
			{
				weHaveAWinner = true;
				winner = turn;
			}
			
			// check for column win
			for ( int j = 0; j < 3; j++)
			{
				if (topRow[j] == middleRow[j] && middleRow[j] == bottomRow[j] && topRow[j] != ' '  )
				{
					weHaveAWinner = true;
					winner = turn;
				}
			}
			
			// check for a diagnol win
			if (topRow[0] == middleRow[1] && middleRow[1] == bottomRow[2] && topRow[0] != ' ')
			{
				weHaveAWinner = true;
				winner = turn;
			}
			
			// check for a diagnol win
			if (topRow[2] == middleRow[1] && middleRow[1] == bottomRow[0] && topRow[2] != ' ')
			{
				weHaveAWinner = true;
				winner = turn;
			}
			
			if ( weHaveAWinner )
				break;
			
			if ( turn == 'X')
				turn = 'O';
			else
				turn = 'X';
		}
		
		System.out.println(topRow[0] + "_|_" + topRow[1] + "_|_" + topRow[2]);
		System.out.println(middleRow[0] + "_|_" + middleRow[1] + "_|_" + middleRow[2]);
		System.out.println(bottomRow[0] + " | " + bottomRow[1] + " | " + bottomRow[2]);	
		
		if ( weHaveAWinner )
			System.out.println("Winner is " + winner);
		else
			System.out.println("Cats Game");
		
		input.close();
		
	}

}
