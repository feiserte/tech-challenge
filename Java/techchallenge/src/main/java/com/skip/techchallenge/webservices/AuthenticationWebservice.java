package com.skip.techchallenge.webservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skip.techchallenge.business.AuthenticationBO;
import com.skip.techchallenge.model.AuthenticationDTO;

/************************************************************************************
 * Objective: Webservice to authenticate user
 * @author feiserte
 ************************************************************************************/
@RestController
public class AuthenticationWebservice {
	
	@RequestMapping(value = "/userAuthentication", method = RequestMethod.POST)
	public @ResponseBody AuthenticationDTO userAuthentication(@RequestParam(value="email", defaultValue="") String email, @RequestParam(value="password", defaultValue="") String password) {
		AuthenticationBO bo = new AuthenticationBO();
		return bo.userAuthentication(email, password);
	}
	
}
