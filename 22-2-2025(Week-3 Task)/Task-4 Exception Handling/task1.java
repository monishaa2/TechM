public class task1 {
    public static void main(String[] args) {
        try {
            System.out.println(100/0);
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
