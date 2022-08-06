public class Strings {
  public static void main(String[] args) {
    // Basic string variables
    String k = "Hello";
    String m = "World!";

    // Basic string concatenation
    System.out.println(k + " " + m);

    // check if string contains a substring
    System.out.println(k.contains("o"));

    // print the index of a substring
    System.out.println(m.indexOf("d"));

    // print the uppercase of the string
    System.out.println(k.toUpperCase());

    // print the string with replaced ! to ?
    System.out.println(m.replace("!", "?"));

    // loop into the string's index and print each charAt index
    for(int i = 0; i < m.length(); i++) {
      System.out.println(m.charAt(i));
    }

    // print the substring of a string from a beginIndex to endIndex
    System.out.print(m.substring(1, 4));
  } 
}
