
public class Pet {
	
	String name;
	Person owner;
	int age;
	
	Pet(String aName, int aAge, Person aOwner)
	{
		name = aName;
		age = aAge;		
		owner = aOwner;
	}
	
	void speak()
	{
		System.out.println("Hi");
	}

}
