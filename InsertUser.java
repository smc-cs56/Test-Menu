import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Date;
import java.text.*;

public class InsertUser {
   
   public InsertUser()
   {
	   
   }
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{

	Class.forName("com.mysql.jdbc.Driver");

	conn = DriverManager.getConnection(SqlConfig.getHostname(), SqlConfig.getUsername(), SqlConfig.getPassword());
	
	boolean bCheckFirstName = false;
	String fname = "";
	while (!bCheckFirstName)
	{
		fname = JOptionPane.showInputDialog("Please Enter First name");
		if (!fname.isEmpty())
		{
			bCheckFirstName = true;
		}
	}
	
	String lname = JOptionPane.showInputDialog("Please Enter Last name");

	Date dNow = new Date( );
	SimpleDateFormat sdFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

	String date = sdFormat.format(dNow);

	stmt = conn.createStatement();
	String sql = "INSERT INTO Game3 (fname, lname, date) VALUES('"+fname+"','"+lname+"','"+date+"')"; 

	stmt.executeUpdate(sql);

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
}//end main
}//end JDBCExample