import java.util.ArrayList;
import java.util.List;

public class Arraythread extends Thread {
    public void run()
    {
        List<Integer> l1 = new ArrayList<>();
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l1.add(40);
        l1.add(50);
        l1.add(60);
        l1.add(70);
        l1.add(80);

        System.out.println("Number of elements in the list: "+l1.size());

        l1.add(90);
        System.out.println("After adding one element:");
        System.out.println("The given list is :"+ l1);
        System.out.println("The number of elements in the list: "+l1.size());

        System.out.println("Is 500 available in the list:"+l1.contains(500));
        System.out.println("The given list before removing elements is :"+l1);

        l1.remove(2);
        l1.remove(3);
        l1.remove(5);
        System.out.println("After removing elements:");
        System.out.println("The given list is :"+l1);
        System.out.println("The number of elements in the list: "+l1.size());


    }

}
