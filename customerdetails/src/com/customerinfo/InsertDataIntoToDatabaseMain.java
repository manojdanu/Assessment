package com.customerinfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InsertDataIntoToDatabaseMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(":Enter the Following Customer Details:");
		
		System.out.println("Enter the Customer ID- ");
		int cid = sc.nextInt();
		
		System.out.println("Enter the FirstName- ");
		String firstname = sc.next();
		
		System.out.println("Enter the LastName- ");
		String lastname = sc.next();

		System.out.println("Enter the Street- ");
		String street = sc.next();
		
		System.out.println("Enter the City- ");
		String city = sc.next();
		
		System.out.println("Enter the state- ");
		String state = sc.next();
		
		System.out.println("Enter the Zip Code- ");
		int zipcode = sc.nextInt();
				
		System.out.println("Enter the Product Name- ");
		String product_name = sc.next();
				
//      By default date will set according to our system  i imported date class below.		
//		System.out.println("Enter the Created On- ");
//		String created_on = sc.next();
		
		System.out.println("Enter the Created by UserName- ");
		String created_by = sc.next();

//      These two value will be set when someone update the table; by default they are null !				
//		System.out.println("Enter the Updated_On");
//		String updated_on = sc.next();		
//		System.out.println("Enter the Updated by UserName- ");
//		String updated_by=sc.next();
		
  		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date = simpleDateFormat.format(new Date());
				
		CustomerGetSet getSet = new CustomerGetSet();
		getSet.setCid(cid);
		getSet.setFirstname(firstname);
		getSet.setLastname(lastname);
		getSet.setStreet(street);
		getSet.setCity(city);
		getSet.setState(state);
		getSet.setZipcode(zipcode);
		getSet.setProduct_name(product_name);
		getSet.setCreated_on(date);
		getSet.setCreated_by(created_by);		
		sc.close();
		

	InsertNewDataToDatabase insertNewDataToDatabase = new InsertNewDataToDatabase();
	int i = insertNewDataToDatabase.insertIntoTable(getSet);
	if(i==1) {
		System.out.println("Data successfully inserted into table !");
	}
	else
		System.out.println("Data is not inserted ");
	}

}
