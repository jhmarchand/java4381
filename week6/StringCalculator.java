
public class StringCalculator {

	private String equation;
	private int firstNumber;
	private int secondNumber;
	private int answer;
	private char operator;
	
	public StringCalculator()
	{
		equation = "";
		firstNumber = 0;
		secondNumber = 0;
		answer = 0;
		operator = ' ';
	}
	
	public StringCalculator(String aEquation)
	{
		setEquation(aEquation);
	}
	
	public String getEquation() {
		return equation;
	}

	public void setEquation(String aEquation) {
		equation = aEquation;
		processEquation();
	}
	
	public int getFirstNumber() {
		return firstNumber;
	}
	
	public int getSecondNumber() {
		return secondNumber;
	}
	public int getAnswer() {
		return answer;
	}
	public char getOpertor() {
		return operator;
	}
	

	private void processEquation() {

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
