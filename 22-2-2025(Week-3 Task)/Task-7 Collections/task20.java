import java.util.LinkedList;
import java.util.Scanner;
public class task20 {



        public static void main(String[] args) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(40);
            list.add(20);
            list.add(50);
            list.add(20);

            Scanner sc = new Scanner(System.in);
            int element = sc.nextInt();

            System.out.println(list.indexOf(element));
            System.out.println(list.lastIndexOf(element));
        }
    }


