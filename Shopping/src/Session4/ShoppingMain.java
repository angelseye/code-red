package Session4;

import java.util.Scanner;

/**
 * Session 4: Make following changes in code of week3
 * 
 * 1. See void method to printTotalCost - Fully implemented
 * 2. Complete implementation of method printCouponRate - Partially implemented
 * 3. Implement method for printFinalCost - Not implemented
 * 4. Study method printCostStatistics - Fully implemented
 * 5. Complete implementation of printCouponStatistics - Partially implemented
 * 
 **/
public class ShoppingMain {
	public static void main(String[] args) {

		input = new Scanner(System.in);

		// Item 1
		System.out.print("Enter name of item 1: ");
		String item_1_name = input.next();

		System.out.print("Enter price of " + item_1_name + ": ");
		int item_1_price = input.nextInt();

		System.out.print("Enter quantity of " + item_1_name + ": ");
		int item_1_quantity = input.nextInt();

		// Item 2
		System.out.print("Enter name of item 2: ");
		String item_2_name = input.next();

		System.out.print("Enter price of " + item_2_name + ": ");
		int item_2_price = input.nextInt();

		System.out.print("Enter quantity of " + item_2_name + ": ");
		int item_2_quantity = input.nextInt();

		// Price x Quantity for Total Cost
		int item_1_totalCost = calculateTotalCost(item_1_price, item_1_quantity);
		int item_2_totalCost = calculateTotalCost(item_2_price, item_2_quantity);
		printTotalCost(item_1_name, item_1_totalCost);
		printTotalCost(item_2_name, item_2_totalCost);

		// Enter some Coupons
		System.out.print("Enter coupon rate for " + item_1_name + ": ");
		int item_1_coupon = input.nextInt();

		System.out.println("Enter coupon rate for " + item_2_name + ": ");
		int item_2_coupon = input.nextInt();

		printCouponRate(item_1_name, item_1_coupon);
		printCouponRate(item_2_name, item_2_coupon);

		// Calculate Final Cost
		double item_1_finalCost = calculateFinalCost(item_1_totalCost, item_1_coupon);
		double item_2_finalCost = calculateFinalCost(item_2_totalCost, item_2_coupon);

		printFinalCost(item_1_name, item_1_finalCost);
		printFinalCost(item_2_name, item_2_finalCost);

		printCostStatistics(item_1_finalCost, item_2_finalCost);
		printCouponStatistics(item_1_coupon, item_2_coupon);
	}


	
	/********** PRIVATE METHODS **********/
	
	// Print Total Cost
	private static void printTotalCost(String itemName, int totalCost) {
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
	private static void printCostStatistics(double finalCost1, double finalCost2){
		System.out.println("****** Cost statistics ******");
		System.out.println("Most expensive item costs : " + Math.max(finalCost1, finalCost2));
		System.out.println("Cheapest item costs : " + Math.min(finalCost1, finalCost2));
	}
	
	// Print Coupon Statistics
	private static void printCouponStatistics(int coupon1, double coupon2){
		System.out.println("****** Coupon statistics ******");
		System.out.println(Math.max(coupon1, coupon2) + " percent off is awesome!!");
	}
	
	// Calculate Total Cost
	private static int calculateTotalCost(int price, int quantity) {
	  return price * quantity;
	}
	
	// Calculate Final Cost
	private static double calculateFinalCost(int totalCost, int coupon) {
	  return totalCost - (totalCost * coupon / 100);
	}

	private static Scanner input;

}
