public class ThreadRunnableOne implements Runnable{

    public static void main(String[] args)
    {
        ThreadRunnableOne t = new ThreadRunnableOne();
        Thread t1 = new Thread(t);
        t1.start();

    }



    public void run()
    {
        System.out.println("from ThreadRunnableOne");
        System.out.println("from ThreadRunnableOne");
    }

}
