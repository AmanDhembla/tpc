
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TechCompany   {
	
	String req;
	String branch;
	int id;
	String name,emailId,city;
	double cpi,salary;
	Date visitdate;
	
	 public TechCompany[] CompanyVisit(String d1,String d2)
	 {
		 TechCompany t[]=new TechCompany[10];

			try{
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject", "tpc");
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date1 = sdf1.parse(d1);
				java.util.Date date2 = sdf1.parse(d2);
				java.sql.Date sqlStartDate1 = new java.sql.Date(date1.getTime());
				java.sql.Date sqlStartDate2 = new java.sql.Date(date2.getTime());
				Statement stmt= con.createStatement();
				Statement stmt1= con.createStatement();
				String sql="select * from Company where visitDate>'"+sqlStartDate1+ "' and visitDate < '"+sqlStartDate2+ "'and s.placementStatus=0";
				ResultSet res= stmt.executeQuery(sql);
				int i=0;
				while(res.next())
				{
					t[i]=new TechCompany();
					t[i].name=res.getString("cname");
					t[i].visitdate=res.getDate("visitDate");
					t[i].cpi=res.getDouble("cpiCriteria");
					t[i].id=res.getInt("cIN");
					t[i].salary=res.getDouble("salary");
					String sql1="select * from TechCompany where cIN='"+t[i].id+ "' ";
					ResultSet res1=stmt1.executeQuery(sql1);
					while(res1.next())
					{
						t[i].req=res1.getString("requirements");
						t[i].branch=res1.getString("branch");
					}
			    	i++;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return t;
	 }
	 
	 public TechStudent[] selectedTech(String company)
	 {
		 TechStudent t[]=new TechStudent[10];
		 TechCompany c=new TechCompany();
		 
		 try
		 {
			 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject", "tpc");
			 Statement stmt=con.createStatement();
			 Statement stmt1=con.createStatement();
			 String sql="select * from Company where cname='"+company+ "'";
			 ResultSet res=stmt.executeQuery(sql);
			 while(res.next())
			 {
				 c.id=res.getInt("cIN");
				 c.name=res.getString("cname");
				 c.cpi=res.getDouble("cpiCriteria");
			 }
			 String sql1="select * from TechCompany where cIN='"+c.id+ "'";
			 ResultSet res1=stmt1.executeQuery(sql1);
			 while(res1.next())
			 {
				 c.req=res1.getString("requirements");
				 c.branch=res1.getString("branch");
			 }
			 String sql2="select * from Student s, TechStudent t where t.sid=s.sid and s.cpi>='"+c.cpi+ "' and t.interest='"+c.req+ "' and t.branch='"+c.branch+ "'and s.placementStatus=0";
			 Statement stmt2=con.createStatement();
			 ResultSet res2=stmt2.executeQuery(sql2);
			 int i=0;
			 while(res2.next())
			 {
				 t[i]=new TechStudent();
				 t[i].id=res2.getString("sid");
				 t[i].name=res2.getString("sname");
				 i++;
			 }
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 
		 return t;
	 }
	 
	 public void showDetails(String cid)
	 {	
			try
			{
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc","tpcProject","tpc");
				
				Statement stmt= con.createStatement();
				ResultSet res= stmt.executeQuery("select * from Company");
				while(res.next())
				{
					if(res.getString("cid").equals(cid))
					{
						id=res.getInt("cIN");
						name=res.getString("cname");
						emailId=res.getString("cEmailId");
						cpi=res.getDouble("cpiCriteria");
						city=res.getString("city");
						salary=res.getDouble("salary");
						visitdate=res.getDate("visitDate");	
					}	
				}
				Statement stmt1= con.createStatement();
				ResultSet res1= stmt1.executeQuery("select * from TechCompany where cIN='"+id+ "'");
				while(res1.next())
				{
					branch=res1.getString("branch");
					req=res1.getString("requirements");
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		
	 }

}
