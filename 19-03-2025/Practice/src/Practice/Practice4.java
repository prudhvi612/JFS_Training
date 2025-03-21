package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice4 {

	public static void main(String[] args) {
		String query = "select * from users";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","Prudhvi@06");
			System.out.println("Connection Established Succesfully..");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData meta = rs.getMetaData();
			
			System.out.println(meta.getColumnCount());
			System.out.println(meta.getColumnName(1));
			System.out.println(meta.getColumnTypeName(1));
			System.out.println(meta.getTableName(1));
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
