package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class practice {

	public static void main(String[] args) {
		String query = "select * from users ";
		String url = "jdbc:mysql://localhost:3306/testdb";
		String user = "root";
		String pass = "Prudhvi@06";
		
		try {
		Connection con = DriverManager.getConnection(url,user,pass);
		System.out.println("Connection Established Successfully...");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
		int id = rs.getInt("userId");
		String email = rs.getString("gmail");
		String password = rs.getString("pass");
		System.out.println(id + " " + email + " " + password);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
