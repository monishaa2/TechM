import java.sql.*;
import java.util.Scanner;

public class task2 {


        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/student";
            String user = "root";
            String password = "Monii@24";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Scanner sc = new Scanner(System.in)) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                System.out.println("Enter Student ID to update:");
                int id = sc.nextInt();

                System.out.println("Enter new Name:");
                String name = sc.next();

                System.out.println("Enter new Age:");
                int age = sc.nextInt();

                String query = "UPDATE student_details SET student_name = ?, student_age = ? WHERE student_id = ?";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setString(1, name);
                    ps.setInt(2, age);
                    ps.setInt(3, id);
                    int rowsUpdated = ps.executeUpdate();

                    if (rowsUpdated > 0) {
                        System.out.println("Student record updated successfully.");
                    } else {
                        System.out.println("No student found with ID " + id);
                    }
                }

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }


