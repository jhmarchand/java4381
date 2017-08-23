
public class MarchandMain {

	public static void main(String[] args) {
		
		Marchand.homeTown = "Louisville";

		Marchand john = new Marchand("John", 1970);
		Marchand luke = new Marchand("Luke", 2003);
		
		System.out.println(luke.homeTown);
		
		// john moves
		john.homeTown = "Richland";
		System.out.println(luke.homeTown);
		
		//this would be an error
		//john.birthYear = 1971;
		
		// but this is fine
		john.changeFirstName("Johnny");
		
		// the compiler may complain if you do it the first way, but it will work....
		System.out.println(john.firstName + " " + john.LastName);
		System.out.println(john.firstName + " " + Marchand.LastName);
		
		Student ava = new Student();
		ava.name = "Ava Marchand";
		ava.grade = 12;
		
		printPerson(ava);
		printPerson(john);

	}
	
	static void printPerson(Person person){
		System.out.println(person.getFullName());
	}

}
