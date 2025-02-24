import java.util.Scanner;

public class employee {

    String empName;
    int empId;
    double sal;
    double exp;



    public void getEmployeeDetails()
    {

        System.out.println("Employee Id:" + this.empId);
        System.out.println("Employee Name:" + this.empName);
        System.out.println("Employee Salary:"+this.sal);

    }

    public void setEmployeeDetails()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the employee name");
        empName = sc.nextLine();
        System.out.println("enter the employee id");
        empId = sc.nextInt();
        System.out.println("enter the employee salary");
        sal =sc.nextDouble();
        System.out.println("enter the experience of employee");
        exp =sc.nextDouble();


    }

    public void getLoanEligibility()
    {
        double annualsal = sal*12;
        if(exp>5) {
               if (annualsal > 6) {
                System.out.println("eligible for loan amount of 2 lakhs");
            } else if (annualsal >= 10) {
                System.out.println("eligible for loan amount of 5 lakhs");
            } else if (annualsal >= 15) {
                System.out.println("eligible for loan amount of 7 lakhs");
            }
        }
        else {
            System.out.println("not eligible for loan");
        }
    }
}
