package com.customerinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataToDatabase {
	public int updateToDatabase(CustomerGetSet getSet) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int count = 0;
        String qry="update customer_details set firstname= ?, lastname=?, street=?, city=?, state=?, zipcode=?, product_name=?, updated_on = to_date( ? ,'dd-MM-yyyy'), updated_by= ? where cid = ? ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##manoj","manoj");
			prepareStatement = connection.prepareStatement(qry);        
	        prepareStatement.setString(1, getSet.getFirstname());
	        prepareStatement.setString(2, getSet.getLastname());
	        prepareStatement.setString(3, getSet.getStreet());
	        prepareStatement.setString(4, getSet.getCity());
	        prepareStatement.setString(5, getSet.getState());
	        prepareStatement.setInt(6, getSet.getZipcode());
            prepareStatement.setString(7, getSet.getProduct_name());
            prepareStatement.setString(8, getSet.getUpdated_on());
            prepareStatement.setString(9, getSet.getUpdated_by());
            prepareStatement.setInt(10, getSet.getCid());
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
