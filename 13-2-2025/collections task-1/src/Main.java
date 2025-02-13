import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Arraythread a = new Arraythread();
        Linkedthread l = new Linkedthread();
        Stackthread s = new Stackthread();
        Vectorthread v = new Vectorthread();

        System.out.println("ArrayThread is Running");
        a.run();
        System.out.println("LinkedThread is Running");
        l.run();
        System.out.println("StackThread is Running");
        s.run();
        System.out.println("VectorThread is Running");
        v.run();



    }


}
