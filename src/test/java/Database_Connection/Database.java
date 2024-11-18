package Database_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Database {
	
	@Test
	public void run() throws SQLException
	{
		 String dbURL = "jdbc:mysql://localhost:3306/users";
	        String username = "root";
	        String password = "admin";
		
		Connection conn = DriverManager.getConnection(dbURL, username, password);
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("Select * from password where usename ='vijay'");
		
		while(rs.next()) {
			String useName = rs.getString("usename");
			String Password =  rs.getString("password");
			System.out.println(useName);
			System.out.println(Password);
		}
		
		
		
	        
	  
	}

}
