package com.customerinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RetrieveDataFromCustomerDetailsTable {
	
	public ArrayList<CustomerGetSet> getAllData(){
		Connection connection=null;
		ArrayList<CustomerGetSet> arrrylist =null;
		Statement statement=null;
		ResultSet resultset=null;
		
		try {
			 connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##manoj","manoj");
			 statement = connection.createStatement();
			 resultset = statement.executeQuery("select * from customer_details");
			 arrrylist= new ArrayList<>();
			 while(resultset.next()) {
				 CustomerGetSet customerGetSet = new CustomerGetSet();
				 customerGetSet.setCid(resultset.getInt("cid"));
				 customerGetSet.setFirstname(resultset.getString("firstname"));
				 customerGetSet.setLastname(resultset.getString("lastname"));
				 customerGetSet.setStreet(resultset.getString("street"));
				 customerGetSet.setCity(resultset.getString("city"));
				 customerGetSet.setState(resultset.getString("state"));
				 customerGetSet.setZipcode(resultset.getInt("zipcode"));
				 customerGetSet.setProduct_name(resultset.getString("product_name"));
				 customerGetSet.setCreated_on(resultset.getString("created_on"));
				 customerGetSet.setCreated_by(resultset.getString("created_by"));
				 customerGetSet.setUpdated_on(resultset.getString("updated_on"));
				 customerGetSet.setUpdated_by(resultset.getString("updated_by"));
				 arrrylist.add(customerGetSet);
			 }
			 
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	return arrrylist;
	}
	
}
