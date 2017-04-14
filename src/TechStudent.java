

import java.sql.*;

public class TechStudent implements Student {
	String id;
	String name;
	String password, emailId, placedComp;
	float cpi, salary;
	int placementStatus;
	String branch;
	String interest;

	public void getDetails(String id) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpc?autoReconnect=true&useSSL=false", "root",
					"lnm@#$");

			Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from Student");
			ResultSet rs1 = stmt1.executeQuery("select * from TechStudent");

			while (rs.next()) {
				System.out.println("hello");
				if (rs.getString("sid").equals(id)) {
					System.out.println("hello");
					this.id = rs.getString("sid");
					name = rs.getString("sname");
					password = rs.getString("spassword");
					emailId = rs.getString("semailId");
					placedComp = rs.getString("placedCompany");
					cpi = rs.getFloat("cpi");
					salary = rs.getFloat("salary");
					placementStatus = rs.getInt("placementStatus");

					
				}
			}
			while (rs1.next()) {
				if (rs1.getString("sid") == id)
					branch = rs1.getString("branch");
					interest =rs1.getString("interest");
			}
			//stmt.close();
			//stmt = null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}
}
