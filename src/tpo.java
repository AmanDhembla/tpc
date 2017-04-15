

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class tpo {
	int tid;
	String name;
	String designation;
//	public tpo(){
//		tid=1;
//		name="aman";
//		designation="tpo";
//	}
	public TechStudent showTechStud(String id){
			TechStudent s=new TechStudent();
			s.getDetails(id);
			return s;
	}
	public NonTechstud showNonTechStud(String id){
		NonTechstud s=new NonTechstud();
		s.getDetails(id);
		return s;
	}
	
	public void insertTechStud(String sid,String sname,String password,String email,double cpi,
			int status,String company,double salary,String branch,String interest){
		
		Connection con=null;
			try
			{
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
				
				String a="insert into Student(sid,sname,spassword,sEmailId,cpi,placementStatus,placedCompany,salary) "
						+ "values(?,?,?,?,?,?,?,?)";
				
				PreparedStatement preparedStmt = con.prepareStatement(a);
				  preparedStmt.setString (1,sid);
				  preparedStmt.setString (2,sname);
				  preparedStmt.setString (3, password);
				  preparedStmt.setString (4,email);
				  preparedStmt.setDouble(5, cpi);
				  preparedStmt.setInt(6, status);
				  preparedStmt.setString (7,company);
				  preparedStmt.setDouble (8,salary);
				  
				  String b="insert into TechStudent values(?,?,?)";
				  PreparedStatement stmt2 = con.prepareStatement(b);
				  stmt2.setString(1,sid);
				  stmt2.setString(2, interest);
				  stmt2.setString(3,branch);
				  
				  preparedStmt.execute();
				  stmt2.execute();
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
	}
	public int editTechStudent(String field,String id,String attribute)
	{
		System.out.println(field+id+attribute);
		Connection con=null;
			try
			{
				String sql;
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
				PreparedStatement ps;
				 
				if(field.equals("sname")){
					sql="UPDATE Student set sname= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					return 1;
				}
				if(field.equals("spassword")){
					sql="UPDATE Student set spassword= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					return 1;
				}
				if(field.equals("salary")){
					sql="UPDATE Student set salary= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					return 1;
				}
				if(field.equals("sEmailId")){
					sql="UPDATE Student set sEmailId= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					return 1;
				}
				if(field.equals("cpi")){
					sql="UPDATE Student set cpi= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					return 1;
				}
				if(field.equals("placementStatus")){
					sql="UPDATE Student set placementStatus= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					return 1;
				}
				if(field.equals("placedCompany")){
					sql="UPDATE Student set placedCompany= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					return 1;
				}
				if(field.equals("interest")){
					System.out.println("yoyo");
					sql="UPDATE TechStudent set interest= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					return 1;
				}
				if(field.equals("branch")){
					sql="UPDATE TechStudent set branch= ? where sid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					return 1;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				//System.out.println("exception");
				return 0;
			}
			return 0;
	}
	
	
	public void insertNonTechStud(String sid,String sname,String password,String email,double cpi,
			int status,String company,double salary,String interest){
		
		Connection con=null;
			try
			{
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
				
				String a="insert into Student(sid,sname,spassword,sEmailId,cpi,placementStatus,placedCompany,salary) "
						+ "values(?,?,?,?,?,?,?,?)";
				
				PreparedStatement preparedStmt = con.prepareStatement(a);
				  preparedStmt.setString (1,sid);
				  preparedStmt.setString (2,sname);
				  preparedStmt.setString (3, password);
				  preparedStmt.setString (4,email);
				  preparedStmt.setDouble(5, cpi);
				  preparedStmt.setInt(6, status);
				  preparedStmt.setString (7,company);
				  preparedStmt.setDouble (8,salary);
				  
				  String b="insert into NonTechStudent values(?,?)";
				  PreparedStatement stmt2 = con.prepareStatement(b);
				  stmt2.setString(1,sid);
				  stmt2.setString(2, interest);
				  
				  preparedStmt.execute();
				  stmt2.execute();
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
	}



public void editNonTechStudent(String field,String id,String attribute)
{
	System.out.println(field+id+attribute);
	Connection con=null;
		try
		{
			String sql;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
			PreparedStatement ps;
			 
			if(field.equals("sname")){
				sql="UPDATE Student set sname= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
			}
			if(field.equals("spassword")){
				sql="UPDATE Student set spassword= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
			}
			if(field.equals("salary")){
				sql="UPDATE Student set salary= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
			}
			if(field.equals("sEmailId")){
				sql="UPDATE Student set sEmailId= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
			}
			if(field.equals("cpi")){
				sql="UPDATE Student set cpi= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
			}
			if(field.equals("placementStatus")){
				sql="UPDATE Student set placementStatus= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
			}
			if(field.equals("placedCompany")){
				sql="UPDATE Student set placedCompany= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
			}
			if(field.equals("interest")){
				System.out.println("yoyo");
				sql="UPDATE NonTechStudent set interest= ? where sid=?";
				ps=con.prepareStatement(sql);
				ps.setString(1,attribute);
				ps.setString(2, id);
				ps.executeUpdate();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("exception");
		}
	
}




public void editCellMember(String field,String id,String attribute){
	Connection con=null;
	try
	{
		String sql;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
		PreparedStatement ps;
		if(field.equals("cname")){
			System.out.println("i m sukki");
			sql="UPDATE CellMember set cname= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
		}
		if(field.equals("cpassword")){
			sql="UPDATE CellMember set cpassword= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
		}
		if(field.equals("ContactNumber")){
			sql="UPDATE CellMember set ContactNumber= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
		}
		if(field.equals("cEmailId")){
			sql="UPDATE CellMember set cEmailId= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
		}
		if(field.equals("year")){
			sql="UPDATE CellMember set year= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
		}
		if(field.equals("gender")){
			sql="UPDATE CellMember set gender= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
		}
		if(field.equals("category")){
			sql="UPDATE CellMember set category= ? where cid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,attribute);
			ps.setString(2, id);
			ps.executeUpdate();
		}
	}
	catch(SQLException e)
	{
		System.out.println("exception");
	}

}
public void insertCellMember(String cid,String cname,String password,String email,String contact,
		String year,String gender,String category){
	
	Connection con=null;
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","tpcProject","tpc");
			
			String a="insert into CellMember values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(a);
			  preparedStmt.setString(1,cid);
			  preparedStmt.setString (2,cname);
			  preparedStmt.setString (3, password);
			  preparedStmt.setString (4,email);
			  preparedStmt.setString(5, contact);
			  preparedStmt.setString(6,year);
			  preparedStmt.setString(7,gender);
			  preparedStmt.setString(8,category);
			  
			  preparedStmt.execute();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
}



}

