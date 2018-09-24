package jdbcdemo;

import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		try {
			//1.  get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo?verifyServerCertificate=false&useSSL=true","root" ,"");
			
			//2. create a statement
			Statement myStmt = myConn.createStatement();
			//3. execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from employee");
			//4. process the result set
			while(myRs.next()) {
				System.out.println(myRs.getString("last_name") + " , " + myRs.getString("first_name"));
			}
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
