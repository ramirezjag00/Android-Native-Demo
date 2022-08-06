// Child class
// SubClass of Employee

public class Marketer extends Employee {
  public boolean insideMarker() {
    return true;
  }

  @Override
  public int getHours() {
    // make it 50 instead of 40
    return 50;
  }

  @Override
  public double getSalary() {
    return 5500;
  }

  @Override
  public int getVacationDays() {
    return 5;
  }
}
