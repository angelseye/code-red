package ShoppingList;

public class Item {
  
  // Properties
  private String name;
  private double price;
  private int quantity;
  private int coupon;
  
  
  // Constructor
  public Item() {
	this.name = "Item Name";
	this.price = 0.00;
	this.quantity = 0;
	this.coupon = 0;
  }
  
  public static void main(String[] args) {
	String s1 = "India";
	String s2 = "Java";
	printStringLength(s1);
	printStringLength(s2);
  }
  
  
  public static void printStringLength(String str) {
	System.out.println(calculateStringLength(str));
  }
  
  
  public static int calculateStringLength(String str) {
	return str.length();
  }

}
