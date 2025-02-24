import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadfiletoBytearray {
    public static void main(String[] args) throws IOException {
        byte[] data = Files.readAllBytes(Paths.get("D:\\intelij programs\\file"));
        System.out.println(new String(data));
    }
}
