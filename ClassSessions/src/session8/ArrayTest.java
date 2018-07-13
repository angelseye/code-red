package session8;

import java.util.Arrays;

public class ArrayTest {

  public static void main(String[] args) {
	int [] numbers;
	numbers = new int[5];
	
	numbers[0] = 6;
	for(int i=1; i<numbers.length; i++) {
	  numbers[i] = numbers[i-1]+1;
	}
	System.out.println(Arrays.toString(numbers));
  }

}
