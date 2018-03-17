package com.skip.techchallenge.dao;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.CustomerDTO;

public class CustomerDAOTest {

	private CustomerDAO dao = new CustomerDAO(); 
	
	@Test
	public void getUserByEmail() throws SQLException {
		String email = "felipe@dvdsp.com.br";
		CustomerDTO customer = dao.getUserByEmail(email);
		
		Assert.assertNotNull(customer);
	}
}
