package Session3;

import java.util.Scanner;

/*
Session 3: Make following changes in code of week2 
*  1. Take all inputs from users, see item_1_name and item_1_price and complete all TODO's
*  2. Convert data type for item_1_finalCost and item_2_finalCost to double
*  
**/
public class ShoppingMain {
	public static void main(String[] args) {
	  
	  	// Utilities
	  	input = new Scanner(System.in);

	  	// Item 1
        System.out.print("Enter name of item1: ");
        String item_1_name = input.next();
        
        System.out.print("Enter price of item1: ");
        int item_1_price = input.nextInt();
        
        System.out.print("Enter quantity of item 1: ");
        int item_1_quantity = input.nextInt();
        
        // Item 2
        System.out.print("Enter name of item2: ");
        String item_2_name = input.next();

        System.out.print("Enter price of item2: ");
        int item_2_price = input.nextInt();
        
        System.out.print("Enter quantity of item 2: ");
        int item_2_quantity = input.nextInt();

        //“To calculate the totalCost, multiply the price of the item by quantity of the item”
        int item_1_totalCost = item_1_price * item_1_quantity;
        int item_2_totalCost = item_2_price * item_2_quantity;

        System.out.println("Total cost of " + item_1_name + " is " + item_1_totalCost);
        System.out.println("Total cost of " + item_2_name + " is " + item_2_totalCost);

        // Coupons
        System.out.print("Enter your coupon percentage for " + item_1_name + ": ");
        int item_1_coupon = input.nextInt();

        System.out.print("Enter your coupon percentage for " + item_2_name + ": ");
        int item_2_coupon = input.nextInt();

        //“To calculate the discount, multiply the price of the item by the discount percentage in the coupon”
        int item_1_finalCost = item_1_totalCost - (item_1_totalCost * item_1_coupon / 100);
        int item_2_finalCost = item_2_totalCost - (item_2_totalCost * item_2_coupon / 100);

        System.out.println("Final cost after discount for " + item_1_name + " is " + item_1_finalCost);
        System.out.println("Final cost after discount for " + item_2_name + " is " + item_2_finalCost);
    }

	
	//********** PRIVATE METHODS **********//
	
	private static Scanner input;
}