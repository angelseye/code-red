package Session5;

public class Conditional {

  public static void main(String[] args) {
	int numberOne = 4;
	int numberTwo = 5;
	sum(numberOne, numberTwo);
	sum(100, 50);
  }
  
  public static void sum(int num1, int num2) {
	int sum = num1 + num2;
	System.out.println("The sum is " + sum);	
  }

}
