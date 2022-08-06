public class PrePostIncrement {
  public static void main(String[] args) {
    int x = 0;

    x = x + 1;
    System.out.println(x);
    x += 1; // Post-Increment
    System.out.println(x);
    x -= 1;
    System.out.println(x);
    x++; // Post-Increment;
    System.out.println(x);
    x--;
    System.out.println(x);
    x *= 2;
    System.out.println(x);
    x /= 2;
    System.out.println(x);
    x &= 2;
    System.out.println(x);
    ++x; // Pre-Increment
    System.out.println(x);
  }
}
