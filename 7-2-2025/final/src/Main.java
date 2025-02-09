import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
final class Main {
    static final String Company_Name = "TechMahindra";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter your name ");
        String name = sc.nextLine();
        employee_details(name);


    }
     static final void employee_details(String name)
    {
        System.out.println(name + " is a " + Company_Name + " " + "employee" );
    }
}