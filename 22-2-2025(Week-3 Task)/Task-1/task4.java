import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int [] arr1 = {1,2,3,4,5,6,7,8,9,10};
        int [] arr2 = Arrays.copyOfRange(arr1 , 2 , 8);
        System.out.println("original array" + Arrays.toString(arr1));
        System.out.println("copied array" + Arrays.toString(arr2));


    }
}