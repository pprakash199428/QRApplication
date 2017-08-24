package com.spicejet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spicejet.dto.EmdmUserDetails;
import com.spicejet.dto.User;
import com.spicejet.service.LoginService;
import com.spicejet.service.impl.LoginServiceImpl;
import com.spicejet.util.RestRequester;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	RestRequester restRequester;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	EmdmUserDetails loginAuthentication(@RequestBody User user) throws Exception {
		String userName = user.getUsername();
		if(loginService.authenticate(user).getStatus().equalsIgnoreCase("true")){
			return loginService.authoriseFromEMDM(userName);
		}
		return null;
		
		//After login api call to  EMDM for fetching user detail.
		
	}

}
