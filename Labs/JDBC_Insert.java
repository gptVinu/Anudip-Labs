package programs;

import java.sql.*;

public class JDBC_Program {

	public static void main(String[] args) {
		
		//credentials...
		String url = "jdbc:mysql://localhost:3306/jdbc_data";
		String user = "root";
		String password = "Vinu@8898";
		
		//Query
		String sql_query = "Insert into mydata(id,name,age,contact,email) values(?,?,?,?,?)";
		
		try {
			//Register driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//creating the connection string
			Connection conn = DriverManager.getConnection(url,user,password);
			
			//creating the prepare statement
			PreparedStatement pstmt = conn.prepareStatement(sql_query);
			
			//adding the data
			pstmt.setInt(1, 101);
			pstmt.setString(2, "Samson");
			pstmt.setInt(3, 30);
			pstmt.setString(4, "7786543678");
			pstmt.setString(5, "sam@outlook.com");
			
			int insertedRow = pstmt.executeUpdate();
			
			if (insertedRow > 0) {
			    System.out.println("Query Executed successfully.");
			} else {
			    System.out.println("Error! Record not inserted.");
			}
			
			//another method - batch execute
			Object[][] data = {
	                {102, "Alice", 25, "9876543210", "alice@gmail.com"},
	                {103, "Bob", 28, "8876543211", "bob@yahoo.com"},
	                {104, "Charlie", 22, "7765432122", "charlie@outlook.com"},
	                {105, "Diana", 31, "6654321333", "diana@company.com"},
	                {106, "Ethan", 27, "5543214444", "ethan@webmail.com"}
	            };

	            for (Object[] row : data) {
	                pstmt.setInt(1, (int) row[0]);
	                pstmt.setString(2, (String) row[1]);
	                pstmt.setInt(3, (int) row[2]);
	                pstmt.setString(4, (String) row[3]);
	                pstmt.setString(5, (String) row[4]);
	                
	                pstmt.addBatch(); // Add to the batch
	            }
	         // Execute all 5 at once
	            int[] results = pstmt.executeBatch();
	            
	            System.out.println(results.length + " rows inserted successfully!");
			
	        //close the connection
			pstmt.close();
			conn.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}

// Output
/*
Query Executed successfully.
5 rows inserted successfully!

mysql> select * from mydata;
+-----+---------+-----+------------+---------------------+
| id  | name    | age | contact    | email               |
+-----+---------+-----+------------+---------------------+
| 101 | Samson  |  30 | 7786543678 | sam@outlook.com     |
| 102 | Alice   |  25 | 9876543210 | alice@gmail.com     |
| 103 | Bob     |  28 | 8876543211 | bob@yahoo.com       |
| 104 | Charlie |  22 | 7765432122 | charlie@outlook.com |
| 105 | Diana   |  31 | 6654321333 | diana@company.com   |
| 106 | Ethan   |  27 | 5543214444 | ethan@webmail.com   |
+-----+---------+-----+------------+---------------------+
6 rows in set (0.00 sec)
*/