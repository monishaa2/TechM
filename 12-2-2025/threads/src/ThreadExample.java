public class ThreadExample  {
    public static void main(String[] args)
    {
        Thread t = new Thread();
        //thread1 t1 = new thread1();
           t.run();
        //t1.start();
       // t1.run();

        System.out.println(10/0);



    }
}

class thread1 extends Thread{

    public void run()
    {
        System.out.println(10/0);
    }

}