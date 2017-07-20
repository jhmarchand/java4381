
public class TypesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean roboticsIsCool = true;
		boolean thisClassIsBoring = false;
		
		if ( thisClassIsBoring )
			System.out.println("I want to go home");
		else 
			System.out.println("Lets Learn some Java");
		
		boolean fiveIsLessThanSix = 5 < 6;
		
		double pi = 3.14;
		double diameter = 3.0;
		double circumference = pi * diameter;
		
		// 10.7 is consider a double, so going down to 
		float floatVariable = (float) 10.7;
		
		int radius = 5;
		double area = pi * radius * radius;
		System.out.println("Area = " + area );
		
		//int intArea = pi * radius * radius;
		
		int intPi = (int) pi;
		int intArea = intPi * radius * radius;
		System.out.println("Area = " + intArea );
		
		char myChar = 'J';
		String message = "My Name is ";
		message = message + myChar + 'o' + 'h' + 'n';
		System.out.println(message);
		

	}

}
