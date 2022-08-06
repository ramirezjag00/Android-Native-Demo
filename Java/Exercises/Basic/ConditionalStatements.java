import java.util.Random;

public class ConditionalStatements {
  public static void main(String[] args) { 
    int i = new Random().nextInt(10);

    if (i < 5) {
      System.out.println("Code 1: "+i);
    } else if (i > 5) {
      System.out.println("Code 2: "+i);
    } else {
      System.out.println("Code 3: "+i);
    }
  } 
}
