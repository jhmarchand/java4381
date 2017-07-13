
public class StringAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// what happens if you dont assign it a value?
		String myString = "Hello, " + "My Name is John.";
		System.out.println(myString);
		
		// adding to strings
		String name = "John";
		int age = 47;
		myString = "My Name is " + name + ", age is " + age;
		System.out.println(myString);
		
		//Does subtraction work?
		//myString = myString - name;
		
		//adding to yourself?
		myString = "The programmer is ";
		myString = myString + name;
		System.out.println(myString);
		

	}

}
