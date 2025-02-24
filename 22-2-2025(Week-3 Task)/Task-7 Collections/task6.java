import java.util.ArrayList;
import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        System.out.println("enter the size of the arraylist");
        int s = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<s;i++)
        {
            list.add(sc.nextInt());
        }
        System.out.println("original array" + list);
        if(list.size()>=3) {
            list.remove(3);
        }
        System.out.println("updated array after removing element from thord index" + list);


    }}
