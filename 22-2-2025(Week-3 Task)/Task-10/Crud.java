//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.*;
import java.util.Scanner;

public class Crud {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "Monii@24";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n--- STUDENT DATABASE MANAGEMENT ---");
                System.out.println("1. Insert a new Row");
                System.out.println("2. Update a Row");
                System.out.println("3. Delete a Row");
                System.out.println("4. Select (View) Rows");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        insertStudent(conn, sc);
                        break;
                    case 2:
                        updateStudent(conn, sc);
                        break;
                    case 3:
                        deleteStudent(conn, sc);
                        break;
                    case 4:
                        viewTable(conn);
                        break;
                    case 5:
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewTable(Connection conn) {
        String query = "SELECT * FROM student_details";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                int age = rs.getInt("student_age");
                System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertStudent(Connection conn, Scanner sc) {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Student Name: ");
        String name = sc.next();
        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        String query = "INSERT INTO student_details (student_id, student_name, student_age) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted > 0 ? "Student inserted successfully!" : "Insert failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(Connection conn, Scanner sc) {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        System.out.print("Enter New Student Name: ");
        String name = sc.next();

        String query = "UPDATE student_details SET student_name = ? WHERE student_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println(rowsUpdated > 0 ? "Student updated successfully!" : "No student found with the given ID.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(Connection conn, Scanner sc) {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM student_details WHERE student_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted > 0 ? "Student deleted successfully!" : "No student found with the given ID.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
