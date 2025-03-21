package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice3 {

	public static void main(String[] args) {
		String query = "update users set username = ?,gmail = ?,userpass = ? where userid = ?;";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","Prudhvi@06");
			System.out.println("Connection Established Succesfully..");
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "prudhvi1");
			ps.setString(2, "prudhvi1@gmail.com");
			ps.setString(3, "prudhvi1@123");
			ps.setInt(4, 1000);
			
			int rows = ps.executeUpdate();
			System.out.println(rows + "row(s) affected");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
