package dao;
import java.sql.*;

public class RegistrationDAO {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {

		RegistrationDAO db = new RegistrationDAO();

		//db.insertData("Eesa Malik", "eesa@hotmail.com", "5865523323", 1);

		db.selectData();
	}

	public void insertData(String name, String email, String phone, int age) {
		Connection conn = null;
		Statement stmt = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "insert into school.registration (name, email, phone, age) values ('"
					+ name
					+ "', '"
					+ email
					+ "', '"
					+ phone
					+ "', "
					+ age
					+ ")";

			stmt.execute(sql);

			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}

	public void selectData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql;
			sql = "SELECT * from school.registration";

			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");

				// Display values
				System.out.print("ID: " + id);
				System.out.print(", Name: " + name);
				System.out.print(", Age: " + age);
				System.out.print(", email: " + email);
				System.out.println(", phone: " + phone);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			RegistrationDAO.closeConnection(rs, stmt, conn);
		}// end try
		System.out.println("Goodbye!");
	}

	public static void closeConnection(ResultSet rs, Statement stmt,
			Connection conn) {
		// finally block used to close resources
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException se2) {
		}// nothing we can do
			// finally block used to close resources
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se2) {
		}// nothing we can do
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}// end finally try
	}
}
