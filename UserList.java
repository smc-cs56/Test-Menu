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
		UserList testJFrame = new UserList();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://76.90.217.50/test", "mohan", "password");
		Statement statement = connection.createStatement();

		String szSQL = "SELECT * FROM Game3 WHERE fname is not null ORDER BY date DESC;";
		ResultSet resultSet = statement.executeQuery(szSQL);
		
		List<String[]> values = new ArrayList<String[]>();
		while (resultSet.next())
		{
			values.add(new String[] { resultSet.getString("fname"), resultSet.getString("lname"), resultSet.getString("date") } );
		}
		connection.close();
		
		List<String> columns = new ArrayList<String>();
		columns.add("First Name");
        columns.add("Last Name");
        columns.add("Date");
		
		TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
        JTable table = new JTable(tableModel);
        testJFrame.setLayout(new BorderLayout());
        testJFrame.add(new JScrollPane(table), BorderLayout.CENTER);

        testJFrame.add(table.getTableHeader(), BorderLayout.NORTH);

        testJFrame.setVisible(true);
        testJFrame.setSize(300,500);
	}
}