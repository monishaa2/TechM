public class ThreadRunnableTwo implements Runnable {

    @Override
    public void run() {
        System.out.println("From ThreadRunnableTwo!");
        System.out.println("From ThreadRunnableTwo!");
        System.out.println("From ThreadRunnableTwo!");
    }

    public static void main(String[] args) {
        ThreadRunnableTwo task = new ThreadRunnableTwo();

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}

