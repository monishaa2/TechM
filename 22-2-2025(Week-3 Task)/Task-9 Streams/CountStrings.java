import java.util.Arrays;
import java.util.List;

public class CountStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Apricot", "Blueberry", "Avocado", "Cherry");

        long count = words.stream().filter(word -> word.startsWith("A")).count();

        System.out.println("Count of words starting with 'A': " + count);
    }
}

