package ShoppingList;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import utilities.Format;


public class ShoppingMain {
  
  // Main Method (starts the app)
  public static void main(String[] args) throws IOException {
	// Setup Prompt for Gathering Data
	input = new Scanner(System.in);
	
	// Welcome the Shopper and get their name
	String shopper;
	System.out.println("************************************************************");
	System.out.println();
	System.out.println("Welcome to UBS CodeRed Market");
	System.out.println();
	System.out.println("************************************************************");
	System.out.println();
	System.out.println("What is your name, shopper? ");
	shopper = input.next();
	System.out.println();
	System.out.println("Nice to meet you, " + shopper + ".");
	System.out.println();
	
	// Setup a cart for the shopper
	System.out.println("Let's get you a shopping cart...");
	
	// Add a timer to pause a few seconds
	try {
	  TimeUnit.SECONDS.sleep(2);
	} catch (InterruptedException e) {
	  e.printStackTrace();
	}
	
	// Pass in shoppers name so we can add it to the cart
	Cart shoppingCart = new Cart(shopper);
	System.out.println("");
	
	// Import any items on their list
	shoppingCart = importShoppingList(shoppingCart);
	
	// Find out what the shopper wants to do next
	askWhatIsNext(shoppingCart);
  }


	
  /********** PRIVATE METHODS  **********/
  
  // Import from Shopping List
  private static Cart importShoppingList(Cart cart) throws NumberFormatException, IOException {
	try {
	  System.out.println("First, let's try to import your shopping list from a file...");	  

	  // Pause for 3 seconds to make it feel like the application is thinking...lol
	  try {
		TimeUnit.SECONDS.sleep(3);
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }

	  // Okay, grab the file and run through it	
	  BufferedReader importList = checkForImport();
	  Item thisItem;
	  if(importList != null) {	
		String line; 
		while((line = importList.readLine()) != null) {
		  String[] lineArray = line.split(",");
		  thisItem = new Item();
		  thisItem.importItem(lineArray[0], Double.parseDouble(lineArray[1]), Integer.parseInt(lineArray[2]), Integer.parseInt(lineArray[3]));
		  cart.putItemInCart(thisItem);
		}
	  }
	} catch (FileNotFoundException e) {
	  e.printStackTrace();
	}
	
	int cartSize = cart.getItemList().size();
	String word = (cartSize == 1) ? "item" : "items";
	if(cartSize < 1) {
	  System.out.println("There was nothing on your list to import at this time.");
	} else {
	  System.out.println("Great! Everything is all imported. You now have " + cartSize + " " + word + " in your cart.");
	}
	System.out.println("");

	return cart;
  }
  
  // Ask What is Next
  private static void askWhatIsNext(Cart cart) {
	// Ask the shopper what they want to do next
	System.out.println("*************************************");
	System.out.println("What would you like to do next?");
	System.out.println("");
	System.out.println("***** OPTIONS *****");
	System.out.println("1. View Cart");
	System.out.println("2. Add an Item");
	System.out.println("3. Add Multiple Items");
	System.out.println("4. Remove an Item");
	System.out.println("5. Checkout");
	System.out.println("");
	System.out.print("Please enter a number: ");
	// Get the users response
	int action = input.nextInt();
	System.out.println("*************************************");
	System.out.println("");
	// Respond to the user
	switch(action) {
	  case 1:	cart.viewItemsInCart();
	  			break;
	  case 2: 	cart.createItemForCart();
	  			break;
	  case 3: 	cart.createMultipleItemsForCart();
	  			break;
	  case 4: 	cart.removeItemFromCart();
	  			break;
	  case 5: 	checkout(cart);
	  			break;
	  default:	System.out.println("Sorry...I did not understand your response.");
	  			System.out.println("");
	}
	// Ask the shopper what's next if they haven't checked out.
	if(action != 5) {
	  askWhatIsNext(cart);
	}
	System.out.println("");
  }
  
  
  // Check for Import
  private static BufferedReader checkForImport() throws FileNotFoundException {
	File file = new File("src/ShoppingList/listForImport");
	BufferedReader list = new BufferedReader(new FileReader(file));
	return list;
  }
  
  
  // Checkout
  private static void checkout(Cart cart) {
	// Show cost and coupon stats for all items
	printCostStatistics(cart);		
	System.out.println();
	printCouponStatistics(cart);
	System.out.println();
		
	// Calculate and print cost after coupon code
	int cart_coupon_rate = getCartCouponRate();
	System.out.println("****** Final Cart Total ******");
	cart.viewItemsInCart();
	System.out.println("-------------------------------------------------------");
	double cartTotal_before_coupon = cart.getGrandTotal();
	System.out.println("Cart Total: " + Format.dollarFormat(cartTotal_before_coupon));
	double cartTotal_after_coupon = calculateCouponCost(cartTotal_before_coupon, cart_coupon_rate);
	System.out.println("Final Total: " + Format.dollarFormat(cartTotal_after_coupon));

	System.out.println("");
	System.out.println("-------------------------------------------------------");
	System.out.println("");
	System.out.println("Thank you for shopping with us today, " + cart.getName() + ". We hope you had a great experience.");
	System.out.println("Please visit us again in the future.");
	System.out.println("\n\n");
  }
  
  
  // Print Cost Statistics
  private static void printCostStatistics(Cart cart){
	double maxCost = 0;
	double minCost = cart.getItemList().get(0).getFinalCost();
	String maxName = "";
	String minName = cart.getItemList().get(0).getName();
	List<Item> items = cart.getItemList();
	
	for(int i=0; i<items.size(); i++) {
	  // compare max cost
	  if(maxCost < items.get(i).getFinalCost()) {
		maxCost = items.get(i).getFinalCost();
		maxName = items.get(i).getName();
	  }
	  // compare min cost
	  if(minCost > items.get(i).getFinalCost()) {
		minCost = items.get(i).getFinalCost();
		minName = items.get(i).getName();
	  }
	}
	
	System.out.println("****** Cost statistics ******");
	System.out.println("Most expensive item costs: " + Format.dollarFormat(maxCost));
	System.out.println("Cheapest item costs: " + Format.dollarFormat(minCost));
	//Print name of item which is most expensive
	System.out.println(maxName + " is the most expensive item you bought.");
	System.out.println(minName + " is the least expensive item you bought.");
  }
	
  
  // Print Coupon Statistics
  private static void printCouponStatistics(Cart cart){
	System.out.println("****** Coupon statistics ******");
	double maxCoupon = 0;
	List<Item> items = cart.getItemList();
	
	for(int i=0; i<items.size(); i++) {
	  if(items.get(i).getCoupon() > maxCoupon) {
		maxCoupon = items.get(i).getCoupon();
	  }
	}
	System.out.println(maxCoupon + " percent off of a product is awesome!!");
  }
	
  
  // Get Cart Coupon Rate
  private static int getCartCouponRate() {
	// Prompt user for coupon code to apply on whole shopping cart
	String cart_coupon_code = "";
	int cart_coupon_rate = 0;
	boolean isValid = false;
	System.out.println("For being a loyal shopper, we'd like to offer you an extra discount on your entire cart.");
	while(!isValid) {
	  System.out.print("Enter your cart coupon code for extra savings (A=5%, B=10%, C=15%): ");
	  cart_coupon_code = input.next();
	  isValid = validCartCoupon(cart_coupon_code);			
	}
	System.out.println();
	if(cart_coupon_code.equals("A")) {
	  cart_coupon_rate = 5;
	} else if(cart_coupon_code.equals("B")) {
	  cart_coupon_rate = 10;
	} else if(cart_coupon_code.equals("C")) {
	  cart_coupon_rate = 15;
	} 
		
	return cart_coupon_rate;
  }
  
  
  // Calculate Cost with Coupon
  private static double calculateCouponCost(double cost, int coupon) {
	double savings = cost * coupon / 100;
	double result = cost - savings;
	System.out.println("Cart Savings: " + Format.dollarFormat(savings));
	return result;
  }
  
  
  
  /********** VALIDATIONS **********/
  
  // Cart Coupon Code
  private static boolean validCartCoupon(String code) {
	if(code != "" && code.length() != 1) {
	  System.out.println("Please only enter 1 letter");
	  return false;
	}
	if(code != "" && code.length() == 1) {
	  if(!code.equals("A") && !code.equals("B") && !code.equals("C")) {
		System.out.println("Invalid Coupon Code");
		return false;
	  }
	}
	return true;
  }
  
  
  private static Scanner input;
  
}