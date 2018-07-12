package ShoppingList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utilities.Format;

public class Cart {

  /********** Properties **********/
  private String name; //name of shopper
  private double total; // total of cart before savings
  private double savings; // total of savings
  private double grandTotal; // total of cart after savings
  private List<Item> itemList; // all items in cart
  
  
  /********** Constructor **********/
  public Cart(String name) { 
	// Setup Prompt for Gathering Data
	input = new Scanner(System.in);
	
	this.setName(name);
	itemList = new ArrayList<Item>();
  }


  /********** Getters / Setters **********/
  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public double getTotal() {
    return this.total;
  }

  public void setTotal() {
	double newTotal = 0.0;
	// loop through items and calculate total
	for(int i=0; i<this.itemList.size(); i++) {
	  newTotal += itemList.get(i).getTotalCost();
	}
	this.total = newTotal;
  }
  
  public double getSavings() {
    return this.savings;
  }

  public void setSavings() {
	double newSavings = 0.0;
	// loop through items and calculate total
	for(int i=0; i<this.itemList.size(); i++) {
	  newSavings += itemList.get(i).calculateCouponSavings();
	}
	this.savings = newSavings;
  }
  
  public double getGrandTotal() {
	return this.grandTotal;
  }
  
  public void setGrandTotal() {
	double newGrandTotal = 0.0;
	// loop through items and calculate total
	for(int i=0; i<this.itemList.size(); i++) {
	  newGrandTotal += itemList.get(i).getFinalCost();
	}
	this.grandTotal = newGrandTotal;
  }
  
  public List<Item> getItemList() {
    return itemList;
  }



  /********** Methods **********/
  
  /***** Public *****/
  
  // Create Item
  public void createItemForCart() {
	Item item;
	// Construct an instance
	item = new Item(); // instantiates item
	item.buildItem(); // asks questions to build item for cart
	// Put the item in the cart
	putItemInCart(item);
  }
  
  
  // Create Multiple Items
  public void createMultipleItemsForCart() {
	//Ask user input for number of items and create loop
	System.out.print("How many different items would you like to create for your cart? ");
	int numOfItems = input.nextInt();
	System.out.println("");
	
	// Loop through number of items and construct each one
	Item item;
	for(int i=0; i<numOfItems; i++) {
	  // Construct an instance
	  item = new Item(); // instantiates item
	  item.buildItem(); // asks questions to build item for cart
	  // Put the item in the cart
	  putItemInCart(item);
	}
  }
  
  
  // Put Item in Cart
  public void putItemInCart(Item item) {
	this.itemList.add(item);
	this.updateTotals();
  }
  
  
  // Update Totals
  public void updateTotals() {
	this.setTotal();
	this.setSavings();
	this.setGrandTotal();
  }
  
  
  // View Items in Cart
  public void viewItemsInCart() {
	List<Item> items = getItemList();
	System.out.println("-------------------------------------------------------");
	for(int i=0; i<items.size(); i++) {
	  Item item = items.get(i);
	  System.out.println(item.getName() + ":\t\t" + item.getQuantity() + " @ " + Format.dollarFormat(item.getPrice()) + " ea.\t\t" + Format.dollarFormat(item.calculateTotalCost()));
	}
	if(items.size() == 0) {
	  System.out.println("There are no items in your cart.");
	}
	System.out.println("-------------------------------------------------------");
	System.out.println("Total:\t\t" + Format.dollarFormat(getTotal()));
	System.out.println("Savings:\t" + Format.dollarFormat(getSavings()));
	System.out.println("Grand Total:\t" + Format.dollarFormat(getGrandTotal()));
	System.out.println("-------------------------------------------------------");
	System.out.println("");
  }
  
  
  // Remove Item from Cart
  public void removeItemFromCart() {
	System.out.println("Items in Cart");
	System.out.println("-------------------------------------------------------");
	List<Item> items = this.getItemList();
	for(int i=0; i<items.size(); i++) {
	  Item item = items.get(i);
	  System.out.println((i+1) + ". " + item.getName());
	}
	if(items.size() == 0) {
	  System.out.println("There are no items in your cart.");
	}
	System.out.println("-------------------------------------------------------");
	if(items.size() > 0) {
	  System.out.print("Select the number for the item you wish to remove: ");
	  int action = input.nextInt();
	  if(action == 0 || action > items.size()) {
		System.out.println("Sorry...I do not understand your request.");
		System.out.println();
		removeItemFromCart();
		return;
	  }
	  int indexToRemove = action-1;
	  System.out.print("Are you sure you want to remove " + items.get(indexToRemove).getName() + " (Y/N)? ");
	  String approve = input.next();
	  System.out.println();
	  if(approve.equals("Y")) {
		items.remove(indexToRemove);
		updateTotals();
		System.out.println("Your item has been successfully removed.");
		System.out.println();
		viewItemsInCart();
	  } else {
		System.out.println("We did not remove your item.");
		System.out.println();
	  }
	} else {
	  System.out.println("Sorry! There is nothing to remove.");
	}
  }
  
  

  /***** Private *****/
  
  private static Scanner input;
  
}
