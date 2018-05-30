package Session6;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Session 6: Make following changes in code of week5
 *   
 *  1. Move calculation of item_1_totalCost, item_2_totalCost to method. Method should return cost. Replace current code with method. (see TODO: 2)  
 *  2. Move calculation of item_2_finalCost, item_2_finalCost to method. Method should return final cost. Replace current code with method. (see TODO: 2)
 *  3. Move calculation of coupon applied on shopping cart to a method.
 *  
 **/
public class ShoppingMain {
	public static void main(String[] args) {
	  	// Setup Prompt for Gathering Data
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
		System.out.println();

		
		// Item 2
		System.out.print("Enter name of item 2: ");
		String item_2_name = input.next();
		System.out.print("Enter price of " + item_2_name + ": ");
		double item_2_price = input.nextDouble();
		System.out.print("Enter quantity of " + item_2_name + ": ");
		int item_2_quantity = input.nextInt();
		System.out.print("Enter coupon rate for " + item_2_name + ": ");
		int item_2_coupon = input.nextInt();
		System.out.println();
		
		
		// Item 3
		System.out.print("Enter name of item 3: ");
		String item_3_name = input.next();
		System.out.print("Enter price of " + item_3_name + ": ");
		double item_3_price = input.nextDouble();
		System.out.print("Enter quantity of " + item_3_name + ": ");
		int item_3_quantity = input.nextInt();
		System.out.print("Enter coupon rate for " + item_3_name + ": ");
		int item_3_coupon = input.nextInt();
		System.out.println();

		
		// Price x Quantity for Total Cost
		double item_1_totalCost = calculateTotalCost(item_1_price, item_1_quantity);
		double item_2_totalCost = calculateTotalCost(item_2_price, item_2_quantity);
		double item_3_totalCost = calculateTotalCost(item_3_price, item_3_quantity);
		printTotalCost(item_1_name, item_1_totalCost);
		printTotalCost(item_2_name, item_2_totalCost);
		printTotalCost(item_3_name, item_3_totalCost);
		System.out.println();

		
		// Coupon Rates
		printCouponRate(item_1_name, item_1_coupon);
		printCouponRate(item_2_name, item_2_coupon);
		printCouponRate(item_3_name, item_3_coupon);
		System.out.println();


		// Calculate Final Cost
		double item_1_finalCost = calculateFinalCost(item_1_totalCost, item_1_coupon);
		double item_2_finalCost = calculateFinalCost(item_2_totalCost, item_2_coupon);
		double item_3_finalCost = calculateFinalCost(item_3_totalCost, item_3_coupon);
		printFinalCost(item_1_name, item_1_finalCost);
		printFinalCost(item_2_name, item_2_finalCost);
		printFinalCost(item_3_name, item_3_finalCost);
		System.out.println();

		
		printCostStatistics(item_1_name, item_1_finalCost, item_2_name, item_2_finalCost, item_3_name, item_3_finalCost);		
		System.out.println();

		printCouponStatistics(item_1_coupon, item_2_coupon, item_3_coupon);
		System.out.println();

		
		// Calculate and print cost after coupon code
		int cart_coupon_rate = getCartCouponRate();
		System.out.println("****** Final Cart Total ******");
		double cartTotal_before_coupon = item_1_finalCost + item_2_finalCost + item_3_finalCost;
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
	private static void printCostStatistics(String name1, double finalCost1, String name2, double finalCost2, String name3, double finalCost3){
	  double maxCost = 0;
	  if(finalCost1 > finalCost2 && finalCost1 > finalCost3) {
		maxCost = finalCost1;
	  } else if(finalCost2 > finalCost1 && finalCost2 > finalCost3) {
		maxCost = finalCost2;
	  } else if(finalCost3 > finalCost1 && finalCost3 > finalCost2) {
		maxCost = finalCost3;
	  }
	  
	  double minCost = 0;
	  if(finalCost1 < finalCost2 && finalCost1 < finalCost3) {
		minCost = finalCost1;
	  } else if(finalCost2 < finalCost1 && finalCost2 < finalCost3) {
		minCost = finalCost2;
	  } else if(finalCost3 < finalCost1 && finalCost3 < finalCost2) {
		minCost = finalCost3;
	  }
		
	  	System.out.println("****** Cost statistics ******");
		System.out.println("Most expensive item costs: " + dollarFormat(maxCost));
		System.out.println("Cheapest item costs: " + dollarFormat(minCost));
		//Print name of item which is most expensive
		if(maxCost == finalCost1) {
		  System.out.println(name1 + " is the most expensive item");
		} else if(maxCost == finalCost2) {
		  System.out.println(name2 + " is the most expensive item");
		} else {
		  System.out.println(name3 + " is the most expensive item");
		}
		//Print name of item which is least expensive
		if(minCost == finalCost1) {
		  System.out.println(name1 + " is the least expensive item");
		} else if(minCost == finalCost2){
		  System.out.println(name2 + " is the least expensive item");
		} else {
		  System.out.println(name3 + " is the least expensive item");
		}
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

