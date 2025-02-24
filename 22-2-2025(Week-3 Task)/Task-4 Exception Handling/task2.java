public class task2 {

        public static void main(String[] args) {
                try {
                    checkNumber(5);
                } catch (OddNumberException e) {
                    System.out.println("Caught Exception: " + e.getMessage());
                }
            }
          public static void checkNumber(int num) throws OddNumberException {
            if (num % 2 != 0) {
                throw new OddNumberException("Number is odd");
            }
            System.out.println("Number is even");

        }
    }

class OddNumberException extends Exception {
     OddNumberException(String message) {
        super(message);
    }
}