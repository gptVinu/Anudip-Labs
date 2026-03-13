package programs;

import java.sql.*;

public class JDBC_Select {

    public static void main(String[] args) {
        // Credentials...
        String url = "jdbc:mysql://localhost:3306/jdbc_data";
        String user = "root";
        String password = "Vinu@8898";
                
        // Query to select all data
        String sql_query = "SELECT * FROM mydata";
                
        try {
            // Register driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
                    
            // Creating the connection string
            Connection conn = DriverManager.getConnection(url, user, password);
                    
            // Creating the statement
            Statement stmt = conn.createStatement();
            
            // Executing the query and getting the result set
            ResultSet rst = stmt.executeQuery(sql_query);
            
            // Printing a simple header for the output
            System.out.println("ID\tName\t\tAge\tContact\t\tEmail");
            System.out.println("------------------------------------------------------------");
            
            // The completed while loop to iterate through all rows
            while (rst.next()) {
                // Extracting values from the current row
                int id = rst.getInt("id");
                String name = rst.getString("name");
                int age = rst.getInt("age");
                String contact = rst.getString("contact");
                String email = rst.getString("email");
                
                // Printing the data
                System.out.println(id + "\t" + name + "\t\t" + age + "\t" + contact + "\t" + email);
            }
            
            // Closing resources (good practice to close them in reverse order)
            rst.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("An error occurred while fetching data.");
            e.printStackTrace();
        } 
    }
}

//Output
/*
ID	Name		Age	Contact		Email
------------------------------------------------------------
101	Samson		30	7786543678	sam@outlook.com
102	Alice		25	9876543210	alice@gmail.com
103	Bob		28	8876543211	bob@yahoo.com
104	Charlie		22	7765432122	charlie@outlook.com
105	Diana		31	6654321333	diana@company.com
106	Ethan		27	5543214444	ethan@webmail.com
*/