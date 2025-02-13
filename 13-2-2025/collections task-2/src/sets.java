import java.util.*;

public class sets {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        setsample(hs);

        LinkedHashSet<String> s = new LinkedHashSet<>();
        setsample(s);

        TreeSet<Double> t = new TreeSet<>();
        setsample(t);

    }

    public static void setsample(HashSet<Integer> hs) {
        hs.add(12);
        hs.add(21);
        hs.add(35);
        hs.add(40);
        hs.add(49);
        hs.add(33);
        hs.add(70);
        hs.add(42);

        System.out.println("HashSet Size: " + hs.size());
        System.out.println("Elements in HashSet: " + hs);

        hs.remove(35);
        System.out.println("HashSet after removing one element: " + hs);

        System.out.println("The numbers that are divisible by 7 in the HashSet are:");
        for (Integer element : hs) {
            if (element % 7 == 0) {
                System.out.print(element + " ");
            }
        }
        System.out.println("\n");

        System.out.println("The elements in the HashSet:");
        Iterator<Integer> i = hs.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println("\n");
        System.out.println("-------------------------------------------------------------------------------");
    }

    public static void setsample(LinkedHashSet<String> s) {
        s.add("college");
        s.add("abc");
        s.add("sandhya");
        s.add("anisha");
        s.add("harini");
        s.add("nivetha");
        s.add("training");
        s.add("java");

        System.out.println("LinkedHashSet size: " + s.size());
        System.out.println("Elements in LinkedHashSet: " + s);

        s.remove("college");
        System.out.println("LinkedHashSet after removing one element: " + s);

        System.out.println("Strings with more than 5 characters:");
        for (String element : s) {
            if (element.length() > 5) {
                System.out.print(element + " ");
            }
        }
        System.out.println("\n");
        System.out.println("-------------------------------------------------------------------------------");

    }
    public static void setsample(TreeSet<Double> t) {
        t.add(12.0);
        t.add(21.58);
        t.add(35.65);
        t.add(40.14);
        t.add(49.45);
        t.add(33.78);
        t.add(70.79);
        t.add(42.56);

        System.out.println("TreeSet Size: " + t.size());
        System.out.println("Elements in HashSet: " + t);

        t.remove(35.65);
        System.out.println("HashSet after removing one element: " + t);

        System.out.println("The numbers that are greater than 20 are:");
        for (Double element : t) {
            if (element >20) {
                System.out.print(element + " ");
            }
        }
        System.out.println("\n");

        System.out.println("The elements in the TreeSet:");
        Iterator<Double> i = t.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
