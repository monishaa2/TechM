
    import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
    public class sort {

        public static void main(String[] args) {
            List<String> words = Arrays.asList("Banana", "Apple", "Cherry", "Mango", "Grapes");

            List<String> ascendingOrder = words.stream().sorted().collect(Collectors.toList());
            List<String> descendingOrder = words.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());

            System.out.println("Ascending Order: " + ascendingOrder);
            System.out.println("Descending Order: " + descendingOrder);
        }
    }

