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
			String mySql = "insert into employee" + "(last_name, first_name, email)"
					+ "values ('guerrero', 'luisa', 'luisa.guerrero@gmail.com')";
			myStmt.executeUpdate(mySql);
			
				System.out.println("insert complete. ");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
