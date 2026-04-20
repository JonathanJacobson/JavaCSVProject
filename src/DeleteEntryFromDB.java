import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEntryFromDB {

    // Database connection details
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/school";
    //private static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/school";
    private static final String USER = "ethan";
    private static final String PASSWORD = "ethan";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. Establish the connection
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("✅ Database connection established successfully!");

            // 2. Create a statement
            stmt = conn.createStatement();

            // 3. DELETE record (example: delete by name)
            String deleteQuery = "DELETE FROM student WHERE name='Lisa Taylor'";

            int rowsAffected = stmt.executeUpdate(deleteQuery);

            System.out.println("✅ " + rowsAffected + " record(s) deleted successfully!");

        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL JDBC driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("❌ SQL Errors: " + e.getMessage());
        } finally {
            // 4. Close resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("\nConnection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}