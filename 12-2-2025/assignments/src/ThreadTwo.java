public class ThreadTwo extends Thread {


        public static void main(String[] args) {
            ThreadTwo t =  new ThreadTwo();
            Thread t1 = new Thread();


            t.start();
            t1.run();


        }
        public void run()
        {
            System.out.println("from thread two");
            System.out.println("from thread two");
            System.out.println(10/0);
        }
    }

