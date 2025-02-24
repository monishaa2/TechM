import java.io.File;

public class Specificfile {
    public static void main(String[] args) {
        File dir = new File("D:\\intelij programs\\file");
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}
