import java.util.List;
import java.util.Vector;

public class Vectorthread extends Thread {

    public void run()
    {
        List<Integer> v1 = new Vector<>();
        v1.add(10);
        v1.add(20);
        v1.add(30);
        v1.add(40);
        v1.add(50);
        v1.add(60);
        v1.add(70);
        v1.add(80);

        System.out.println("Number of elements in the list: "+ v1.size());

        v1.add(90);
        System.out.println("After adding one element:");
        System.out.println("The given list is :"+ v1);
        System.out.println("The number of elements in the list: "+ v1.size());

        System.out.println("Is 500 available in the list:"+ v1.contains(500));
        System.out.println("The given list before removing elements is :"+ v1);

        v1.remove(2);
        v1.remove(3);
        v1.remove(5);
        System.out.println("After removing elements:");
        System.out.println("The given list is :"+ v1);
        System.out.println("The number of elements in the list: "+ v1.size());


    }
}
