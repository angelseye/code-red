package session9;

public class Demo {

  public static void main(String[] args) {
	
	Dog myDog = new Dog("Toby", 17, true);
	Dog yourDog = new Dog("Tucker", 3, true);
	
	myDog.age = 5;
	yourDog.name = "Conrad";
	
	myDog.printName();
	
  }

}
