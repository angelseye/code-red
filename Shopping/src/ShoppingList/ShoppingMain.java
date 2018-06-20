package ShoppingList;

import java.util.Scanner;
import utilities.Format;


public class ShoppingMain {
  public static void main(String[] args) {
	// Setup Prompt for Gathering Data
	input = new Scanner(System.in);
	double cartTotal = 0;

	//Ask user input for number of items and create loop
	System.out.print("Please enter the number of items you have: ");
	int numOfItems = input.nextInt();
	
	Item [] items = new Item[numOfItems];
	
	// Loop through number of items and construct each one     
	for(int i=0; i<numOfItems; i++) {
	  // Construct an instance
	  items[i] = new Item(); // instantiates and gets details of item
	  cartTotal += items[i].getFinalCost();
	}

	// Show cost and coupon stats for all items
	printCostStatistics(items);		
	System.out.println();
	printCouponStatistics(items);
	System.out.println();
		
	// Calculate and print cost after coupon code
	int cart_coupon_rate = getCartCouponRate();
	System.out.println("****** Final Cart Total ******");
	double cartTotal_before_coupon = cartTotal;
	System.out.println("Your Cart Total: " + Format.dollarFormat(cartTotal_before_coupon));
	double cartTotal_after_coupon = calculateCouponCost(cartTotal_before_coupon, cart_coupon_rate);
	System.out.println("Your Cart: " + Format.dollarFormat(cartTotal_after_coupon));
  }


	
  /********** PRIVATE METHODS **********/
  
  // Print Cost Statistics
  private static void printCostStatistics(Item[] items){
	double maxCost = 0;
	double minCost = items[0].getFinalCost();
	String maxName = "";
	String minName = items[0].getName();
	
	for(int i=0; i<items.length; i++) {
	  // compare max cost
	  if(maxCost < items[i].getFinalCost()) {
		maxCost = items[i].getFinalCost();
		maxName = items[i].getName();
	  }
	  // compare min cost
	  if(minCost > items[i].getFinalCost()) {
		minCost = items[i].getFinalCost();
		minName = items[i].getName();
	  }
	}
	
	System.out.println("****** Cost statistics ******");
	System.out.println("Most expensive item costs: " + Format.dollarFormat(maxCost));
	System.out.println("Cheapest item costs: " + Format.dollarFormat(minCost));
	//Print name of item which is most expensive
	System.out.println(maxName + " is the most expensive item");
	System.out.println(minName + " is the least expensive item");
  }
	
  // Print Coupon Statistics
  private static void printCouponStatistics(Item[] items){
	System.out.println("****** Coupon statistics ******");
	double maxCoupon = 0;
	
	for(int i=0; i<items.length; i++) {
	  if(items[i].getCoupon() > maxCoupon) {
		maxCoupon = items[i].getCoupon();
	  }
	}
	System.out.println(maxCoupon + " percent off is awesome!!");
  }
	
  // Get Cart Coupon Rate
  private static int getCartCouponRate() {
	// Prompt user for coupon code to apply on whole shopping cart
	String cart_coupon_code = "";
	int cart_coupon_rate = 0;
	boolean validCode = false;
	while(!validCode) {
	  if(cart_coupon_code != "" && cart_coupon_code.length() != 1) {
		System.out.println("Please only enter 1 letter");
	  }else if(cart_coupon_code != "" && cart_coupon_code.length() == 1) {
		if(cart_coupon_code.charAt(0) == 'A') {
		  cart_coupon_rate = 5;
		  validCode = true;
		} else if(cart_coupon_code.charAt(0) == 'B') {
		  cart_coupon_rate = 10;
		  validCode = true;
		} else if(cart_coupon_code.charAt(0) == 'C') {
		  cart_coupon_rate = 15;
		  validCode = true;
		} else {
		  System.out.println("Invalid Coupon Code");
		  cart_coupon_code = "";
		}
	  }
			
	  System.out.print("Enter your cart coupon code (A=5%, B=10%, C=15%): ");
	  cart_coupon_code = input.next();
	}
	
	return cart_coupon_rate;
  }
  
  // Calculate Cost with Coupon
  private static double calculateCouponCost(double cost, int coupon) {
	double savings = cost * coupon / 100;
	double result = cost - savings;
	System.out.println("Coupon Savings: " + Format.dollarFormat(savings));
	return result;
  }
  
  private static Scanner input;
  
}