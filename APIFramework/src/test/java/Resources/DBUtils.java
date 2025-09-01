package Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	
	public static Connection getdbconnection() throws SQLException {
		
		String 	url = "jdbc:mysql://13.232.150.129/ecms_workspace";
		String user = "ranu";
        String password = "30SmoiMcw5bd7zZN";
        System.out.println("connection done");
        return DriverManager.getConnection(url, user, password);
        
        
    }
	
	
	
	
	
	}


