import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class task15 {
    public static void main(String[] args) {
        LinkedList<Integer> list =new LinkedList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);
        list.add(12);
        list.add(24);

        System.out.println("original list" +list);
        Scanner sc =new Scanner(System.in);
        System.out.println("enter a index ");
        int n = sc.nextInt();
        int k =sc.nextInt();
        list.add(n,k);
        System.out.println("updated list"+list);

    }
}



