import java.util.ArrayList;

public class task3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(45);
        list.add(65);
        list.add(13);
        list.add(85);
        list.add(98);
        System.out.println("before updation " +list);
        list.add(0,100);
        System.out.println("after updation" +list);


    }
}

