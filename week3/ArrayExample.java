
public class ArrayExample {
	
	public static void main(String[] args) {

		int[] intArray = new int[3];
		
		intArray[0] = 3;
		intArray[1] = 2;
		intArray[2] = 7;
			
		int sum = 0;
		
		for ( int i = 0; i < intArray.length; i++ )
			sum = sum + intArray[i];
		
		System.out.println(sum);

	}	

}
