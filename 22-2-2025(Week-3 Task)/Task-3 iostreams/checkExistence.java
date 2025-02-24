import java.io.File;

public class checkExistence {
    public static void main(String[] args) {
        File file = new File("D:\\intelij programs\\file");
        System.out.println(file.exists() ? "Exists" : "Does not exist");
    }
}
