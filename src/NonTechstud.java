


import java.sql.*;


public class NonTechstud implements Student{
	String id;
	String name;
	String password,emailId,placedComp;
	float cpi,salary;
	int placementStatus;
	String interest;
	
	public void getDetails(String id){
		Connection con=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
			
			Statement stmt=con.createStatement();
		
			ResultSet rs=stmt.executeQuery("select * from Student");
			ResultSet rs1 = stmt.executeQuery("select * from NonTechStudent");

			while(rs.next()){
				if(rs.getString("sid")==id)
				{
					id=rs.getString("sid");
					name=rs.getString("sname");
					password=rs.getString("spassword");
					emailId=rs.getString("semailId");
					placedComp=rs.getString("placedCompany");
					cpi=rs.getFloat("cpi");
					salary=rs.getFloat("salary");
					placementStatus=rs.getInt("placementStatus");
					
					
				}
			}
			while (rs1.next()) {
			if (rs1.getString("sid") == id)
				interest = rs1.getString("interest");
		}
			//stmt.close();
			//stmt=null;
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		
		
	}
}

