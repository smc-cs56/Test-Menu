 import java.sql.*;

 public class SimpleJdbc {
 public static void main(String[] args)
 throws SQLException, ClassNotFoundException {
 // Load the JDBC driver
 Class.forName("com.mysql.jdbc.Driver");
 System.out.println("Driver loaded");
    Statement stmt = null;

 // Connect to a database
 Connection connection = DriverManager.getConnection
 
 
 ("jdbc:mysql://76.90.217.50/test", "mohan", "password");
 System.out.println("Database connected");

 // Create a statement
 Statement statement = connection.createStatement();

 // Execute a statement
 ResultSet resultSet = statement.executeQuery
 ("Select * from Game3;");
 //("select firstName, mi, lastName from Student where lastName "
 //+ " = 'Smith'");
 //string fname=daniel,lname=wijedasa,date=216-05-31;
	//	String sql = "INSERT INTO game (fnane,lname,date)"+"VALUES('"+fname+"','"+lname+"','"date"');"
		//stmt.executeUpdate(sql);

 // Iterate through the result and print each column add resultSet.getString (with next column number as needed)
 while (resultSet.next())
 System.out.println(resultSet.getString(1) + "\t" +
 resultSet.getString(2) + "\t" + resultSet.getString(3)+ "\t");

 // Close the connection
 connection.close();
 }
 }