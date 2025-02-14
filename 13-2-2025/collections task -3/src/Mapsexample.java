import java.util.*;

public class Mapsexample {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        Hashtable<Integer, String> ht = new Hashtable<>();
        LinkedHashMap<Integer, String> lm = new LinkedHashMap<>();
        TreeMap<Integer, String> tm = new TreeMap<>();
        hashMap(hm);
        hashTable(ht);
        LinkedhashMap(lm);
        treeMap(tm);
    }

    public static void hashMap(HashMap<Integer, String> hm) {
        hm.put(1, "a");
        hm.put(2, "b");
        hm.put(3, "c");
        System.out.println("Initial Hashmap hm1 are : "
                + hm);
        hm.put(2, "For");
        System.out.println("Updated Map " + hm);
        hm.remove(1);
        System.out.println("Mappings after removal are : "
                + hm);
        System.out.println("Map traversal:");

        for (Map.Entry<Integer, String> e : hm.entrySet())
            System.out.println("Key: " + e.getKey()
                    + " Value: " + e.getValue());
        System.out.println("---------------------------------------------------------------------------------");
    }

    public static void hashTable(Hashtable<Integer, String> ht) {
        ht.put(1, "first");
        ht.put(2, "second");
        ht.put(3, "third");
        System.out.println("Initial Hashtable ht are : "
                + ht);
        ht.put(2, "For");
        System.out.println("Updated Map " + ht);
        ht.remove(1);
        System.out.println("Mappings after removal are : "
                + ht);
        System.out.println("Map traversal:");

        for (Map.Entry<Integer, String> e : ht.entrySet())
            System.out.println("Key: " + e.getKey()
                    + " Value: " + e.getValue());
        System.out.println("---------------------------------------------------------------------------------");
    }

    public static void LinkedhashMap(LinkedHashMap<Integer, String> lm) {
        lm.put(1, "college");
        lm.put(2, "engineering");
        lm.put(3, "course");
        System.out.println("Initial linkedHashMap lm are : "
                + lm);
        lm.put(2, "electronics");
        System.out.println("Updated Map " + lm);
        lm.remove(1);
        System.out.println("Mappings after removal are : "
                + lm);
        System.out.println("Map traversal:");

        for (Map.Entry<Integer, String> e : lm.entrySet())
            System.out.println("Key: " + e.getKey()
                    + " Value: " + e.getValue());

        System.out.println("---------------------------------------------------------------------------------");
    }

    public static void treeMap(TreeMap<Integer, String> tm) {
        tm.put(1, "html");
        tm.put(2, "css");
        tm.put(3, "javascript");
        System.out.println("Initial treeMap tm1 are : "
                + tm);
        tm.put(2, "sql");
        System.out.println("Updated Map " + tm);
        tm.remove(1);
        System.out.println("Mappings after removal are : "
                + tm);
        System.out.println("Map traversal:");

        for (Map.Entry<Integer, String> e : tm.entrySet())
            System.out.println("Key: " + e.getKey()
                    + " Value: " + e.getValue());
    }




}
