import java.util.Scanner;

public class StringCalcMain {

	public static void main(String[] args) {
		
		StringCalculator calculator = new StringCalculator();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter equation or blank to quit");
		String equation = input.nextLine();
		
		while ( equation.length() > 0 )
		{
			calculator.setEquation(equation);
			System.out.println(calculator.getFirstNumber() + " " + calculator.getOpertor() + " " +  calculator.getSecondNumber() + " = " + calculator.getAnswer() );
			
			System.out.println("Enter equation or blank to quit");
			equation = input.nextLine();			
		}
		

		input.close();

	}

}
