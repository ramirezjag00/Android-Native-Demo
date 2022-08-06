public class Foo {
  public static void main(String[] args) {
    // initializing a Student object with empty constructor
    Student student1 = new Student();
    
    // filling up properties of initialized empty student
    // student1.name = "John";
    // student1.age = 18;
    // student1.color = "black";
    // student1.sex = 'm';

    // even call methods of it
    // student1.Eating();
    // student1.Drinking();
    // student1.Running();

    System.out.println(student1.name);

    Student student2 = new Student("Jane",18,"white",'f');
    System.out.println(student2.name);
  }
}