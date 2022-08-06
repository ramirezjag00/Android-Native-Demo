public class Student {
  // Properties
  String name;
  int age;
  String color;
  char sex;

  // Methods
  void Eating() {
    System.out.println("Eating");
  }

  void Drinking() {
    System.out.println("Drinking");
  }

  void Running() {
    System.out.println("Running");
  }

  // empty constructor
  public Student() {

  }

  // full constructor of student
  // not all properties have to be initialized
  public Student(String name, int age, String color, char sex) {
    this.name = name;
    this.age = age;
    this.color = color;
    this.sex = sex;
  }
}