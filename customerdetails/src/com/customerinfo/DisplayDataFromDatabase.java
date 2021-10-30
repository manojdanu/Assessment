package com.customerinfo;

import java.util.ArrayList;

public class DisplayDataFromDatabase {

	public static void main(String[] args) {

		RetrieveDataFromCustomerDetailsTable retrieveDataFromCustomerDetailsTable = new RetrieveDataFromCustomerDetailsTable();
		ArrayList<CustomerGetSet> allData = retrieveDataFromCustomerDetailsTable.getAllData();
		allData.forEach(data -> {
			System.out.println(data.getCid());
			System.out.println(data.getFirstname());
			System.out.println(data.getLastname());
			System.out.println(data.getStreet());
			System.out.println(data.getCity());
			System.out.println(data.getState());
			System.out.println(data.getZipcode());
			System.out.println(data.getProduct_name());
			System.out.println(data.getCreated_on());
			System.out.println(data.getCreated_by());
			System.out.println(data.getUpdated_on());
			System.out.println(data.getUpdated_by());	
		});
	}

}
