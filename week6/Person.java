public class Person {
	
	String firstName;
	String lastName;
	int age;
	
	Person()
	{
		firstName = "";
		lastName = "";
		age = 0;
	}
	
	Person(String aFirstName, String aLastName, int anAge) {
		firstName = aFirstName;
		lastName = aLastName;
		age = anAge;
	}
	
	void haveABirthday() {
		age++;
	}
	
	String GetFullName()
	{
		String fullName;
		fullName = firstName + " " + lastName;
		return fullName;
	}
	
	String GetFullName2()
	{
		return firstName + " " + lastName;
	}
	
}