import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int[] ar = new int[5];
  System.out.println("enter a number");
  int number = sc.nextInt();
  System.out.println("enter 5 numbers");
  for(int i=0; i<5;i++)
  {
      ar[i]= sc.nextInt();
  }
  demonstrate(number , ar);

        System.out.println(" number after coming out of method :" +number);
        System.out.println(" array after coming out of method :");
        for(int i=0; i<5;i++)
        {
            System.out.println(ar[i]);
        }

    }

    public  static void demonstrate(int number , int[] ar)
    {
        number += 20;
        for(int i=0; i<5;i++)
        {
            ar[i]= i+10;
        }



    }
}