package session9;

public class Dog {
  public String name;
  public int age;
  public boolean hasOwner;
  
  public Dog(String name, int age, boolean hasOwner) {
	this.name = name;
	this.age = age;
	this.hasOwner = hasOwner;
  }
  
  public void printName() {
	System.out.println(this.name);
  }
}
