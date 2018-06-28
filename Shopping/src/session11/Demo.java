package session11;

import java.io.*;

public class Demo {

  public static void main(String[] args) throws IOException {
	
	// Setup
	RestaurantHelper helper = new RestaurantHelper();
	
	// Create a restaurant
	Restaurant foodPlace = new Restaurant("Tokyo Sushi", "TN", "Japanese", 12345, 'A');
	
	
	String name = foodPlace.getName();
	String businessNameInAllUpperCase = helper.makeRestaurantNameAllCaps(name);
	System.out.println(businessNameInAllUpperCase);
	
	char grade = foodPlace.getGrade();
	boolean shouldIEatThere = helper.isGradeAboveC(grade);
	System.out.println(shouldIEatThere);
	
	String state = foodPlace.getState();
	boolean restaurantIsValid = helper.isRestaurantInValidState(state);
	System.out.println(restaurantIsValid);

	
	
	File inputFile = new File("src/session11/input");
	InputStream input = new FileInputStream(inputFile);
	
	byte [] byteArray = new byte[11];
	int totalBytesRead = input.read(byteArray);
	System.out.println("Total number of bytes read to the array: " + totalBytesRead);
	
	for(int i=0; i<byteArray.length; i++) {
	  byte data = byteArray[i];
	  char result = (char)data;
	  System.out.print(result);
	}
  }

}
