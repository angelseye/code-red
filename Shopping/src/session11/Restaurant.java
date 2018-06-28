package session11;

public class Restaurant {

  // Properties
  private String name;
  private String state;
  private String foodType;
  private int businessLicenseNumber;
  private char grade;
  
  
  // Constructors
  public Restaurant(String name, String state, String foodType, int businessLicenseNumber, char grade) {
	this.name = name;
	this.state = state;
	this.foodType = foodType;
	this.businessLicenseNumber = businessLicenseNumber;
	this.grade = grade;
  }


  // Getters / Setters
  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public String getState() {
	return state;
  }

  public void setState(String state) {
	this.state = state;
  }

  public String getFoodType() {
	return foodType;
  }

  public void setFoodType(String foodType) {
	this.foodType = foodType;
  }

  public int getBusinessLicenseNumber() {
	return businessLicenseNumber;
  }

  public void setBusinessLicenseNumber(int businessLicenseNumber) {
	this.businessLicenseNumber = businessLicenseNumber;
  }

  public char getGrade() {
	return grade;
  }

  public void setGrade(char grade) {
	this.grade = grade;
  }  
  
  
  
  
  
}
