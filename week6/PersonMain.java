
public class PersonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person me = new Person("John","Marchand", 47);
		Person luke = new Person();
		
		luke.age = 13;
		luke.firstName = "Luke";
		luke.lastName = "Marchand";
		
		Person[] family = new Person[5];
		family[0] = new Person("Ursula", "Marchand", 43);
		family[1] = new Person("Ursula", "Marchand", 43);
		family[2] = new Person("Ursula", "Marchand", 43);
		family[3] = me;
		family[4] = luke;
		
		Person mySon = luke;
		
		printPerson(family[4]);
		printPerson(luke);
		printPerson(mySon);
		
		luke.haveABirthday();
		
		printPerson(family[4]);
		printPerson(luke);
		printPerson(mySon);

		printPerson(FindOldest(family));
	}
	
	static void printPerson(Person person){
		System.out.println(person.GetFullName() + " is " + person.age);
	}
	
	static Person FindOldest(Person[] personArray)
	{
		Person oldest = personArray[0];
		
		for( int i = 1; i < personArray.length; i++) {
			if ( personArray[i].age > oldest.age ) {
				oldest = personArray[i];
			}
		}
		
		return oldest;
	}

}
