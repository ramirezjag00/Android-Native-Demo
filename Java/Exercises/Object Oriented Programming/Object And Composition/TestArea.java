public class TestArea {
  public static void main(String[] args) {
    Point center = new Point(5,5);
    Circle c1 = new Circle(center, 10);

    // Bad Practice
    Circle c2 = new Circle(5,5, 10);

    System.out.println(c1.CalculateArea());
    System.out.println(c2.CalculateArea());
  }
}
