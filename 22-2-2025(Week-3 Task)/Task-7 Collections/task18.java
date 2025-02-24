import java.util.LinkedList;
import java.util.Scanner;

public class task18 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Original LinkedList: " + list);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an element to insert at the front: ");
        int newElement = sc.nextInt();

        list.addLast(newElement);

        System.out.println("Updated LinkedList: " + list);
        sc.close();
    }
}
