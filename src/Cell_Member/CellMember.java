package Cell_Member;


import java.sql.*;
public class CellMember 
{
	private String id;
	private String name;
	private String password;
	private String EmailId;
	private String ContactNumber;
	private String category;
	private String gender;
	private String year;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmailId() {
		return EmailId;
	}


	public void setEmailId(String emailId) {
		EmailId = emailId;
	}


	public String getContactNumber() {
		return ContactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.ContactNumber = contactNumber;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBatch() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public void showDetails(String c1id)
	{
		
		try
		{
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc","root","lnm@#$");
			
			Statement stmt= con.createStatement();
			ResultSet res= stmt.executeQuery("select * from CellMember");
			while(res.next())
			{
				if(res.getString("cid").equals(c1id))
				{
					id=res.getString("cid");
					name=res.getString("cname");
					password=res.getString("cpassword");
					EmailId=res.getString("cEmailId");
					ContactNumber =res.getString("ContactNumber");
					category=res.getString("category");
					gender=res.getString("gender");
					year=res.getString("year");
				}	
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void changeStatus(String company,String sid)
	 {try
	 {
		 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject", "tpc");
		 Statement stmt=con.createStatement();
		 String sql="select * from Company where cname='"+company+ "'";
		 int cid;
		 double slry=0;
		 ResultSet res=stmt.executeQuery(sql);
		 while(res.next())
		 {
			 cid=res.getInt("cIN");
			 slry=res.getDouble("salary");
		 }
		 Statement stmt1=con.createStatement();
		 Statement stmt2=con.createStatement();
		 Statement stmt3=con.createStatement();
		 String sql1="update Student set placementStatus=1 where sid='"+sid+ "'";
		 stmt1.executeUpdate(sql1);
		 String sql2="update Student set salary='"+slry+ "' where sid='"+sid+ "'";
		 stmt2.executeUpdate(sql2);
		 String sql3="update Student set placedCompany='"+company+ "' where sid='"+sid+ "'";
		 stmt3.executeUpdate(sql3);
	 }
	 catch(SQLException ex)
	 {
		 ex.printStackTrace();
	 }
	 }
}
	