import java.util.LinkedList;

public class task16 {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();


        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Original LinkedList: " + list);


        list.addFirst(5);
        list.addLast(50);

        System.out.println("Updated LinkedList: " + list);
    }
}
