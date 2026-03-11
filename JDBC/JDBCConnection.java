package programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) {
		
		// credentials
		String url = "jdbc:mysql://localhost:3306/jdbc_data";
		String user = "root";
		String password = "myPass";
		
		String sql = "Insert into students (name, email, age) values (?,?,?)";
		
		// 1. Register driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //forName : used to register the driver
			
			//2. create a driver connection
			Connection conn = null;
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. Create statement
			Statement stmt = conn.createStatement();
			
			// 4. execute the statement
			ResultSet rst = stmt.executeQuery("Select name,email,age from students;");
			
			//printing the data
			while (rst.next()) {
				System.out.println(rst.getString("name") + " : " + rst.getString("email") + " : " + rst.getInt("age"));
			}
			
			//adding a data to the database using the driver
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"Vinayak");
			pstmt.setString(2, "vinay@gmail.com");
			pstmt.setInt(3, 23);
			
			int rowInserted = pstmt.executeUpdate();
			
			if (rowInserted > 0) {
				System.out.println("Data inserted Successfully.");
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

