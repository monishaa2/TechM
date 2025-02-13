import java.util.List;
import java.util.Stack;

public class Stackthread extends Thread {

    public void run()
    {
        List<Integer> s1 = new Stack<>();
        s1.add(10);
        s1.add(20);
        s1.add(30);
        s1.add(40);
        s1.add(50);
        s1.add(60);
        s1.add(70);
        s1.add(80);

        System.out.println("Number of elements in the list: "+ s1.size());

        s1.add(90);
        System.out.println("After adding one element:");
        System.out.println("The given list is :"+ s1);
        System.out.println("The number of elements in the list: "+ s1.size());

        System.out.println("Is 500 available in the list:"+ s1.contains(500));
        System.out.println("The given list before removing elements is :"+ s1);

        s1.remove(2);
        s1.remove(3);
        s1.remove(5);
        System.out.println("After removing elements:");
        System.out.println("The given list is :"+ s1);
        System.out.println("The number of elements in the list: "+ s1.size());


    }
}
