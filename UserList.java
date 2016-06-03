import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class UserList extends JFrame
{
	public UserList() throws SQLException, ClassNotFoundException
	{
		setWindow();
		retrieveUserList();
	}

	private void setWindow()
	{
		this.setSize(600, 500);
       	this.setVisible(true);
        this.setLayout(new BorderLayout());
	}

	private void retrieveUserList() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(SqlConfig.getHostname(), SqlConfig.getUsername(), SqlConfig.getPassword());
		Statement statement = connection.createStatement();		

		String szSQL = "SELECT * FROM Game3 WHERE fname is not null ORDER BY score, duration ASC LIMIT 0, 25;";

		ResultSet resultSet = statement.executeQuery(szSQL);
		
		List<String[]> values = new ArrayList<String[]>();
		int nNumber = 1;
		while (resultSet.next())
		{
			values.add(new String[] { Integer.toString(nNumber), resultSet.getString("score"), resultSet.getString("duration") + " seconds", resultSet.getString("fname"), resultSet.getString("lname"), resultSet.getString("date") } );
			nNumber++;
		}
		connection.close();
		
		List<String> columns = new ArrayList<String>();
		columns.add("#");
		columns.add("Score");
		columns.add("Duration");
		columns.add("First Name");
        columns.add("Last Name");
        columns.add("Date");
		
		TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
        JTable table = new JTable(tableModel);

        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(table.getTableHeader(), BorderLayout.NORTH);
	}
}
