import java.sql.*;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "Monii@24";
        Connection conn = DriverManager.getConnection(url, user, password);
        Scanner sc = new Scanner(System.in);

        System.out.println("In this application, you can view, insert, update, or delete student records.");
        System.out.println("1. VIEW THE TABLE");
        System.out.println("2. UPDATE THE TABLE");
        int num = sc.nextInt();

        switch (num) {
            case 1:
                viewTable(conn);
                break;
            case 2:
                System.out.println("Enter action (insert/update/delete): ");
                String action = sc.next();
                switch (action) {
                    case "insert":
                        insertStudent(conn);
                        break;
                    case "update":
                        updateStudent(conn);
                        break;
                    case "delete":
                        deleteStudent(conn);
                        break;
                    default:
                        System.out.println("Invalid input.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
        sc.close();
        conn.close();
    }

    public static void viewTable(Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student_details");

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                int age = rs.getInt("student_age");
                System.out.println("ID: " + id + " | NAME: " + name + " | AGE: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void insertStudent(Connection conn) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Student Name: ");
        String name = scanner.next();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();

        String sql = "INSERT INTO student_details (student_id, student_name, student_age) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(Connection conn) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter New Student Name: ");
        String name = scanner.next();

        String sql = "UPDATE student_details SET student_name = ? WHERE student_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("No student found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(Connection conn) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM student_details WHERE student_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student with ID " + id + " has been deleted successfully!");
            } else {
                System.out.println("No student found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
