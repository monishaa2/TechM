public class ThreadThree extends Thread {
    public static void main(String[] args) {
        ThreadThree t =  new ThreadThree();
        Thread n1 = new Thread();
        Thread n2 = new Thread();
        Thread n3 = new Thread();


        t.start();
        n1.start();
        n2.start();
        n3.start();



    }
    public void run()
    {
        System.out.println("from thread three");
        System.out.println("from thread three");
        System.out.println("from thread three");
        System.out.println("from thread three");
        System.out.println("from thread three");


    }
}
