package com.skip.techchallenge.business;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.AuthenticationDTO;

public class AuthenticationBOTest {

	private AuthenticationBO bo = new AuthenticationBO(); 
	@Test
    public void userAuthentication() {
		String email = "felipe@dvdsp.com.br";
		String password = "1234";
		
		AuthenticationDTO dto = bo.userAuthentication(email, password);

		Assert.assertNotNull(dto.getCustomer());
	}
}
