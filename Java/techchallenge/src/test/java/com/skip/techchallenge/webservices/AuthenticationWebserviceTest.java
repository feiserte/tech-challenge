package com.skip.techchallenge.webservices;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.AuthenticationDTO;

public class AuthenticationWebserviceTest {

	private AuthenticationWebservice ws = new AuthenticationWebservice();
	
	@Test
    public void userAuthentication() {
		String email = "felipe@dvdsp.com.br";
		String password = "1234";
		
		AuthenticationDTO dto = ws.userAuthentication(email, password);

		Assert.assertNotNull(dto.getCustomer());
	}
}
