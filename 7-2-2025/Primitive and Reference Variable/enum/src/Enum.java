import java.util.Scanner;

enum DaysOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Enum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a day:");
        String input = sc.nextLine().toUpperCase();


            DaysOfWeek day = DaysOfWeek.valueOf(input);
            checkDay(day);
        
    }

    public static void checkDay(DaysOfWeek day) {
        switch (day) {
            case SATURDAY:
            case SUNDAY:
                System.out.println(day + " is a Holiday!");
                break;
            default:
                System.out.println(day + " is Not a Holiday.");
        }
    }
}
