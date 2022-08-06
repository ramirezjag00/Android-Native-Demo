public class Bar {
  public static void main(String[] args) {
    // initializing a Kid object with empty constructor

    Kid kid = new Kid("Jane",18,"white",'f');
    System.out.println(kid.getName());
    System.out.println(kid.getAge());
    System.out.println(kid.getColor());
    System.out.println(kid.getSex());

    kid.setAge(19);
    System.out.println(kid.getAge());
  }
}