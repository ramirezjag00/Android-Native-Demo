public class AssigningVariables {
  public static void main(String[] args) {
    // Declaration
    int x;
    double y;
    int a, b, c; // multi-line variable declaration

    // Basic assignment
    x = 2 + 3;
    y = 3.4 * 2.9;

    // Int vs Double
    // x = 3.4 * 2.9; you cannot assign/store the expression to x since x is int;
    // y = 2 + 3; you can assign this to y since Java promotes integer to double

    // Type Casting
    // x = (int) (3.4 * 2.9);
    // we know that this should've been a double but we can say that
    // make this as int, which is 9

    // Multi-Assignment
    // assignment variables is done from right to left
    // expression calculated then assigned to c then to b then to a
    a = b = c = 2 * 5 + 4; // a = (b = (c = 2 * 5 + 4));
  } 
}
