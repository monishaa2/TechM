//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Objects;
public class Main {
    public static void main(String[] args) {

        System.out.println("Demonstration of equals and deep equals method");
        String a = "hello user";
        String b = "hello user";

        String[] arr1 = {"java" , "python" , "c++"};
        String[] arr2 = {"java" , "python" , "c++"};

        System.out.println("equals method");
        System.out.println(a.equals(b));
        System.out.println(arr1.equals(arr2));

        System.out.println("deep equals method");

        System.out.println(Objects.deepEquals(a,b));
        System.out.println(Objects.deepEquals(arr1,arr2));







    }
}