
public class SimplePersonMain {

	public static void main(String[] args) {
		
		SimplePerson me = new SimplePerson();
		me.firstName = "John";
		me.age = 47;
		
		SimplePerson luke = new SimplePerson();
		luke.age = 13;
		luke.firstName = "Luke";
		
		printPerson(me);
		printPerson(luke);
		
		// have a birthday!
		me.age++;
		
		printPerson(me);
		printPerson(luke);

	}
	
	static void printPerson(SimplePerson person){
		System.out.println(person.firstName + " is " + person.age);
	}

}
