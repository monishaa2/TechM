public class task1 extends Thread{
    public static void main(String[] args) {
        task1 t = new task1();
        t.start();

    }

    public void run()
    {
        System.out.println("Hello Java");
    }
}
