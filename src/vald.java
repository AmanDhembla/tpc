
import java.sql.*;

public class vald {
	  
	public int validate(String rollno,String pass,String des){
		
		System.out.println(rollno+pass+des);
		try{
			//System.out.println("amana cdsjf");
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false","root","lnm@#$");
		
		//System.out.println(con);
		Statement stmt=con.createStatement();
		if(des.equals("student")){
		ResultSet rs=stmt.executeQuery("select * from Student");
		
		while(rs.next()){
			System.out.println("hello all"+rs.getInt("sid")+rs.getString("spassword"));
			//System.out.println(rs.getString("sid").equals(rollno) & rs.getString("spassword").equals(pass) );
			if(rs.getString("sid").equals(rollno) & rs.getString("spassword").equals(pass)  ){
				System.out.println("in here");
				return 1;
			}
		}
		}
		
		
		else if(des.equals("tpo")){
			if(pass.equals("m") & rollno.equals("manuj")){
				return 1;
			}
		
		}
		
		
		else if(des.equals("cell_members")){
			System.out.println("cell");
			ResultSet rs=stmt.executeQuery("Select * from CellMember");
			while(rs.next()){
				//System.out.println("hello all"+rs.getInt("sid")+rs.getString("spassword"));
				//System.out.println(rs.getString("sid").equals(rollno) & rs.getString("spassword").equals(pass) );
				if(rs.getString("cid").equals(rollno) & rs.getString("cpassword").equals(pass)  ){
					System.out.println("in here");
					return 1;
				}
			}
		}
		
		
		return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
	}
	
}
