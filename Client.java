package com.Client;

import java.util.Scanner;

import com.createconnection.CreateConnection;

public class Client {

	public static void main(String[] args) throws Exception {
		int ch = 1;
		Scanner sc = new Scanner(System.in);

		while ((ch >0) && (ch < 4)) {
			System.out.println("*************************************** Contact Application ********************************************");
			CreateConnection.SelectQuery();
			System.out.println("********************************************************************************************************");
			System.out.println("Enter 1.Create New Contact     Enter 2.To Update Existing contact      Enter 3. To Delete contact");
			System.out.println("********************************************************************************************************");
			System.out.println("Enter your choice");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				CreateConnection.InsetQuery();
				break;

			case 2:
				CreateConnection.UpdateQuery();
				break;

			case 3:
				CreateConnection.DeleteQuery();
				break;

			}

		}

	}
}
