
public class ArrayExampleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String myString = "55,87,436";
		char[] charArray = myString.toCharArray();
		
		int position = 0;
		
		String numberString = "";
		
		while ( position < charArray.length )
		{
			if ( charArray[position] != ',')
			{
				numberString = numberString + charArray[position];
			}
			else
			{
				System.out.println(numberString);
				numberString = "";
			}
			position++;
		} 
		
		if ( numberString.length() > 0 )
			System.out.println(numberString);
		

	}


}
