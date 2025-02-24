import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 1 to print odd numbers, enter2 to print even numbers");
        int n= sc.nextInt();
        if(n==1)
        {
            odd o =new odd();
            o.start();
        }

        if(n==2)
        {
            even e =new even();
            e.start();
        }


    }
}

class odd extends Thread{
    public void run()
    {
        for(int i =0;i<=20 ;i++)
        {
            if (i%2 !=0)
            {
                System.out.println(i);
            }
        }
    }
}

class even extends Thread{
    public void run()
    {
        for(int i =0;i<=20 ;i++)
        {
            if (i%2 ==0)
            {
                System.out.println(i);
            }
        }
    }
}