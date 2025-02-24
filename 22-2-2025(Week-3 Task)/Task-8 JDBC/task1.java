//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class  task1{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
                 String url = "jdbc:mysql://localhost:3306/student";
                      String user = "root";
                      String password = "Monii@24";
                      Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement ps = conn.prepareStatement("INSERT INTO student_details (student_id, student_name, student_age) VALUES (?, ?, ?)");
        {
                    Scanner sc = new Scanner(System.in);
                    while (true) {
                        System.out.println("Enter ID, Name, Age (or -1 to stop)");
                        int id = sc.nextInt();
                        if (id == -1) break;
                        String name = sc.next();
                        int age = sc.nextInt();
                        ps.setInt(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, age);
                        ps.executeUpdate();
                    }
                }
                }
            }


