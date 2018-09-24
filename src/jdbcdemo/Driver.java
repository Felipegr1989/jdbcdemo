package jdbcdemo;

import java.awt.DisplayMode;
import java.sql.*;

public class Driver {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		String url = "jdbc:mysql://localhost:3306/Demo?verifyServerCertificate=false&useSSL=true";
		String user = "root";
		String password = "";

		try {
			// 1. get a connection to database
			myConn = DriverManager.getConnection(url, user, password);

			// 2. prepare a statement
			myStmt = myConn.prepareStatement("select * from employees where salary > ? and department = ?");
			
			//3. set the parameters
			myStmt.setDouble(1, 40000);
			myStmt.setString(2, "legal");
			
			//4. execute SQL query
			myRs = myStmt.executeQuery();
			
			//5. Display the result set
			display(myRs);
			
			/*
			 * Reuse the prepared statement: salary > 25000, department = HR
			 * 
			 */
			
		System.out.println("\n\nReuse the prepared statement: salary > 25000, department = hr");	
			//6. set the parameters
			myStmt.setDouble(1, 25000);
			myStmt.setString(2, "hr");
			
			//7. execute SQL query
			myRs = myStmt.executeQuery();
			
			//8. Display the result set
			display(myRs);
			
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}
	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");
			
			System.out.printf("%s, %s, %.2f, %s\n", lastName, firstName, salary, department);
		}
	}

}
