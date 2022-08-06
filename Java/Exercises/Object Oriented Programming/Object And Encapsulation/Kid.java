public class Kid {
  // Properties
  private String name;
  private int age;
  private String color;
  private char sex;

  // Methods
  private void Eating() {
    System.out.println("Eating");
  }

  private void Drinking() {
    System.out.println("Drinking");
  }

  private void Running() {
    System.out.println("Running");
  }

  // empty constructor
  public Kid() {

  }

  // full constructor of Kid
  // not all properties have to be initialized
  public Kid(String name, int age, String color, char sex) {
    this.name = name;
    this.age = age;
    this.color = color;
    this.sex = sex;
  }

  // Getters
  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getColor() {
    return color;
  }

  public char getSex() {
    return sex;
  }

  // Setters
  public void setName(String newName) {
    this.name = newName;
  }

  public void setAge(int newAge) {
    this.age = newAge;
  }

  public void setColor(String newColor) {
    this.color = newColor;
  }

  public void setSex(char newSex) {
    this.sex = newSex;
  }
}

// NOTE: only the class, constructor, getters and setters should be in public