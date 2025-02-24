import java.io.File;

public class task5 {
    public static void main(String[] args) {
        File file = new File("D:\\intelij programs\\file\\example.txt.txt");
        if (file.length() == 0) {
            System.out.println("File is empty");
        } else {
            System.out.println("File is not empty");
        }
    }
}
