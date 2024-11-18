package Database_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Database_SelectAll {
	
	@Test
	public void run() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/Demo";
        String username = "root";
        String password = "admin";
	
        	Connection conn = DriverManager.getConnection(dbURL, username, password);
        	Statement st = conn.createStatement();
        	ResultSet rs = st.executeQuery("select * from Employeeinfo");
        	while(rs.next()){
        		String userName = rs.getString("name");
        		String userId =  rs.getString("id");
        		String location = rs.getString("location");
        		String age = rs.getString("age");
        		System.out.println(userName);
        		System.out.println(userId);
        		System.out.println(location);
        		System.out.println(age);
        	}
        	
	}

}
