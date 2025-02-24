import java.util.LinkedList;
import java.util.Scanner;

public class task19 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Original LinkedList: " + list);

        Scanner sc = new Scanner(System.in);
        System.out.println("how many elemnts are you going to insert");
        int n = sc.nextInt();
        for(int i =0;i<n;i++)
        {
            System.out.print("Enter an index to insert element: ");
            int k = sc.nextInt();
            System.out.print("Enter an element to insert: ");
            int newElement = sc.nextInt();
            list.add(k,newElement);
        }




        System.out.println("Updated LinkedList: " + list);
        sc.close();
    }
}

