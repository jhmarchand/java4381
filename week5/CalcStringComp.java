public class CalcStringComp {

	public static void main(String[] args) {
		
		String inputString = "157+64";
		
		int answer = calculateFromString(inputString);
		
		System.out.println(inputString + " = " + answer);
	
	}

	private static int calculateFromString(String equation) {
		
		int answer = 0;
		char [] equationCharArray = equation.toCharArray();
		String numberString = "";
		int a=0;
		int b=0;
		char opChar = ' ';
		
		for( int i = 0; i < equationCharArray.length; i++ ) {
			if ( equationCharArray[i] == '+' || equationCharArray[i] == '-'  || equationCharArray[i] == '*'  || equationCharArray[i] == '/' ) {
				a = Integer.parseInt(numberString);
				numberString = "";
				opChar = equationCharArray[i];
			}
			else {
				numberString = numberString + equationCharArray[i];
			}
		}

		b = Integer.parseInt(numberString);
		
		switch ( opChar )
		{
		case '+':
			answer = a + b;
			break;
		case '-':
			answer = a - b;
			break;
		case '*':
			answer = a * b;
			break;
		case '/':
			answer = a / b;
			break;
			
		}

		return answer;
	}
}