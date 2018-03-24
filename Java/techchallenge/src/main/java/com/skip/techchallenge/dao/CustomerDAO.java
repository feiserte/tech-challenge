package com.skip.techchallenge.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skip.techchallenge.model.CustomerDTO;

/************************************************************************************
 * Objective: Data Transfer Object class to manage Customer data from database
 * @author feiserte
 ************************************************************************************/
public class CustomerDAO {

	/************************************************************************************
	 * Objective: Get CustomerDTO by email
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @return customer
	 * @throws SQLException
	 ************************************************************************************/
	public CustomerDTO getUserByEmail(String email) throws SQLException {
		CustomerDTO customer = null;
		PreparedStatement statement = MySQLConnection.getDbCon().conn.prepareStatement("select * from customer where email like ?");
		statement.setString(1, email);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			customer = new CustomerDTO();
			customer.setId(rs.getInt("id"));
			customer.setName(rs.getString("name"));
			customer.setEmail(rs.getString("email"));
			customer.setPasswword(rs.getString("password"));
			customer.setAddress(rs.getString("address"));
			customer.setCreationDate(rs.getString("creation"));
		}
		
		return customer;
	}
	
	/************************************************************************************
	 * Objective: Get CustomerDTO by id
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @return customer
	 * @throws SQLException
	 ************************************************************************************/
	public CustomerDTO getUserById(Integer customerId) throws SQLException {
		CustomerDTO customer = null;
		PreparedStatement statement = MySQLConnection.getDbCon().conn.prepareStatement("select * from customer where id = ?");
		statement.setInt(1, customerId);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			customer = new CustomerDTO();
			customer.setId(rs.getInt("id"));
			customer.setName(rs.getString("name"));
			customer.setEmail(rs.getString("email"));
			customer.setPasswword(rs.getString("password"));
			customer.setAddress(rs.getString("address"));
			customer.setCreationDate(rs.getString("creation"));
		}
		
		return customer;
	}
	
}
