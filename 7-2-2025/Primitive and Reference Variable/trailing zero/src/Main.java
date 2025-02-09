import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number");
        int n = sc.nextInt();
        int count =0;

        int i =1;
        while(n!=0)
        {
            i = i*n;
            n--;
        }
        System.out.println(i);

        while(i%10 == 0)
        {
            count++;
            i/=10;
        }


        System.out.println(count);

    }
}