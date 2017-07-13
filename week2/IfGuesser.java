
public class IfGuesser {

	public static void main(String[] args) {
	

		// Creates a random number from 0 to 9
		int answer = (int) (Math.random()  * 10);
		
		// you could make your guess using the input scanner, but this is just as good for now.
		int programmersGuess = 7;

		
		if ( programmersGuess == answer )
			System.out.println("You are right! The answer was " + answer);
		
		if ( programmersGuess != answer )
			System.out.println("You are wrong! The answer was " + answer);

		if ( programmersGuess > answer )
			System.out.println(programmersGuess + " was too high!");

		if ( programmersGuess < answer )
			System.out.println(programmersGuess + " was too low!");


	}

}
