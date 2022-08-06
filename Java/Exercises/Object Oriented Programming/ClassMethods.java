public class ClassMethods {
  public static void main(String[] args) {
    // Method calls within Class class inside main method
    FirstMethod("Andrey");
    int sum = AddTwoNumbers(5,7);
    double sumDouble = AddTwoNumbers(5.2,7.3,4.5);
    double sumDouble2 = AddTwoNumbers(5.2,7.3,4.5, 4.1);

    System.out.println(sum);
    System.out.println(sumDouble);
    System.out.println(sumDouble2);
  }

  // method that receives a name String argument but returns nothing
  public static void FirstMethod(String name) {
    System.out.println("Hello "+name);
  }

  // method overloading -- same function/method name as next method
  // but with 2 int parameters and returns int
  public static int AddTwoNumbers(int x, int y) {
    int result = x + y;

    return result;
  }

  // method overloading -- same function/method name as previous method
  // but with 3 double parameters and returns double
  public static double AddTwoNumbers(double x, double y, double z) {
    double result = x + y + z;

    return result;
  }
  // method overloading -- same function/method name as previous method
  // but with 4 double parameters and returns double
  public static double AddTwoNumbers(double x, double y, double z, double w) {
    double result = x + y + z + w;

    return result;
  }
}