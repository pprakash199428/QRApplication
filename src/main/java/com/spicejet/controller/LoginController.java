package com.spicejet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spicejet.dto.LoginResponse;
import com.spicejet.dto.User;
import com.spicejet.service.LoginService;
import com.spicejet.service.impl.LoginServiceImpl;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	LoginResponse loginAuthentication(@RequestBody User user) throws JsonProcessingException {
		LoginServiceImpl impl = new LoginServiceImpl();
		String userName = user.getUsername();
		return loginService.authenticate(user);
		
		//After login api call to  EMDM for fetching user detail.

	}

}
