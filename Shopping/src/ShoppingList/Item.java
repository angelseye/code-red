package ShoppingList;

import java.util.Scanner;
import utilities.Format;

public class Item {
  
  // Properties
  private String name;
  private double price;
  private int quantity;
  private int coupon;
  private double totalCost; // price * quantity
  private double finalCost; // price after coupon applied
  
  
  // Constructor
  public Item() {
	// Setup Prompt for Gathering Data
	input = new Scanner(System.in);
  }
  
  
  
  
  /********** Getters / Setters **********/
  // Getters
  public String getName() {
	return this.name;
  }
  
  public double getPrice() {
	return this.price;
  }
  
  public int getQuantity() {
	return this.quantity;
  }
  
  public int getCoupon() {
	return this.coupon;
  }
  
  public double getTotalCost() {
	return this.totalCost;
  }
  
  public double getFinalCost() {
	return this.finalCost;
  }
  
  // Setters
  public void setName(String name) {
	this.name = name;
  }
  
  public void setPrice(double price) {
	this.price = price;
  }
  
  public void setQuantity(int quantity) {
	this.quantity = quantity;
  }
  
  public void setCoupon(int coupon) {
	this.coupon = coupon;
  }
  
  
  
  /********** Methods **********/
  
  /***** Public *****/
  
  public void buildItem() {	  
	this.askForName();
	this.askForPrice();
	this.askForQuantity();
	this.askForCoupon();

	System.out.println();
	
	// Calculate Item Costs and Coupons
	this.calculateTotalCost();
	this.printTotalCost();
	this.printCouponRate();
	
	this.calculateFinalCost();
	this.printFinalCost();
	
	System.out.println();  
  }
  
  // Import Items
  public void importItem(String name, double price, int quantity, int coupon) {
	this.setName(name);
	this.setPrice(price);
	this.setQuantity(quantity);
	this.setCoupon(coupon);

	System.out.println();
	
	// Calculate Item Costs and Coupons
	this.calculateTotalCost();
	this.printTotalCost();
	this.printCouponRate();
	
	this.calculateFinalCost();
	this.printFinalCost();
	
	System.out.println();  
  }
  
  // Calculate Total Cost
  public double calculateTotalCost() {
	this.totalCost = this.price * this.quantity;
	return this.totalCost;
  }
  
  // Calculate Final Cost
  public double calculateFinalCost() {
	this.finalCost = this.totalCost - (this.totalCost * this.coupon / 100);
	return this.finalCost;
  }
  
  // Print Total Cost
  public void printTotalCost() {
	System.out.println("The total cost of " + this.name + " is " + Format.dollarFormat(this.totalCost));
  }
  
  // Print Coupon Rate
  public void printCouponRate() {
	System.out.println("The coupon rate of " + this.name + " is " + this.coupon + "%");
  }
  
  // Print Final Cost
  public void printFinalCost() {
	System.out.println("The final cost after the discount for " + this.name + " is " + Format.dollarFormat(this.calculateFinalCost()));
  }
  
 
  /***** Private *****/
    
  // Ask for Item Name
  private String askForName() {
	boolean isValid = false;
	while(!isValid) {
	  System.out.print("Enter the name of the item: ");
	  this.setName(input.next());
	  isValid = isValidName();
	}
	return this.name;
  }
  
  // Ask for Item Price
  private double askForPrice() {
	boolean isValid = false;
	while(!isValid) {
	  System.out.print("Enter the price of " + this.name + ": ");
	  this.setPrice(input.nextDouble());
	  isValid = isValidPrice();
	}
	return this.price;
  }
  
  // Ask for Item Quantity
  private int askForQuantity() {
	boolean isValid = false;
	while(!isValid) {
	  System.out.print("Enter the quantity of " + this.name + ": ");
	  this.setQuantity(input.nextInt());
	  isValid = isValidQuantity();
	}
	return this.quantity;
  }
  
  // Ask for Item Coupon
  private int askForCoupon() {
	boolean isValid = false;
	while(!isValid) {
	  System.out.println("Do you have a coupon for " + this.name + "?");
	  System.out.print("If so, enter the coupon % rate for " + this.name + ", otherwise enter 0: ");
	  this.setCoupon(input.nextInt());
	  isValid = isValidCouponRate();
	}
	return this.coupon;
  }
  
  
  /********** Validations **********/
  private boolean isValidName() {
	int errors = 0;
	// Empty String
	if(this.name.length() < 1) {
	  System.out.println("You must enter an item name.");
	  errors++;
	}
	// Name must be 10 or less characters
	if(this.name.length() > 10) {
	  System.out.println("Please limit your item name to 10 characters.");
	  errors++;
	}
	return (errors == 0) ? true : false;
  }
  
  // isValidPrice(): Validates the price entered by the user
  private boolean isValidPrice() {
	int errors = 0;
	// Must have price above 0.00
	if(this.price <= 0) {
	  System.out.println("Please enter a price above 0.00");
	  errors++;
	}
	return (errors == 0) ? true : false;

  }
  
  // isValidQuantity(): Validates the quantity entered by the user
  private boolean isValidQuantity() {
	int errors = 0;
	// Must have a quantity above 0
	if(this.quantity <= 0) {
	  System.out.println("Please enter a quantity above 0");
	  errors++;
	}
	return (errors == 0) ? true : false;
  }
  
  // isValidCouponRate(): Validates the percentage rate of the coupon entered by the user
  private boolean isValidCouponRate() {
	int errors = 0;
	// Must be between 1 and 100
	if(this.coupon < 0 || this.coupon > 100) {
	  System.out.println("Please enter a value between 0 and 100");
	  errors++;
	}
	return (errors == 0) ? true : false;
  }
  
  
  /********** Misc **********/
  private static Scanner input;
  
}
