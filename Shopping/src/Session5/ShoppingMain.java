package Session5;

import java.util.Scanner;

/**
 * Session 5: Make following changes in code of week4
 * 
 * 1. Reorganize your code to ask all details of each item i.e. name, price, quantity, coupon for item1 and then for item2 
 * 2. Print name of item which has least finalcost
 * 3. Print name of item which is most expensive. 
 * 4. Calculate and print total cost of all three items
 * 5. Prompt user to input coupon code for whole shopping cart 
 * 		a. if coupon code = A. Apply additional 5% off on total cost 
 * 		b. if coupon code = B. Apply additional 10% off on total cost 
 * 		c. if coupon code = C. Apply additional 20% off on total cost   
 * 6. Calculate Cost after applying coupon code and print it.
 * 
 * 7. Prompt user to enter details of item3 i.e. item_3_name, item_3_price, item_3_quantity, item_3_coupon and recalculate 2, 3, 4, 5, 6 above. 
 *  
 **/

public class ShoppingMain {
	public static void main(String[] args) {

		input = new Scanner(System.in);

		// Item 1
		System.out.print("Enter name of item 1: ");
		String item_1_name = input.next();

		System.out.print("Enter price of " + item_1_name + ": ");
		double item_1_price = input.nextDouble();

		System.out.print("Enter quantity of " + item_1_name + ": ");
		int item_1_quantity = input.nextInt();

		System.out.print("Enter coupon rate for " + item_1_name + ": ");
		int item_1_coupon = input.nextInt();

		
		// Item 2
		System.out.print("Enter name of item 2: ");
		String item_2_name = input.next();

		System.out.print("Enter price of " + item_2_name + ": ");
		double item_2_price = input.nextDouble();

		System.out.print("Enter quantity of " + item_2_name + ": ");
		int item_2_quantity = input.nextInt();

		System.out.println("Enter coupon rate for " + item_2_name + ": ");
		int item_2_coupon = input.nextInt();
		
		
		// Item 3
		System.out.print("Enter name of item 3: ");
		String item_3_name = input.next();
		
		System.out.print("Enter price of " + item_3_name + ": ");
		double item_3_price = input.nextDouble();
		
		System.out.print("Enter quantity of " + item_3_name + ": ");
		int item_3_quantity = input.nextInt();
		
		System.out.println("Enter coupon rate for " + item_3_name + ": ");
		int item_3_coupon = input.nextInt();

		
		// Price x Quantity for Total Cost
		double item_1_totalCost = calculateTotalCost(item_1_price, item_1_quantity);
		double item_2_totalCost = calculateTotalCost(item_2_price, item_2_quantity);
		double item_3_totalCost = calculateTotalCost(item_3_price, item_3_quantity);
		printTotalCost(item_1_name, item_1_totalCost);
		printTotalCost(item_2_name, item_2_totalCost);
		printTotalCost(item_3_name, item_3_totalCost);

		
		// Coupon Rates
		printCouponRate(item_1_name, item_1_coupon);
		printCouponRate(item_2_name, item_2_coupon);
		printCouponRate(item_3_name, item_3_coupon);


		// Calculate Final Cost
		double item_1_finalCost = calculateFinalCost(item_1_totalCost, item_1_coupon);
		double item_2_finalCost = calculateFinalCost(item_2_totalCost, item_2_coupon);
		double item_3_finalCost = calculateFinalCost(item_3_totalCost, item_3_coupon);
		printFinalCost(item_1_name, item_1_finalCost);
		printFinalCost(item_2_name, item_2_finalCost);
		printFinalCost(item_3_name, item_3_finalCost);

		
		printCostStatistics(item_1_name, item_1_finalCost, item_2_name, item_2_finalCost);		
		printCouponStatistics(item_1_coupon, item_2_coupon);

		// Prompt user for coupon code to apply on whole shopping cart
		System.out.print("Enter your cart coupon code (A=5%, B=10%, C=15%): ");
		String cart_coupon_code = input.next();
		
		int cart_coupon_rate;
		if(cart_coupon_code.charAt(0) == 'A') {
		  cart_coupon_rate = 5;
		} else if(cart_coupon_code.charAt(0) == 'B') {
		  cart_coupon_rate = 10;
		} else if(cart_coupon_code.charAt(0) == 'C') {
		  cart_coupon_rate = 15;
		} else {
		  cart_coupon_rate = 0;
		}
		
		// Calculate and print cost after coupon code
		System.out.println("****** Final Cart Total ******");
		double cartTotal_before_coupon = item_1_finalCost + item_2_finalCost;
		System.out.println("Your Cart Total: " + cartTotal_before_coupon);
		double cartTotal_after_coupon = calculateCouponCost(cartTotal_before_coupon, cart_coupon_rate);
		System.out.println("Your Cart: " + cartTotal_after_coupon);
}


	
	/********** PRIVATE METHODS **********/
	
	// Print Total Cost
	private static void printTotalCost(String itemName, double totalCost) {
		System.out.println("Total cost of " + itemName + " is " + totalCost);
	}

	// Print Coupon Rate
	private static void printCouponRate(String itemName, int coupon) {
		System.out.println("Coupon rate of " + itemName + " is " + coupon + "%");
	}

	// Print Final Cost
	private static void printFinalCost(String itemName, double finalCost) {
	  System.out.println("Final cost after discount for " + itemName + " is " + finalCost);
	}
	
	// Print Cost Statistics
	private static void printCostStatistics(String name1, double finalCost1, String name2, double finalCost2){
		double maxCost = Math.max(finalCost1, finalCost2);
		double minCost = Math.min(finalCost1, finalCost2);
		
	  	System.out.println("****** Cost statistics ******");
		System.out.println("Most expensive item costs: " + maxCost);
		System.out.println("Cheapest item costs: " + minCost);
		//Print name of item which is most expensive
		if(maxCost == finalCost1) {
		  System.out.println(name1 + " is the most expensive item");
		} else {
		  System.out.println(name2 + " is the most expensive item");
		}
		//Print name of item which is least expensive
		if(minCost == finalCost1) {
		  System.out.println(name1 + " is the least expensive item");
		} else {
		  System.out.println(name2 + " is the least expensive item");
		}
	}
	
	// Print Coupon Statistics
	private static void printCouponStatistics(double coupon1, int coupon2){
		System.out.println("****** Coupon statistics ******");
		System.out.println(Math.max(coupon1, coupon2) + " percent off is awesome!!");
	}
	
	// Calculate Total Cost
	private static double calculateTotalCost(double price, int quantity) {
	  return price * quantity;
	}
	
	// Calculate Final Cost
	private static double calculateFinalCost(double totalCost, int coupon) {
	  return totalCost - (totalCost * coupon / 100);
	}
	
	// Calculate Cost with Coupon
	private static double calculateCouponCost(double cost, int coupon) {
	  double savings = cost * (coupon/100);
	  double result = cost - savings;
	  System.out.println("Coupon Savings: " + savings);
	  return result;
	}

	private static Scanner input;

}

