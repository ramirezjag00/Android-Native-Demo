public class NestedForLoops {
  public static void main(String[] args) { 
    // print 10 lines of 5 stars each

    // using for loop
    for(int i = 1; i <= 10; i++) {
      for(int j = 1; j <= 5; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // print decreasing stars per line

    // using for loop
    for(int i = 1; i <= 5; i++) {
      for(int j = i; j <= 5; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // print increasing stars per line

    // using for loop
    for(int i = 1; i <= 5; i++) {
      for(int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // print decreasing stars per line, but on flex-end or trailing

    // using for loop
    for(int i = 1; i <= 5; i++) {
      for(int k = 1; k <= i - 1; k++) {
        System.out.print(" ");
      }
      for(int j = 5; j >= i; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
