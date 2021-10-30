package com.customerinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertNewDataToDatabase {
	public int insertIntoTable(CustomerGetSet getSet) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int count = 0;

		try {
			 connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##manoj","manoj");
		   	prepareStatement = connection.prepareStatement("insert into customer_details values(?,?,?,?,?,?,?,?,to_date(?,'dd-MM-yy'),?,?,?)");
	        prepareStatement.setInt(1, getSet.getCid());
	        prepareStatement.setString(2, getSet.getFirstname());
	        prepareStatement.setString(3, getSet.getLastname());
	        prepareStatement.setString(4, getSet.getStreet());
	        prepareStatement.setString(5, getSet.getCity());
	        prepareStatement.setString(6, getSet.getState());
	        prepareStatement.setInt(7, getSet.getZipcode());
            prepareStatement.setString(8, getSet.getProduct_name());
            prepareStatement.setString(9, getSet.getCreated_on());
            prepareStatement.setString(10,getSet.getCreated_by());
            prepareStatement.setString(11, null);
            prepareStatement.setString(12, null);
	    
			count = prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
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

		return count;
	}

}
