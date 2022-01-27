package com.customerinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRecordFromTable {
public static void main(String[] args) {
 
	Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the column Name: ");
	String dc=scanner.next();
	System.out.println("Enter Which value you want to delete- ");
	String val=scanner.next();
	scanner.close();
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	
		try {
			 connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##manoj","manoj");
		   	prepareStatement = connection.prepareStatement("delete from customer_details where "+dc+" = ? ");
            prepareStatement.setString(1, val);
            int executeUpdate = prepareStatement.executeUpdate();
   System.out.println(executeUpdate);
   if(executeUpdate==1) {
	   System.out.println("Value Successfully Deleted !");
   }
   else System.out.println("Value Not Deleted !");

		}
		 catch (SQLException e) {
				e.printStackTrace();

			}
		finally {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
}
}
