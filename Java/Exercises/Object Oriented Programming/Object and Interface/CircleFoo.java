public class CircleFoo implements Shape {
  int x;
  int y;
  double radius;

  public CircleFoo(int x, int y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  @Override
  public double CalculateArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public double CalculatePerimeter() {
    return 2 * Math.PI * radius;
  }
}
