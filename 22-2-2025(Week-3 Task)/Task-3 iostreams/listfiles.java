import java.io.File;

class listfiles {
    public static void main(String[] args) {
        File dir = new File("D:\\intelij programs\\file");
        if (dir.exists() && dir.isDirectory()) {
            String[] files = dir.list();
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}