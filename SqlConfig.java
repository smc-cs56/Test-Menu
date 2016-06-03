public class SqlConfig
{
	final static String Hostname = "jdbc:mysql://76.90.217.50/test";
	final static String Username = "mohan";
	final static String Password = "password";
	
	public SqlConfig()
	{
		
	}
	
	public static String getHostname()
	{
		return Hostname;
	}
	
	public static String getUsername()
	{
		return Username;
	}
	
	public static String getPassword()
	{
		return Password;
	}
} 