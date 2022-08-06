public class PrimitiveDataType {
  public static void main(String args[]) {
    // creating variables

    // Integers
    byte a = 1; // 1byte -128 to 127 default 0
    short b = 99; // 2bytes -32768 to 32767 default 0
    int c = 10; // 4bytes -2,147,483,648 to 2,147,483,647 default 0
    long d = 103123123l; // 8bytes -9,223,372,036,854,775,808 to 9,223,372,036,854,750,000 default 0
    
    // Floating Point
    float e = 1.01f; // 4bytes 3.4e-038 to 3.4e+038 default 0.0f
    double f = 1.231451298797d; // 8bytes 1.7e-308 to 1.7e+038 default 0.0d
    
    //Boolean
    boolean g = true; // 1bit true or false default false

    // Character
    char h = 'J'; // 2bytes \u0000 to \uFFFF default \u0000 

    // printing variables

    // Integers
    System.out.println("a = "+a);
    System.out.println("b = "+b);
    System.out.println("c = "+c);
    System.out.println("d = "+d);

    // Floating Point
    System.out.println("e = "+e);
    System.out.println("f = "+f);

    //Boolean
    System.out.println("g = "+g);

    //Character
    System.out.println("h = "+h);
  }
}
