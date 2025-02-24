import java.sql.*;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "Monii@24";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner sc = new Scanner(System.in)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Enter Student ID to delete:");
            int id = sc.nextInt();

            String query = "DELETE FROM student_details WHERE student_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, id);
                int rowsDeleted = ps.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Student record deleted successfully.");
                } else {
                    System.out.println("No student found with ID " + id);
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

