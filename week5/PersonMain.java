
public class PersonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person me = new Person("John", 47);
		Person luke = new Person("Luke",13);
		
		
		printPerson(me);
		printPerson(luke);
		
		me.haveABirthday();
		
		printPerson(me);
		printPerson(luke);

	}
	
	static void printPerson(Person person){
		System.out.println(person.firstName + " is " + person.age);
	}

}
