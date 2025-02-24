import java.util.Arrays;

public class task3 extends Thread{

    int[] arr;

    task3(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        Arrays.sort(arr);
    }
}
class MultiThreadSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 3, 8, 2, 7, 6, 1};

        task3 t1 = new task3(arr);
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
