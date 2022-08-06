import java.util.Scanner;

public class Chars {
  public static void main(String[] args) {
    char tt = 'j';
    char u = 65; // from ascii table

    char x = '\u03A9'; // unicode of omega

    // print character
    System.out.println(tt);

    // print value of ascii number
    System.out.println(u);

    // print value of unicode
    System.out.println(x);


    // char t = '\t';
    // char b = '\b';
    // char n = '\n';
    // char r = '\r';

    String j = "Hello\tworld"; // add a tab
    String k = "Hello \b World"; // add a backspace -- removes the index before it
    String l = "Hello \n world"; // add a next line
    String m = "Hello \r world"; // delete the left side of \r
    String n = "Hello \" world"; // \" backslash inside "" is an escaping character

    // print strings with escape characters
    System.out.println(j);
    System.out.println(k);
    System.out.println(l);
    System.out.println(m);
    System.out.println(n);

    char y = 'y';
    Character c = 'y';

    // check if character is a letter
    System.out.println(Character.isLetter(y));
    System.out.println(Character.isLetter(c));

    // check if it's a digit
    System.out.println(Character.isDigit(c));
    System.out.println(Character.isDigit(y));

    Scanner scanner = new Scanner(System.in);
    int z = scanner.next().charAt(0);
    // print ascii value of a letter typed by user
    System.out.println("The ascii value of "+z);
  }
}
