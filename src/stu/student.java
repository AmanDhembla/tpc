package stu;
import java.sql.*;
public class student {

	 public String sid;
	 public String sname;
	 public String spassword;
	 public String sEmailId;
	 public float cpi;
	 public int status;
	 public float salary;
	 public String company;
	
	public void getdata(String roll){
		try{
			//System.out.println("amana cdsjf");
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","root","lnm@#$");

		//System.out.println(con);
		Statement stmt=con.createStatement();
		String r="15ucs017";
		//System.out.println("select * from Student where sid = '"+roll+"'");
		ResultSet rs=stmt.executeQuery("select * from Student where sid = '"+roll+"'");


		while(rs.next()){
			sid=rs.getString("sid");
			sname=rs.getString("sname");
			spassword=rs.getString("spassword");
			sEmailId=rs.getString("sEmailId");
			cpi=rs.getFloat("cpi");
			status=rs.getInt("placementStatus");
			company=rs.getString("placedCompany");
			salary=rs.getFloat("salary");
		}

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
