
public class GuessingGameFull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner input = new java.util.Scanner(System.in);
		int lowValue = 0;
		int highValue = 9;
		int answer;
		int guess;
		int guesses;
		boolean playAgain = true;
		
		while ( playAgain )
		{
			System.out.println("Pick a number between " + lowValue + " and " + highValue);
			
			answer = (int) (Math.random() * (highValue + 1 )) + lowValue;
			guess = answer-1;
			guesses = 0;
			playAgain = false;
			
			
			while ( guess != answer)
			{
				// get the users guess
				System.out.println("Enter your guess");
				guess = input.nextInt();
				guesses++;
				
				if ( guess > answer )
					System.out.println("Too high");
	
				if ( guess < answer )
					System.out.println("Too low");
			}
			
			System.out.println("Great Job, you got the right anwser in " + guesses + " tries!");
			
			System.out.println("Would you like to play again?");
			if ( input.next().toLowerCase().equals("yes") )
				playAgain = true;
		}
		input.close();

	}


}
