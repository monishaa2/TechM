
    import java.util.Arrays;
import java.util.List;

    public class sum {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(10, 15, 8, 23, 42, 7, 18);

            int evenSum = numbers.stream().filter(n -> n % 2 == 0).reduce(0, Integer::sum);
            int oddSum = numbers.stream().filter(n -> n % 2 != 0).reduce(0, Integer::sum);

            System.out.println("Sum of Even Numbers: " + evenSum);
            System.out.println("Sum of Odd Numbers: " + oddSum);
        }
    }


