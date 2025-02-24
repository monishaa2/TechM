import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the arraylist");
        int s = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            list.add(sc.nextInt());
        }

        System.out.println("enter the number to be searched");
        int k = sc.nextInt();
        System.out.println("the number " + k + " is present :" + list.contains(k));
    }
}
