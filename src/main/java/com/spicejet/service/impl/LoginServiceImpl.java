package com.spicejet.service.impl;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spicejet.dto.LoginResponse;
import com.spicejet.dto.User;
import com.spicejet.service.LoginService;
import com.spicejet.util.SpicejetUtil;

@Service
public class LoginServiceImpl implements LoginService{

	public LoginResponse authenticate(User user) throws JsonProcessingException {
		
		String encryptedUsername=SpicejetUtil.EncryptV2(user.getUsername(), "SceJepitKye41352");
		String encryptedPassword=SpicejetUtil.EncryptV2(user.getPassword(), "SceJepitKye41352");
		user.setUsername(encryptedUsername);
		user.setPassword(encryptedPassword);
		user.setApplicationname("uat");
		user.setVersion("2");
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost();
		httpPost.setURI(URI.create("http://sg-azr-tom01-prod.centralindia.cloudapp.azure.com/netcore-api/login"));
		HttpResponse response = null;
		String apiOutput=null;
		LoginResponse loginResponse = null;
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		try {
			httpPost.setEntity(new ByteArrayEntity(jsonInString.toString().getBytes("UTF8")));
			httpPost.setHeader("Content-type", "application/json");
			System.out.println(jsonInString);
			response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
	        apiOutput = EntityUtils.toString(httpEntity);
	        loginResponse=new ObjectMapper().readValue(apiOutput, LoginResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(apiOutput);
		return loginResponse;
	}

}
