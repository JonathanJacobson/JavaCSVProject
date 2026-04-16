import java.sql.*;

public class AddValuesToDB {
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

            // 3. Insert 6 new records
            String insert1 = "INSERT INTO student (name, course, mark) VALUES ('John Smith', 'Java', 75)";
            String insert2 = "INSERT INTO student (name, course, mark) VALUES ('Sarah Jones', 'Python', 82)";
            String insert3 = "INSERT INTO student (name, course, mark) VALUES ('Michael Brown', 'Database Systems', 68)";
            String insert4 = "INSERT INTO student (name, course, mark) VALUES ('Emily Davis', 'Web Development', 90)";
            String insert5 = "INSERT INTO student (name, course, mark) VALUES ('David Wilson', 'Cyber Security', 77)";
            String insert6 = "INSERT INTO student (name, course, mark) VALUES ('Lisa Taylor', 'Data Science', 85)";

            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);
            stmt.executeUpdate(insert3);
            stmt.executeUpdate(insert4);
            stmt.executeUpdate(insert5);
            stmt.executeUpdate(insert6);

            System.out.println("✅ 6 records inserted successfully!");

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