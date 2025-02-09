import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Car[] cars = new Car[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the make of car: ");
            String make = sc.nextLine();

            System.out.println("Enter the model of car: ");
            String model = sc.nextLine();

            System.out.println("Enter the year of car: ");
            int year = sc.nextInt();
            sc.nextLine();

            System.out.println("Is your car electric? (yes/no): ");
            String isElectric = sc.nextLine();

            if (isElectric.equalsIgnoreCase("yes")) {
                System.out.println("Enter the battery range (in km): ");
                int batteryRange = sc.nextInt();
                sc.nextLine();
                cars[i] = new ElectricCar(make, model, year, batteryRange);
            } else {
                cars[i] = new Car(make, model, year);
            }
        }
    }
}