import java.util.LinkedList;

public class task14 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);
        list.add(12);
        list.add(24);

        int n = list.size() - 1;


        for (int i = n; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}
