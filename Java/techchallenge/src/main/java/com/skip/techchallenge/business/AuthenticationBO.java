package com.skip.techchallenge.business;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.skip.techchallenge.dao.CustomerDAO;
import com.skip.techchallenge.model.AuthenticationDTO;
import com.skip.techchallenge.model.CustomerDTO;

/************************************************************************************
 * Objective: Business object class to handle Authentication interactions.
 * @author feiserte
 ************************************************************************************/
public class AuthenticationBO {

	private final Logger logger = Logger.getLogger(AuthenticationBO.class);
	
	private CustomerDAO customerDAO = new CustomerDAO();

	/************************************************************************************
	 * Objective: Validate if user exist and if the password is correct.
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @param email
	 * @param password
	 * @return AuthenticationDTO
	 ************************************************************************************/
	public AuthenticationDTO userAuthentication(String email, String password) {
		AuthenticationDTO authenticationDTO = new AuthenticationDTO();
		CustomerDTO customer = null;
		String errorMessage = null;
		boolean isAuthenticated = false;

		try {
			customer = customerDAO.getUserByEmail(email);
		} catch (SQLException e) {
			String sqlErrorMsg = "\"Database issue. \" + e.getMessage()";
			System.out.println(sqlErrorMsg);
			errorMessage = sqlErrorMsg;
			e.printStackTrace();
		}
		
		if(customer != null) {
			// TODO Implement a logic to decrypt the password from database
			if (customer.getPasswword().equals(password)) {
				isAuthenticated = true;
				authenticationDTO.setCustomer(customer);
				
				logger.info("User authenticated: " + customer.getName());
			} else {
				errorMessage = "Invalid password";
			}
		} else {
			errorMessage = "User not found.";
		}
		
		authenticationDTO.setAuthenticated(isAuthenticated);
		authenticationDTO.setErrorMessage(errorMessage);
		
		
		return authenticationDTO;
	}
}
