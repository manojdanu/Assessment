package com.customerinfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UpdateTableScanValuesFromUserMain {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);

		// The customer id should be primary key. So here i am using customer id in where condition to update all other values
		//i can use switch condition for making menu driven program but here it will take more time so i am updating at one querry.
        System.out.println("Enter the Customer id of a person which value you want to update !");
        int cid=sc.nextInt();
        
		
		System.out.println(":Enter the Following details Customer Details:");
		
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
				
		
//		System.out.println("Enter the Created On- ");
//		String created_on = sc.next();	
//		System.out.println("Enter the Created by UserName- ");
//		String created_by = sc.next();

//      These two value will be set when someone update the table; by default they are null !				
//		System.out.println("Enter the Updated_On");
//		String updated_on = sc.next();		
	
		System.out.println("Enter the Name who is updating the database- ");
		String updated_by=sc.next();
		
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
		getSet.setUpdated_on(date);
	    getSet.setUpdated_by(updated_by);
		sc.close();
		
UpdateDataToDatabase updateDataToDatabase = new UpdateDataToDatabase();
int updateToDatabase = updateDataToDatabase.updateToDatabase(getSet);
if(updateToDatabase==1) {
	System.out.println("Value Successully Updated !");
}
else System.out.println("Value is not Updated !");
	}

}
