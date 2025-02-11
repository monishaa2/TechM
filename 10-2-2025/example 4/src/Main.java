import java.io.File;
import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Press 1 to Create a file without creating a folder");
        System.out.println("Press 2 to create 3 files by creating a folder");
        System.out.println("Press 3 to create 4 files by creating a folder");

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch (a) {
            case 1: {
                File f1 = new File("D:\\intelij programs\\10-2-2025\\file1.txt");
                try {
                    f1.createNewFile();

                } catch (Exception ignored) {
                }
                break;
            }

            case 2: {
                File folder = new File("D:\\intelij programs\\10-2-2025\\newfolder");
                folder.mkdir();
                File f2 = new File(folder, "file2");
                File f3 = new File(folder, "file3");
                File f4 = new File(folder, "file4 ");

                try {

                    f2.createNewFile();
                    f3.createNewFile();
                    f4.createNewFile();
                } catch (Exception ignored) {
                }
                break;


            }
            case 3: {
                File newfolder = new File("D:\\intelij programs\\10-2-2025\\newfolder1");
                newfolder.mkdir();
                File f2 = new File(newfolder, "file2");
                File f3 = new File(newfolder, "file3");
                File f4 = new File(newfolder, "file4 ");
                File f5 = new File(newfolder, "file4 ");


                try {

                    f2.createNewFile();
                    f3.createNewFile();
                    f4.createNewFile();
                    f5.createNewFile();
                } catch (Exception ignored) {
                }
                break;
            }
            default: System.out.println("inavalid number entered");


        }

System.out.println("created succesfully");
    }
}