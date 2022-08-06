public class Arrays {
  public static void main(String[] args) {
    int[] numbers = { 10, 2, 3, 4 ,5, 23, 90 };
    String[] names = { "John", "Doe" };

    // print all values of numbers using for loop
    for(int i = 0; i < numbers.length ; i++) {
      System.out.println(numbers[i]);
    }

    // print all values of names using forEach loop
    for(String name: names) {
      System.out.println(name);
    }

    // add an element of index to numbers and print that number
    int someIndex = 2;
    numbers[someIndex] = 69;
    System.out.println(numbers[someIndex]);
  }
}
