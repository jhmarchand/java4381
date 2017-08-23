public class StringCalculator {

	static private String equation = "";
	static private int firstNumber;
	static private int secondNumber;
	static private int answer;
	static private char operator = ' ';
	
	static public String getEquation() {
		return equation;
	}

	static public void setEquation(String aEquation) {
		equation = aEquation;
		processEquation();
	}
	
	static public int getFirstNumber() {
		return firstNumber;
	}
	
	static public int getSecondNumber() {
		return secondNumber;
	}
	static public int getAnswer() {
		return answer;
	}
	static public char getOpertor() {
		return operator;
	}
	

	static private void processEquation() {

		answer = 0;
		char [] equationCharArray = equation.toCharArray();
		String numberString = "";
		firstNumber=0;
		secondNumber=0;
		operator = ' ';
		
		for( int i = 0; i < equationCharArray.length; i++ ) {
			if ( equationCharArray[i] == '+' || equationCharArray[i] == '-'  || equationCharArray[i] == '*'  || equationCharArray[i] == '/' ) {
				firstNumber = Integer.parseInt(numberString);
				numberString = "";
				operator = equationCharArray[i];
			}
			else {
				numberString = numberString + equationCharArray[i];
			}
		}

		secondNumber = Integer.parseInt(numberString);
		
		switch ( operator )
		{
		case '+':
			answer = firstNumber + secondNumber;
			break;
		case '-':
			answer = firstNumber - secondNumber;
			break;
		case '*':
			answer = firstNumber * secondNumber;
			break;
		case '/':
			answer = firstNumber / secondNumber;
			break;
	
		}
	}
	
}
