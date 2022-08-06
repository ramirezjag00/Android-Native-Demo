import java.util.Random;

public class SwitchStatements {
  public static void main(String[] args) { 
    int i = new Random().nextInt(10);

    switch (i) {
      case 1:
      case 2:
      case 3:
      case 4:
        System.out.println("Code 1: "+i);
        break;
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
        System.out.println("Code 2: "+i);
        break;
      default:
        System.out.println("Code 3: "+i);
        break;
    }
  }
}
