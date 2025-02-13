import java.util.LinkedList;
import java.util.List;

public class Linkedthread  extends Thread{
    public void run()
    {
        List<Integer> m1 = new LinkedList<>();
        m1.add(10);
        m1.add(20);
        m1.add(30);
        m1.add(40);
        m1.add(50);
        m1.add(60);
        m1.add(70);
        m1.add(80);

        System.out.println("Number of elements in the list: "+ m1.size());

        m1.add(90);
        System.out.println("After adding one element:");
        System.out.println("The given list is :"+ m1);
        System.out.println("The number of elements in the list: "+ m1.size());

        System.out.println("Is 500 available in the list:"+ m1.contains(500));
        System.out.println("The given list before removing elements is :"+ m1);

        m1.remove(2);
        m1.remove(3);
        m1.remove(5);
        System.out.println("After removing elements:");
        System.out.println("The given list is :"+ m1);
        System.out.println("The number of elements in the list: "+ m1.size());



    }
}
