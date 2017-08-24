package com.spicejet.service.impl;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spicejet.dto.EMDMUserDetailsDto;
import com.spicejet.dto.EmdmUserDetails;
import com.spicejet.dto.LoginResponse;
import com.spicejet.dto.User;
import com.spicejet.service.LoginService;
import com.spicejet.util.Constants;
import com.spicejet.util.RestRequester;
import com.spicejet.util.RestRequester.RequestType;
import com.spicejet.util.SpicejetUtil;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	Environment environment;
	
	@Autowired
	ApplicationContext context;

	public LoginResponse authenticate(User user) {
		LoginResponse loginResponse = new LoginResponse();

		try {
			String encryptedUsername = SpicejetUtil.EncryptV2(user.getUsername(), "SceJepitKye41352");
			String encryptedPassword = SpicejetUtil.EncryptV2(user.getPassword(), "SceJepitKye41352");
			user.setUsername(encryptedUsername);
			user.setPassword(encryptedPassword);
			user.setApplicationname("uat");
			user.setVersion("2");

			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost httpPost = new HttpPost();
			httpPost.setURI(URI.create("http://sg-azr-tom01-prod.centralindia.cloudapp.azure.com/netcore-api/login"));
			HttpResponse response;
			String apiOutput;
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

			httpPost.setEntity(new ByteArrayEntity(jsonInString.toString().getBytes("UTF8")));
			httpPost.setHeader("Content-type", "application/json");
			System.out.println(jsonInString);
			response = httpClient.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			apiOutput = EntityUtils.toString(httpEntity);
			loginResponse = new ObjectMapper().readValue(apiOutput, LoginResponse.class);
			System.out.println(apiOutput);
			return loginResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return loginResponse;
		}

	}
	
	public EmdmUserDetails authoriseFromEMDM(String user) throws Exception {
		RestRequester restRequester = getRestRequesterForEMDM(retreiveEMDMAuthToken());
        restRequester.getBodyContentMap().put("Email", user + Constants.EMAIL_SUFFIX);
        return parseEmdmUserDetail(getRawJson(restRequester));	
	}
	
	
	private String retreiveEMDMAuthToken() throws Exception {
        String token;
        RestRequester restRequester = context.getBean(RestRequester.class);
        restRequester.setUrl(Constants.EMDM_AUTHENTICATE_API_URL);
        restRequester.setRequestType(RequestType.POST);
        restRequester.getBodyContentMap().put("username",
               Constants.EMDM_AUTHENTICATE_USERNAME);
        restRequester.getBodyContentMap().put("password",
                Constants.EMDM_AUTHENTICATE_PASSWORD);
        HttpResponse response = restRequester.sendRequest();
        if ((response != null) && ((response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
                && response.containsHeader("token"))) {
            Header[] tokenHeader = response.getHeaders("token");
            String tokenString = tokenHeader[0].toString();
            token = tokenString.substring("Token:".length(), tokenString.length());
            return token;
        } else {
            throw new Exception("Failed to Retrive Auth Token from EMDM");
        }
    }
	
	private RestRequester getRestRequesterForEMDM(String token) {
        RestRequester restRequester = context.getBean(RestRequester.class);
        restRequester.setUrl(Constants.EMDM_USER_DETAIL_API_URL);
        restRequester.setRequestType(RequestType.POST);
        restRequester.getHeaderContentMap().put("Token", token);
        return restRequester;
    }
	 public EmdmUserDetails getEMDMUserByEmailId(String user) throws Exception {
	        RestRequester restRequester = getRestRequesterForEMDM(retreiveEMDMAuthToken());
	        restRequester.getBodyContentMap().put("Email", user + Constants.EMAIL_SUFFIX);
	        return parseEmdmUserDetail(getRawJson(restRequester));
	 }
	 private EmdmUserDetails parseEmdmUserDetail(String rawJson) throws Exception {
	        EMDMUserDetailsDto emdmUserDetailDto = null;
	        try {
	            ObjectMapper objectMapper = new ObjectMapper();
	            emdmUserDetailDto = objectMapper.readValue(rawJson, EMDMUserDetailsDto.class);
	        } catch (IOException e) {
	           
	        }
	        if (emdmUserDetailDto.getStatusCode() == 2001) {
	            List<EmdmUserDetails> userDetails = emdmUserDetailDto.getData();
	            if (!userDetails.isEmpty()) {
	                EmdmUserDetails emdmUserDetail = userDetails.get(0);
	                emdmUserDetail.setEmail("\"" + emdmUserDetail.getEmail().toLowerCase() + "\"");
	              
	                return emdmUserDetail;
	            }
	        } else {
	            throw new Exception("User could not be located in emdm server");
	        }
			return null;
	    }
	 private String getRawJson(RestRequester restRequester) throws UnsupportedOperationException, IOException {
	        String emdmRawJson = null;
	        HttpResponse response = restRequester.sendRequest();
	        if (response != null) {
	            ObjectMapper objectMapper = new ObjectMapper();
	            emdmRawJson = objectMapper.readValue(response.getEntity().getContent(), String.class);
	            return emdmRawJson;
	        }
	        return emdmRawJson;
	    }

}
