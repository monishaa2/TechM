import java.util.Scanner;

public class Readinput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        System.out.println("You entered: " + input);
    }
}
