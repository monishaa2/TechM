import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string");
        String s =sc.nextLine();
int i;
        char[] c = s.toCharArray();

        for(i =0; i<c.length;i++)
        {
            if(i%2 == 0)
            {
                c[i] = Character.toUpperCase(c[i]);
            }
        }
        System.out.println(new String(c));

    }
}