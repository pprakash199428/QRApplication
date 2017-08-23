package com.spicejet.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spicejet.dto.User;

@RestController
public class CheckInController {

	@RequestMapping(value= "/checkin", method = RequestMethod.POST)
	void loginAuthentication(@RequestBody User user){
		
	}
}
