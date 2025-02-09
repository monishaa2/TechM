import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void processInput(double number) {
        if (number == 0) {
            throw new ArithmeticException("Zero is invalid. Do not enter zero.");
        }
        double r = 1 / number;
        System.out.println("The reciprocal of " + number + " is " + r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Enter a number: ");
            double number = sc.nextDouble();


            processInput(number);

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a valid integer.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

            sc.close();

    }
}