import java.io.File;

public class Permissions {
    public static void main(String[] args) {
        File file = new File("D:\\intelij programs\\file");
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
    }
}
