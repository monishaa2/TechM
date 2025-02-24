import java.util.ArrayList;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args)
    {Scanner sc =new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(56);
        list.add(98);
        list.add(10);
        list.add(56);
        list.add(45);
        System.out.println("the original list" +list);
        System.out.println("enter the index (0 to 5)");
        int n = sc.nextInt();
        System.out.println("enter the element");
        int k =sc.nextInt();
        list.set(n,k);

        System.out.println("updated list" + list );
    }
}
