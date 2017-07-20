
public class GuessingGameBonus {

	public static void main(String[] args) 
	{
		java.util.Scanner input = new java.util.Scanner(System.in);
		int answer = (int) (Math.random() * 10 );
		int guess = -1;
		int guesses = 0;
		
		System.out.println("Pick a number between 0 and 9");
		
			
		while ( guess != answer)
		{
			// get the users guess
			System.out.println("Enter your guess");
			guess = input.nextInt();
			guesses++;
			
			// check if too high or too low
			if ( guess > answer )
				System.out.println("Too high");

			if ( guess < answer )
				System.out.println("Too low");
		}
		
		System.out.println("Great Job, you got the right answer in " + guesses + " tries!");
			
		input.close();

	}

}
