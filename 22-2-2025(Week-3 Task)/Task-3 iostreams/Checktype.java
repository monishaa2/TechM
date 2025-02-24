import java.io.File;

public class Checktype {
    public static void main(String[] args) {
        File file = new File("D:\\intelij programs\\file");
        if (file.exists()) {
            System.out.println(file.isDirectory() ? "Directory" : "File");
        } else {
            System.out.println("Does not exist");
        }
    }
}
