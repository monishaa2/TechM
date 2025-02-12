//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ThreadOne extends Thread{
    public static void main(String[] args) {
       ThreadOne t =  new ThreadOne();
       t.start();
    }
    public void run()
    {
        System.out.println("from thread one");
        System.out.println("from thread one");
        System.out.println("from thread one");
    }
}