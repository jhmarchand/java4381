
public class Person {
	
	String firstName;
	int age;
	
	Person(String aFirstName, int anAge) {
		firstName = aFirstName;
		age = anAge;
	}
	
	void haveABirthday() {
		age++;
	}
}
