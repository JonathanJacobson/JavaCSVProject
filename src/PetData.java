import java.sql.*;


public class PetData {
    // Database connection details
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/petstore";
    //private static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/school";
    private static final String USER = "ethan"; // e.g., "root"
    private static final String PASSWORD = "ethan"; // The password you set for the MySQL user

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. Establish the connection
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("✅ Database connection established successfully!");

            // 2. Create a statement
            stmt = conn.createStatement();

            // 3. Execute a query
            String selectQuery = "SELECT * FROM store"; // Replace 'users' with your table name
            rs = stmt.executeQuery(selectQuery);

            // 4. Process the results
            System.out.println("\n📋 Students in Database:");
            while (rs.next()) {
                // Adjust column names and types based on your table schema

                int id = rs.getInt("id");
                String classification = rs.getString("classification");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String mobile = rs.getString("mobile");

                System.out.println("ID: " + id + ", Classification: " + classification + ", Name: " + name + ", Age: " + age + ", Mobile: " + mobile);

            }

        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL JDBC driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("❌ SQL Errors: " + e.getMessage());
        } finally {
            // 5. Close the resources in the finally block to ensure they are always closed
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("\nConnection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

