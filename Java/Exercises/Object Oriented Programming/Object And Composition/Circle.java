import java.lang.reflect.Constructor;

public class Circle {
  Point center; // circle has a Point
  double radius;

  int x;
  int y;

  public Circle(Point center, double radius) {
    this.center = center;
    this.radius = radius;
  }

  // Bad Practice
  public Circle(int x, int y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public double CalculateArea() {
    return Math.PI * radius * radius;
  }
}
