import java.util.Scanner;

public class StringCalcMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter equation or blank to quit");
		String equation = input.nextLine();
		
		while ( equation.length() > 0 )
		{
			StringCalculator.setEquation(equation);
			System.out.println(StringCalculator.getFirstNumber() + " " + StringCalculator.getOpertor() + " " +  StringCalculator.getSecondNumber() + " = " + StringCalculator.getAnswer() );
			
			System.out.println("Enter equation or blank to quit");
			equation = input.nextLine();			
		}

		input.close();
	}

}
