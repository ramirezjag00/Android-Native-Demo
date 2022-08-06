public class TestCompany {
  public static void main(String[] args) {
    Employee employee = new Employee();
    Lawyer lawyer = new Lawyer();
    Secretary secretary = new Secretary();
    Marketer marketer = new Marketer();
    LegalSecretary legalSecretary = new LegalSecretary();

    System.out.println(employee.getVacationDays());

    System.out.println(lawyer.getLawyerPosition());
    System.out.println(lawyer.getSalary());

    System.out.println(secretary.getVacationDays());
    System.out.println(legalSecretary.getVacationDays());

    System.out.println(marketer.insideMarker());
    System.out.println(marketer.getHours());
    System.out.println(marketer.getVacationDays());
    System.out.println(marketer.getSalary());
  }
}
