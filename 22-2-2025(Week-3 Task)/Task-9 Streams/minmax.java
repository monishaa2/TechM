
    import java.util.Arrays;
import java.util.List;
import java.util.Optional;
    public class minmax {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(25, 12, 45, 89, 32, 7, 98);

            Optional<Integer> max = numbers.stream().max(Integer::compareTo);
            Optional<Integer> min = numbers.stream().min(Integer::compareTo);

            System.out.println("Maximum Value: " + max.get());
            System.out.println("Minimum Value: " + min.get());
        }
    }



