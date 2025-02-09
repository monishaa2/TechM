
import java.util.Scanner;
import java.lang.String;


public class  StringProcessor{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string");
        String sample = sc.nextLine();
        reverse(sample);

        System.out.println("enter the text");
        String  text = sc.nextLine();
        System.out.println("enter the sub");
        String  sub = sc.nextLine();
        CountOccurences(text,sub);
        System.out.println("enter a word to split and capitalize ");
        String str = sc.nextLine();
        splitAndCapitalize( str);


    }

    public static void reverse(String sample)
    {
        StringBuilder s = new StringBuilder(sample);

        System.out.println("the reverse of the given String is :" +s.reverse());
    }
    public static void CountOccurences(String text , String sub)
    {
        int count = text.indexOf(sub);
        System.out.println(count);

    }
    public static void splitAndCapitalize(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i == 0 || chars[i - 1] == ' ') {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }

        System.out.println(chars);
    }

}
