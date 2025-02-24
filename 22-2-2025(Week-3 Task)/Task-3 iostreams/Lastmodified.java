import java.io.File;

public class Lastmodified {
    public static void main(String[] args) {
        File file = new File("D:\\intelij programs\\file");
        System.out.println("Last Modified: " + file.lastModified());
    }
}
