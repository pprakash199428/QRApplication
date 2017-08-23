package com.spicejet.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spicejet.dto.User;

@RestController
public class CheckoutController {
	
	@RequestMapping(value= "/checkout", method = RequestMethod.POST)
	void loginAuthentication(@RequestBody User user){
		
	}

}
