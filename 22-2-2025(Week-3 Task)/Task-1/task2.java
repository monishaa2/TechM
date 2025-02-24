import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Student " + (i + 1) + " details:");

            System.out.println("Enter the student name:");
            String name = sc.nextLine();

            System.out.println("Enter the English mark:");
            int english = sc.nextInt();

            System.out.println("Enter the Maths mark:");
            int maths = sc.nextInt();

            System.out.println("Enter the Science mark:");
            int science = sc.nextInt();

            System.out.println("Enter the Social mark:");
            int social = sc.nextInt();

            System.out.println("Enter the Tamil mark:");
            int tamil = sc.nextInt();
            sc.nextLine();

            list.add(new Student(name, maths, english, science, social, tamil));
        }


        Collections.sort(list);

        // Display sorted student details
        System.out.println("\nSorted Student List (by Total Marks):");
        System.out.printf("%-10s %-10s %-10s\n", "Name", "Total", "Average");
        System.out.println("-----------------------------------");

        for (Student s : list) {
            System.out.printf("%-10s %-10d %-10.2f\n", s.getName(), s.getTotal(), s.getAverage());
        }

        sc.close();
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int maths, english, science, social, tamil;
    private int total;
    private double average;

    // Constructor
    Student(String name, int maths, int english, int science, int social, int tamil) {
        this.name = name;
        this.english = english;
        this.maths = maths;
        this.tamil = tamil;
        this.science = science;
        this.social = social;
        calculateTotalAndAverage();
    }

    private void calculateTotalAndAverage() {
        this.total = maths + english + science + social + tamil;
        this.average = total / 5.0;
    }

    public int getTotal() {
        return total;
    }

    public double getAverage() {
        return average;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student other) {
        return other.getTotal() - this.getTotal();
    }
}
