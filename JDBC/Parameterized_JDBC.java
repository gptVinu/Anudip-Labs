package programs;

import java.sql.*;

public class Parameterized_JDBC {
	public static void main(String args[]) {
		
		//credentials
		String url = "jdbc:mysql://localhost:3306/jdbc_data";
		String user = "root";
		String password = "Vinu@8898";
		
		//Query
		String query = "Select * from students;";
		
		try {
			// 1. Register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create a connection
			Connection conn = DriverManager.getConnection(url, user, password); 
			
			//create statement
			Statement stmt = conn.createStatement();
			
			//execute the statement
			ResultSet rst = stmt.executeQuery(query);
			
			while (rst.next()){
				System.out.println(rst.getString("name"));
			}
			
			//close the connection
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error !!!");
		}
	}
}
