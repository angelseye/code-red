package utilities;

import java.text.DecimalFormat;

public class Format {

  // Display Money Format
  public static String dollarFormat(double amount) {
	DecimalFormat dollarize = new DecimalFormat("$#0.00");
	return dollarize.format(amount);
  }
  
}
