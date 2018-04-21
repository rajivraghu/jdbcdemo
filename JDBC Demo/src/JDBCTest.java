import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	
	
	public static void main(String[] args) {
		  Connection connection = null;

	        try {

	            connection = DriverManager.getConnection(
	                    "jdbc:oracle:thin:@localhost:1521:ORCL", "orderapp", "orderapp");

	        } catch (SQLException e) {

	            System.out.println("Connection Failed! Check output console");
	            e.printStackTrace();
	            return;

	        }

	        if (connection != null) {
	            System.out.println("You made it, take control your database now!");
	            try {
					PreparedStatement prepareStatement = connection.prepareStatement("insert into EMPLOYEE values (?,?,?) ");
					prepareStatement.setInt(1, 9591);
					prepareStatement.setString(2, "Raghu");
					prepareStatement.setInt(3, 5);
				    int count=prepareStatement.executeUpdate();
				    connection.commit();
				  //  connection.close();
				    
				    Statement createStatement = connection.createStatement();
				    ResultSet executeQuery = createStatement.executeQuery("select * from employee");
				    while (executeQuery.next()) {
					
				    	System.out.println("id:"+executeQuery.getInt(1));
				    	System.out.println("name:"+executeQuery.getString(2));
				    	System.out.println("dept:"+executeQuery.getInt(3));
					}
				    
				    connection.close();
				
				} catch (SQLException e) {

					e.printStackTrace();
				}
	        }
	    }
	}

