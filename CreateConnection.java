package com.createconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CreateConnection {

	public static Connection createConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Contact_Management", "root","Nikita@1101");
		return con;
	}

	public static void InsetQuery() throws Exception {
		Connection con = CreateConnection.createConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("********************************************************************************************************");
		System.out.println("1. Create new contact");
		System.out.println("********************************************************************************************************");
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter ContactNo");
		String contact=sc.next();
		System.out.println("Enter Email");
		String mail=sc.next();
		System.out.println("Enter Saveto");
		String save=sc.next();
		PreparedStatement prep = con.prepareStatement("insert into Contact_List values (?,?,?,?)");
		prep.setString(1, name);
		prep.setString(2, contact);
		prep.setString(3, mail);
		prep.setString(4, save);
		prep.executeUpdate();
		System.out.println("********************************************************************************************************");
		System.out.println("Contact Created");
		System.out.println("********************************************************************************************************");
		
	}

	public static void UpdateQuery() throws Exception {

		Connection con = CreateConnection.createConnection();
		PreparedStatement prep;
		Scanner sc = new Scanner(System.in);
		System.out.println("********************************************************************************************************");
		System.out.println("Update Contact");
		System.out.println("********************************************************************************************************");
		System.out.println(" Enter 1.TOUpdateName \n Enter 2.ToupdateContactNo \n Enter 3.ToUpdateEmail \n Enter 4.ToUpdateSaveTo");
		System.out.println("********************************************************************************************************");
		System.out.println(" Enter choice ");
		int ch = sc.nextInt();
		System.out.println("********************************************************************************************************");
		String contactNO;
		switch (ch) {
			case 1:
				System.out.println(" Enter Name you want to update");
				String name=sc.next();
				System.out.println(" Enter contact no");
				contactNO=sc.next();
				prep = con.prepareStatement("update Contact_List set Name =? where contactNo = ?");
				prep.setString(1, name);
				prep.setString(2, contactNO);
				prep.executeUpdate();
				System.out.println("********************************************************************************************************");
				System.out.println("Name Updated");
				break;
				
			case 2:
				System.out.println(" Enter ContactNo you want to update");
				String ContactUpdate=sc.next();
				System.out.println(" Enter contact no");
				contactNO=sc.next();
				 prep = con.prepareStatement(" update Contact_List set contactNo=ContactUpdate where contactNo=contactNO ");
				prep.setString(1, ContactUpdate);
				prep.setString(2, contactNO);
				prep.executeUpdate();
				System.out.println("********************************************************************************************************");
				System.out.println("contact no updated");
				break;
				
			case 3:
				System.out.println(" Enter Email Address you want to update");
				String Email=sc.next();
				System.out.println(" Enter contact no");
				contactNO=sc.next();
				prep = con.prepareStatement(" update Contact_List set Email=Email where contactNo=contactNO ");
				prep.setString(1, Email);
				prep.setString(2, contactNO);
				prep.executeUpdate();
				System.out.println("********************************************************************************************************");
				System.out.println("email updated");
				break;
				
			case 4:
				System.out.println(" Enter SavedTo Option you want to update");
				String Save=sc.next();
				System.out.println(" Enter contact no");
				contactNO=sc.next();
				prep = con.prepareStatement(" update Contact_List set saveTo=save where contactNo=contactNO ");
				prep.setString(1, Save);
				prep.setString(2, contactNO);
				prep.executeUpdate();
				System.out.println("********************************************************************************************************");
				System.out.println("save to updated");
				break;
			
			default:
				System.out.println("********************************************************************************************************");
				System.out.println("don`t want to updare anything");
				break;
		}
		System.out.println("********************************************************************************************************");
		

	}

	public static void DeleteQuery() throws Exception {
		System.out.println("********************************************************************************************************");
		System.out.println("Delete contact");
		System.out.println("********************************************************************************************************");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter contact no you want to delete");
		String s=sc.next();
		Connection con = CreateConnection.createConnection();
		PreparedStatement prep = con.prepareStatement("delete from Contact_List where contactNo=? ");
		prep.setString(1, s);
		prep.executeUpdate();
		System.out.println("********************************************************************************************************");
		System.out.println("Contact deleted");
		System.out.println("********************************************************************************************************");
		
	

	}

	public static void SelectQuery() throws Exception {
		Connection con = CreateConnection.createConnection();
		Statement s=con.createStatement();
		ResultSet r =s .executeQuery("select Name,contactNo from Contact_List");
		while (r.next()) {
			System.out.println(r.getString(1) + " " + r.getString(2));
		}
	}
}
