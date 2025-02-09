import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number 1: ");
        int a = sc.nextInt();

        System.out.println("Enter number 2: ");
        int b = sc.nextInt();

        int q = 0;
        int r = a;

        while (r >= b) {
            r = r - b;
            q = q + 1;
        }

        System.out.println("Quotient: " + q);
        System.out.println("Remainder: " + r);
    }
}
