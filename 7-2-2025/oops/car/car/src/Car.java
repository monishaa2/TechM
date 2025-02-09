public class Car {
    private int year;
    private String model;
    private String make;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void startEngine() {
        System.out.println(make + " " + model + " (" + year + ") engine has started.");
    }
}
