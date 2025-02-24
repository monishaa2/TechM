import java.io.File;
import java.io.FileNotFoundException;

public class task3 {
    public static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found");
        }
        System.out.println("File exists and can be read");
    }
    public static void main(String[] args) {
        try {
            readFile("D:\\intelij programs\\file2");
        } catch (FileNotFoundException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
