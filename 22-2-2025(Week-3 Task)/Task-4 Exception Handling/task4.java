import java.io.*;

class PositiveNumberException extends Exception {
    public PositiveNumberException(String message) {
        super(message);
    }
}

 class Task4 {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\intelij programs\\file");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("-")) {
                    throw new PositiveNumberException("Positive number found: " + line);
                }
            }
            br.close();
            System.out.println("All numbers are non-positive.");
        } catch (PositiveNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
