import javax.swing.JOptionPane;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.preparedStatement;

public class Insert {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://76.90.217.50/test";

   //  Database credentials
   static final String USER = "mohan";
   static final String PASS = "password";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
	  //enter the form code here 
	//  String id = JOptionPane.showInputDialog("Please Enter Numeric id");
	  String fname = JOptionPane.showInputDialog("Please Enter First name");
	  String lname = JOptionPane.showInputDialog("Please Enter Last name");
	 String date = JOptionPane.showInputDialog("Please Enter date example 06-01-2016");
	  

	 stmt = conn.createStatement();
	 String sql = "INSERT INTO Game3 (fname, lname, date) VALUES('"+fname+"','"+lname+"','"+date+"')"; 
    
	stmt.executeUpdate(sql);
	 
	  
      
      System.out.println("Inserted records into the table...");
	  
	  

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample