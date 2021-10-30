package com.customerinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableQuerry {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			String quarry = "create table Customer_details(cid number(20),firstname varchar2(20),lastname varchar2(20), street varchar2(20),city varchar2(20),State varchar2(20),zipcode number(6),product_name varchar2(30),created_on date,created_by varchar2(20),updated_on date,updated_by varchar2(20))";
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##manoj", "manoj");
			statement = connection.createStatement();
			statement.executeQuery(quarry);
			System.out.println("Successfully Created New Table Into Database");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
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
	}
}
