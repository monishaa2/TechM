import java.util.ArrayList;
import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the arraylist");
        int s = sc.nextInt();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            list1.add(sc.nextInt());
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.addAll(list1);

        System.out.println("list2 elements copied from list1 "+list2);

    }
}