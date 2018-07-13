package Session7;

public class Loops {

  public static void main(String[] args) {
	int n = 10;
	while(n > 0) {
	  System.out.println(n);
	  n--;
	}
	System.out.println("Blast off!!!!!!!!");
	
	studying();
	
	countOfItems();
  }
  
  
  public static void studying() {
	int daysToExam = 7;
	while(daysToExam != 1) {
	  System.out.println("Relax, I have " + daysToExam + " days until the exam.");
	  daysToExam--;
	}
	if(daysToExam == 1) {
	  System.out.println("Aaaauuuuggghhhhh!!! There's only one day til the exam!");
	}
  }
  
  
  public static void countOfItems() {
	int countToX = 5;
	System.out.println("We're going to count to " + countToX);
	for(int i=1; i<=countToX; i++) {
	  System.out.println(i);
	}
	System.out.println("We have now counted to " + countToX);
  }

}
