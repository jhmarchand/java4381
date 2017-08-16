
public class Dog extends Pet {

	public Dog(String aName, int aAge,Person aOwner) {
		super(aName, aAge,aOwner);
		// TODO Auto-generated constructor stub
	}
	
	void speak()
	{
		System.out.println("Woof");
	}
	
	int getAgeInDogYears()
	{
		return age * 7;
	}
	
}
