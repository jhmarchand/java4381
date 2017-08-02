import javax.print.DocFlavor.STRING;

public class CalculatorString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputString = "57+64";
		
		int answer = calculateFromString(inputString);
		System.out.println("answer = " + answer);
	
	}

	private static int calculateFromString(String inputString) {
		int answer;
		char [] inputCharArray = inputString.toCharArray();
		String numberString = "";
		int a=0;
		int b=0;
		
		for( int i = 0; i < inputCharArray.length; i++ ) {
			if (inputCharArray[i] == '+' ) {
				a = Integer.parseInt(numberString);
				numberString = "";
			}
			else {
				numberString = numberString + inputCharArray[i];
			}
		}
		b = Integer.parseInt(numberString);
		
		answer = a + b;
		return answer;
	}

}
