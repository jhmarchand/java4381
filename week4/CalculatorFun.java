
public class CalculatorFun {

	public static void main(String[] args) {
		
		int a = 7;
		int b = 8;

		int sum = add(a,b);
		
		System.out.println("sum = " + sum);
		
		int[] testScores = { 90,95,87, 100, 96};
		
		System.out.println("Total of all tests = " + getSum(testScores));
	}

	private static int add(int a, int b) {
		
		int c = 0;
		
		c = a+ b;

		return c;
	}
	
	private static int getSum( int[] intArray) {
		int sum = 0;
		
		for ( int i = 0; i < intArray.length; i++ )
			sum = sum + intArray[i];
		
			return sum;
		
	}
	
	private static double getAverage2(int[] intArray) {
		int sum = 0;
		
		for ( int i = 0; i < intArray.length; i++ )
			sum = sum + intArray[i];
		
		double average = ((double)sum) / intArray.length;
		
		return average;		
	}

}
