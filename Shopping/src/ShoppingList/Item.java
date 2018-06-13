package ShoppingList;

public class Item {
  
  // Properties
  private String name;
  private double price;
  private int quantity;
  private int coupon;
  private double totalCost;
  
  
  // Constructor
  public Item() {
	this.name = "Item Name";
	this.price = 0.00;
	this.quantity = 0;
	this.coupon = 0;
	this.totalCost = 0;
  }
  
  
  // Getters / Setters
  public void setName(String name) {
	this.name = name;
  }
  
  public String getName() {
	return this.name;
  }
  
  public void setPrice(double price) {
	this.price = price;
  }
  
  public double getPrice() {
	return this.price;
  }
  
  public void setQuantity(int quantity) {
	this.quantity = quantity;
  }
  
  public int getQuantity() {
	return this.quantity;
  }
  
  public void setCoupon(int coupon) {
	this.coupon = coupon;
  }
  
  public int getCoupon() {
	return this.coupon;
  }
  
  
  // Methods
  public double calculateTotalCost() {
	this.totalCost = this.price * this.quantity;
	return this.totalCost;
  }
  
  public double calculateFinalCost() {
	return this.totalCost - (this.totalCost * this.coupon / 100);
  }
}
