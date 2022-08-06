public class CodeTest {
  public static void main(String[] args) {
    // we use shape as the type since CircleFoo, Rectangle, Triangle implements Shape interface
    Shape shape1 = new CircleFoo(10,1,4);
    Shape shape2 = new Rectangle(4,9);
    Shape shape3 = new Triangle(10,12,4,5,6);

    System.out.println(shape1.CalculateArea());
    System.out.println(shape1.CalculatePerimeter());

    System.out.println(shape2.CalculateArea());
    System.out.println(shape2.CalculatePerimeter());

    System.out.println(shape3.CalculateArea());
    System.out.println(shape3.CalculatePerimeter());
  }
}
