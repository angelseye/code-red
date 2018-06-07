package ShoppingList;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
* Session 8: Make following changes in code of week7
*  
*  1. Create Arrays for item_name, item_price, item_quantity, item_coupon
*  2. Inside the loop add item_name, item_price, item_quantity, item_coupon input to Array
*  3. Use data in arrays created in step 2 and implement following:
*  a. printCostStatistics & printCouponStatistics 
*      b. Implement logic for most expensive and least expensive items
*      c. Move logic for most expensive and least expensive to different methods.
*  
**/

public class ShoppingMain {
	public static void main(String[] args) {
	  	// Setup Prompt for Gathering Data
		input = new Scanner(System.in);
		double cartTotal = 0;

		//Ask user input for number of items and create loop
		System.out.print("Please enter the number of items you have: ");
		int numOfItems = input.nextInt();
		
		String [] item_names = new String[numOfItems];
		double [] item_prices = new double[numOfItems];
		int [] item_quantities = new int[numOfItems];
		int [] item_coupons = new int[numOfItems];
		double [] item_finalCosts = new double[numOfItems];
	     
		for(int i=0; i<numOfItems; i++) {
		  	String thisName = "";
		  	while(thisName.length() == 0 || thisName.length() > 10) {
		  	  if(thisName.length() > 10) {
		  		System.out.println("Please limit your item name to 10 characters.");
		  	  }
		  	  System.out.print("Enter name of item " + (i+1) + ": ");
		  	  thisName = input.next();
		  	}
		  	item_names[i] = thisName;
			System.out.print("Enter price of " + thisName + ": ");
			double thisPrice = input.nextDouble();
			item_prices[i] = thisPrice;
			System.out.print("Enter quantity of " + thisName + ": ");
			int thisQuantity = input.nextInt();
			item_quantities[i] = thisQuantity;
			System.out.print("Enter coupon rate for " + thisName + ": ");
			int thisCoupon = input.nextInt();
			item_coupons[i] = thisCoupon;
			System.out.println();
			
			double thisTotalCost = calculateTotalCost(thisPrice, thisQuantity);
			printTotalCost(thisName, thisTotalCost);
			printCouponRate(thisName, thisCoupon);
			double thisFinalCost = calculateFinalCost(thisTotalCost, thisCoupon);
			item_finalCosts[i] = thisFinalCost;
			printFinalCost(thisName, thisFinalCost);
			System.out.println();

			cartTotal += thisFinalCost;
		}

		printCostStatistics(item_names, item_finalCosts);		
		System.out.println();
//TODO: Refactor below code to have less arguments
		printCouponStatistics(item_coupons[0], item_coupons[1], item_coupons[2]);
		System.out.println();

		
		// Calculate and print cost after coupon code
		int cart_coupon_rate = getCartCouponRate();
		System.out.println("****** Final Cart Total ******");
		double cartTotal_before_coupon = cartTotal;
		System.out.println("Your Cart Total: " + dollarFormat(cartTotal_before_coupon));
		double cartTotal_after_coupon = calculateCouponCost(cartTotal_before_coupon, cart_coupon_rate);
		System.out.println("Your Cart: " + dollarFormat(cartTotal_after_coupon));
}


	
	/********** PRIVATE METHODS **********/
	
	// Display Money Format
	private static String dollarFormat(double amount) {
	  DecimalFormat dollarize = new DecimalFormat("$#0.00");
	  return dollarize.format(amount);
	}
	
	// Print Total Cost
	private static void printTotalCost(String itemName, double totalCost) {
		System.out.println("Total cost of " + itemName + " is " + dollarFormat(totalCost));
	}

	// Print Coupon Rate
	private static void printCouponRate(String itemName, int coupon) {
		System.out.println("Coupon rate of " + itemName + " is " + coupon + "%");
	}

	// Print Final Cost
	private static void printFinalCost(String itemName, double finalCost) {
	  System.out.println("Final cost after discount for " + itemName + " is " + dollarFormat(finalCost));
	}
	
	// Print Cost Statistics
	private static void printCostStatistics(String[] names, double[] finalCosts){
	  double maxCost = 0;
	  double minCost = finalCosts[0];
	  String maxName = "";
	  String minName = names[0];

	  for(int i=0; i<finalCosts.length; i++) {
		// compare max cost
		if(maxCost < finalCosts[i]) {
		  maxCost = finalCosts[i];
		  maxName = names[i];
		}
		// compare min cost
		if(minCost > finalCosts[i]) {
		  minCost = finalCosts[i];
		  minName = names[i];
		}
	  }
	  
	  System.out.println("****** Cost statistics ******");
	  System.out.println("Most expensive item costs: " + dollarFormat(maxCost));
	  System.out.println("Cheapest item costs: " + dollarFormat(minCost));
	  //Print name of item which is most expensive
	  System.out.println(maxName + " is the most expensive item");
	  System.out.println(minName + " is the least expensive item");
	}
	
	// Print Coupon Statistics
	private static void printCouponStatistics(int coupon1, int coupon2, int coupon3){
		System.out.println("****** Coupon statistics ******");
		double maxCoupon;
		if(coupon1 > coupon2) {
		  if(coupon1 > coupon3) {
			maxCoupon = coupon1;
		  }else {
			maxCoupon = coupon3;
		  }
		}else {
		  if(coupon2 > coupon3) {
			maxCoupon = coupon2;
		  }else {
			maxCoupon = coupon3;
		  }
		}
		System.out.println(maxCoupon + " percent off is awesome!!");
	}
	
	// Calculate Total Cost
	private static double calculateTotalCost(double price, int quantity) {
	  return price * quantity;
	}
	
	// Calculate Final Cost
	private static double calculateFinalCost(double totalCost, int coupon) {
	  return totalCost - (totalCost * coupon / 100);
	}
	
	// Get Cart Coupon Rate
	private static int getCartCouponRate() {
		// Prompt user for coupon code to apply on whole shopping cart
		System.out.print("Enter your cart coupon code (A=5%, B=10%, C=15%): ");
		String cart_coupon_code = input.next();
		
		//TODO 3 : Move this calculation to a method.
		int cart_coupon_rate = 0;
		if(cart_coupon_code.charAt(0) == 'A') {
		  cart_coupon_rate = 5;
		} else if(cart_coupon_code.charAt(0) == 'B') {
		  cart_coupon_rate = 10;
		} else if(cart_coupon_code.charAt(0) == 'C') {
		  cart_coupon_rate = 15;
		} else {
		  cart_coupon_rate = 0;
		}
		
		return cart_coupon_rate;
	}
	
	// Calculate Cost with Coupon
	private static double calculateCouponCost(double cost, int coupon) {
	  double savings = cost * coupon / 100;
	  double result = cost - savings;
	  System.out.println("Coupon Savings: " + dollarFormat(savings));
	  return result;
	}

	private static Scanner input;

}

