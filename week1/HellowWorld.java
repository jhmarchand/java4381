
public class HellowWorld {

	public static void main(String[] args) {

		System.out.println("Hello World!!!!!!!!!");
		
		String myName = "John";
		int myAge = 47;
		
		System.out.println(myName + " is " + myAge + " years old");
		

		//System.out.println("Enter your name:");
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		System.out.println("Enter your name:");
		String name = scanner.nextLine();

		System.out.println("Enter your age:");
		int age = scanner.nextInt();
		
		System.out.println("Hello, " + name);
		int a, b;
		System.out.print("Enter a number:");
		a = scanner.nextInt();
				
		System.out.print("Enter a number:");
		b = scanner.nextInt();
		
		System.out.println(a + " + " + b + " = " + (a+b));
		
		System.out.println(myName + " is " + age + " years old");
		
		
		scanner.close();
		
		

	}

}
;