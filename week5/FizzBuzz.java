
public class FizzBuzz {

	public static void main(String[] args) {
		// This is a program that prints out numbers from 1 to 100, for multiples of 3 it prints fizz, 
		//for multiples of 5 it prints buzz and for multiples of both fizz buzz
		
		fb3();
		
		

	}
	
	private static void fb3() {
		
		String[] words = { "fizz", "buzz", "kong" };
		int[] nums = { 3,5,7};
		
		String[] printOut = new String[100];
		
		for ( int i = 1; i< 101 ; i ++)
			printOut[i-1] = Integer.toString(i);
		
		for ( int j = 0; j < nums.length; j++) {
			for ( int i = nums[j]; i< 101 ; i+=nums[j])
				printOut[i-1] = words[j];
		}
		
		
		
		
		for ( int i = 1; i< 101 ; i ++)
			System.out.println(printOut[i-1]);
		

	}	
	
	private static void fb2() {
		String[] printOut = new String[100];
		
		for ( int i = 1; i< 101 ; i ++)
			printOut[i-1] = Integer.toString(i);
		
		for ( int i = 3; i< 101 ; i+=3)
			printOut[i-1] = "Fizz";
		
		for ( int i = 5; i< 101 ; i+=5)
			printOut[i-1] = "Buzz";
		
		for ( int i = 15; i< 101 ; i+=15)
			printOut[i-1] = "Fizz Buzz";
		
		for ( int i = 1; i< 101 ; i ++)
			System.out.println(printOut[i-1]);
		

	}

	private static void fb1() {
		int i = 1;
		while ( i < 101 )
		{
			while ( i%3 != 0 && i%5 != 0)
				System.out.println(i++);
			while ( i%15 == 0 )
			{
				System.out.println("fizz buzz");
				i++;
			}
			while ( i%3 == 0 )
			{
				System.out.println("fizz");
			i++;
			}
			
			while ( i%5 == 0 )
			{
				System.out.println("buzz");
			i++;
			}

				

			
		}
	}

}
