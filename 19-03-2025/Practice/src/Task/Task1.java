package Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Task1 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice : new_register , update_details,delete_details ");
		String Choice = sc.next();
		if(Choice.equals("new_register")) {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter the college name : ");
			String Cn = sc1.next();
			System.out.println("Enter the event name : ");
			String En = sc1.next();
			System.out.println("Enter the Participatent name: ");
			String Pn = sc1.next();
			System.out.println("Enter the mail: ");
			String Mail = sc1.next();
			
			String query = "insert into event_organization(college_name,event_name,participatent_name,gmail)values(?,?,?,?);";
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskdb","root","Prudhvi@06");
				System.out.println("Welcome To The Event.");
				PreparedStatement ps = con.prepareStatement(query);
				
				
				ps.setString(1,Cn);
				ps.setString(2, En);
				ps.setString(3,Pn);
				ps.setString(4, Mail);
				int rows = ps.executeUpdate();
				
			   if(rows>0) {
				System.out.println("Registration successfull.. ");
			   }
				else {
					System.out.println("Registration Failed..");
				}
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
			else if(Choice.equals("update_details")) {
				Scanner sc2= new Scanner(System.in);
				System.out.println("Enter the college name to update : ");
				String Cn= sc2.next();
				System.out.println("Enter the event name to update :");
				String En = sc2.next();
				System.out.println("enter the participatent name to update :");
				String Pn = sc2.next();
				System.out.println("enter the Mail id to update :");
				String Mail = sc2.next();
				
				
				String query1 = "update event_organization set college_name = ?,event_name = ?,participatent_name = ?,gmail = ? where Regno = ?;";
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskdb","root","Prudhvi@06");
					PreparedStatement ps = con.prepareStatement(query1);
					ps.setString(1, Cn);
					ps.setString(2, En);
					ps.setString(3, Pn);
					ps.setString(4, Mail);
					ps.setInt(5, 1010);
					int rows = ps.executeUpdate();
					if(rows>0) {
						System.out.println("Updated successfully.. ");
					   }
						else {
							System.out.println("Failed..");
						}
				}
				catch(SQLException e) {
					e.printStackTrace();
				}	
		}
			else {
				String query2 = "delete from event_organization where regno = ?;";
				try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","Prudhvi@06");
				
				
				PreparedStatement ps = con.prepareStatement(query2);
				ps.setInt(1, 1010);
				
				int rows = ps.executeUpdate();
				if (rows > 0) {
	                System.out.println("User deleted successfully.");
	            } else {
	                System.out.println("Failed to delete the user.");
	            }
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			}
		
	}

}
