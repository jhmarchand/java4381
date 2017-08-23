
public class Marchand implements Person {
	
	String firstName;
	final int birthYear;
	static String homeTown;
	final static String LastName = "Marchand";
	
	Marchand(String aFirstName, int yearOfBirth) {
		firstName = aFirstName;
		birthYear = yearOfBirth;
	}
	
	void changeFirstName(String firstName ) {
		this.firstName = firstName;
	}
	
	public String getFullName() {
		return firstName + " " + LastName;
	}
}
