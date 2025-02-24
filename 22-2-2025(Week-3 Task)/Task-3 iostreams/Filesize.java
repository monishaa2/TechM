import java.io.File;

public class Filesize {
    public static void main(String[] args) {
        File file = new File("D:\\intelij programs\\file");
        if (file.exists() && file.isFile()) {
            long bytes = file.length();
            System.out.println("Size: " + bytes + " bytes, " + (bytes / 1024) + " KB, " + (bytes / (1024 * 1024)) + " MB");
        }
    }
}
