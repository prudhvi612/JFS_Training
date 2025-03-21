package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice2 {

	public static void main(String[] args) {
		String query = "delete from users where userid = ?;";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","Prudhvi@06");
			System.out.println("Connection Established Succesfully..");
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 1000);
			
			int rows = ps.executeUpdate();
			System.out.println(rows + "row(s) affected");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}