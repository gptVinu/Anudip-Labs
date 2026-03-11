package programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateQueryJDBC {

	public static void main(String[] args) {
		
		// credentials
		String url = "jdbc:mysql://localhost:3306/jdbc_data";
		String user = "root";
		String password = "Vinu@8898";
		
		String sql = "Update students set email= ? where id = ?";
		
		// 1. Register driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //forName : used to register the driver
			
			//2. create a driver connection
			Connection conn = null;
			conn = DriverManager.getConnection(url, user, password);
			
			//updating data to the database using the driver
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"Vinayak@outlook.com");
			pstmt.setInt(2, 8);
			
			int rowInserted = pstmt.executeUpdate();
			
			if (rowInserted > 0) {
				System.out.println("Data updated Successfully.");
			} else {
				System.out.println("Error ! Query not executed.");
			}
		
			//close the connection
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
