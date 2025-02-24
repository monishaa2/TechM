import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the arraylist");
        int s = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        System.out.println("sorted list" +list);
    }
}

