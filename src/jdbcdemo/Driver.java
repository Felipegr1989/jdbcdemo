package jdbcdemo;

import java.sql.*;

public class Driver {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/Demo?verifyServerCertificate=false&useSSL=true";
		String user = "root";
		String password = "";

		try {
			// 1. get a connection to database
			Connection myConn = DriverManager.getConnection(url, user, password);

			// 2. create a statement
			Statement myStmt = myConn.createStatement();
			// 3. execute SQL query
			String mySql = "update employee " + " set email = 'demo@gmail.com'" + " where id = 1";
			myStmt.executeUpdate(mySql);
			
				System.out.println("update complete. ");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
