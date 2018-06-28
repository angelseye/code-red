package session11;

public class RestaurantHelper {

  public RestaurantHelper() {
	
  }
  
  public String makeRestaurantNameAllCaps(String name) {
	return name.toUpperCase();
  }
  
  public boolean isGradeAboveC(char grade) {
	if(grade == 'A' || grade == 'B') {
	  return true;
	}
	return false;
  }
  
  public boolean isRestaurantInValidState(String state) {
	String [] listOfValidStates = new String[2];
	listOfValidStates[0] = "Alabama";
	listOfValidStates[1] = "Tennessee";
	
	for (int i=0; i<listOfValidStates.length; i++) {
	  if(state.equals(listOfValidStates[i])) {
		return true;
	  }
	}
	return false;
  }
}
