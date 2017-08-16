
public class PetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person someOne = new Person("Chris","Yahoo", 40);
		Pet myPet = new Cat("Gruffy",7,someOne);
		printPet(myPet);
		myPet.speak();
		
		myPet = new Dog("Cooper",9, new Person("Mike", "Mills", 45));
		printPet(myPet);
		myPet.speak();
		
		Dog myDog = (Dog) myPet;
	
		System.out.println(myDog.name + " is " + myDog.getAgeInDogYears());
	}
	
	static void printPet(Pet pet){
		System.out.println(pet.owner.GetFullName() + "'s pet is " + pet.name);
	}
}
