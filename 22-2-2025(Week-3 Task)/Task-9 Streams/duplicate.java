
    import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

    public class duplicate {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(10, 20, 30, 10, 40, 50, 20, 60);

            List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());

            System.out.println("List without Duplicates: " + uniqueNumbers);
        }
    }

