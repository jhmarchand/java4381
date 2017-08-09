
public class IntSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = { 35,28,3,14,7,21,13,6,9,31 };
		
		printIntArray(scores);
		
		sortIntArray(scores);
		
		printIntArray(scores);

	}
	
	private static void sortIntArray(int[] intArray) {
		int[] tempIntArray = new int[intArray.length];
		
		int smallestValue = 100;
		
		for ( int i = 0; i < intArray.length; i++ ) {
			if ( intArray[i] < smallestValue)
				smallestValue = intArray[i];
		}
		
	}

	private static void sortIntArraySwap(int[] intArray) {
	
		int smallestIndex = 0;
		for ( int j = 0; j < intArray.length; j++ ){
			smallestIndex = j;
			for ( int i = j+1; i < intArray.length; i++ ) {
				if ( intArray[i] < intArray[smallestIndex])
					smallestIndex = i;
			}
			int temp = intArray[smallestIndex];
			intArray[smallestIndex] = intArray[j];
			intArray[j] = temp;
		}
		
	}

	private static void printIntArray(int[] intArray) {

		for ( int i = 0; i < intArray.length; i++ ) {
			if ( i > 0 )
				System.out.print(", ");
			System.out.print(intArray[i]);
		}
		System.out.println(" ");
		
	}

}
