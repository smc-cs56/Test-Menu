public class Member {
	String FirstName;
	String LastName;
	String Date;
	
	public Member(String szFirstName, String szLastName, String szDate)
	{
		this.FirstName = szFirstName;
		this.LastName = szLastName;
		this.Date = szDate;
	}
	
	public void setFirstName(String szFirstName)
	{
		this.FirstName = szFirstName;
	}
	
	public void setLastName(String szLastName)
	{
		this.LastName = szLastName;
	}
	
	public void setDate(String szDate)
	{
		this.Date = szDate;
	}
}