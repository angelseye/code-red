package ShoppingList;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  /********** Properties **********/
  private double total;
  private List<Item> itemList;
  
  
  /********** Constructor **********/
  public Cart() { 
	itemList = new ArrayList<Item>();
  }


  /********** Getters / Setters **********/
  public double getTotal() {
    return this.total;
  }


  public void setTotal() {
	double newTotal = 0.0;
	// loop through items and calculate total
	for(int i=0; i<this.itemList.size(); i++) {
	  newTotal += itemList.get(i).getFinalCost();
	}
	this.total = newTotal;
  }
  
  public List<Item> getItemList() {
    return itemList;
  }



  /********** Methods **********/
  
    /***** Public *****/
  
  // Add Item to Cart
  public void putItemInCart(Item item) {
	this.itemList.add(item);
	this.setTotal();
  }
  
  // Remove Item from Cart
  public static void removeItemFromCart() {
	
  }
  
  
  /***** Private *****/
  
}
