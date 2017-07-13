
public class AddingMachine {

	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);

		System.out.println("Enter a number");
		int firstNumber = scanner.nextInt();
		
		System.out.println("Enter a number");
		int secondNumber = scanner.nextInt();
		
		int sum = firstNumber + secondNumber;
		
		// 2 of these are right, do you know which ones?
		System.out.println(firstNumber + " + " + secondNumber + " = " + sum);
		System.out.println(firstNumber + " + " + secondNumber + " = " + firstNumber + secondNumber);
		System.out.println(firstNumber + " + " + secondNumber + " = " + ( firstNumber + secondNumber) );
	}

}
