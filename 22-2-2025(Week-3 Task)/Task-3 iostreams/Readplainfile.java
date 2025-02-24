import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Readplainfile
{


        public static void main(String[] args) throws IOException {
            Files.lines(Paths.get("D:\\intelij programs\\file")).forEach(System.out::println);
        }
}

