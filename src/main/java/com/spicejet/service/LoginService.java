package com.spicejet.service;

import com.spicejet.dto.EmdmUserDetails;
import com.spicejet.dto.LoginResponse;
import com.spicejet.dto.User;

public interface LoginService {

	LoginResponse authenticate(User user);
	
	EmdmUserDetails authoriseFromEMDM(String username) throws Exception;
}
