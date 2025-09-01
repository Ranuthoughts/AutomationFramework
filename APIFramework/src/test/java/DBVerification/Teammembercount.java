package DBVerification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Resources.DBUtils;

public class Teammembercount extends DBUtils {
	
	public static int getTeammembercountbystatus(String status, String EnterpriseId) throws SQLException {
		
		String query = "SELECT COUNT(*) FROM TeamMember WHERE status = ? and EnterpriseId = ?";
		 try (Connection conn = getdbconnection(); 
				 PreparedStatement ps = conn.prepareStatement(query)) {
	            ps.setString(1, status);
	            ps.setString(2, EnterpriseId);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    return rs.getInt(1);
	                }
	            }
	        }
	        return 0;
	    }
	}


