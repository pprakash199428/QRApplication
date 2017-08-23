package com.spicejet.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spicejet.dto.LoginResponse;
import com.spicejet.dto.User;

public interface LoginService {

	LoginResponse authenticate(User user) throws JsonProcessingException;
}
