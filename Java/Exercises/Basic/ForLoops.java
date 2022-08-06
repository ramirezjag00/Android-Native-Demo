public class ForLoops {
  public static void main(String[] args) { 
    // Get the squares of 1st 5 integers;
    
    // naive approach
    System.out.println(1 + " squared = " + (1*1));
    System.out.println(2 + " squared = " + (2*2));
    System.out.println(3 + " squared = " + (3*3));
    System.out.println(4 + " squared = " + (4*4));
    System.out.println(5 + " squared = " + (5*5));

    // using for loop
    for(int i = 1; i <= 5; i++) {
      System.out.println(i + " squared = " + (i*i));
    }
  }
}
