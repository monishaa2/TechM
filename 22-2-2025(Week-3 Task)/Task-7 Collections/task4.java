import java.util.ArrayList;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args)
    {
       Scanner sc =new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(67);
        list.add(56);
        list.add(98);
        list.add(89);
        System.out.println("enter the index (0 to 4) from the list " +list);
        int n = sc.nextInt();
        System.out.println(list.get(n));


    }
}
