// Child class
// SubClass of Employee
public class Lawyer extends Employee {
  public char getLawyerPosition() {
    return 'm';
  }

  @Override
  public double getSalary() {
    return super.getSalary() + 500;
  }
}
