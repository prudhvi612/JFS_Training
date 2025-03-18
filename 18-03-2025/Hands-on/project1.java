package Project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class project1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the mail : ");
		String mail = sc.next();
		
		String query = "Select * from users where gmail = '"+mail+"';";
		String url = "jdbc:mysql://localhost:3306/testdb";
		try {
			Connection con = DriverManager.getConnection(url,"root","Prudhvi@06");
			System.out.println("Connecttion Established Succesfully..");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				String pass = rs.getString("pass");
				System.out.println("enter the password : ");
				String password = sc.next();
				
				if(password.equals(pass)) {
					System.out.println("welcome back "+ rs.getInt("userId"));
				}
				else {
					System.out.println("Invalid Password");
				}
			}
			else {
				System.out.println("User not found");
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
