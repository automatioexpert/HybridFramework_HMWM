package com.learnautomation.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffAPIMethods5 {

	
	/*
	 *  	2xx- Success
	 *  	3xx- Redirection
	 * 		4xx- User issue	
	 *      5xx- Server issue
	 */
	String tokenValue;
	String lastBookingId;
	
	@Test(priority=1)
	public void createToken() 
	{
		
		Map<String, String> details=new HashMap<>();
		details.put("username", "admin");
		details.put("password", "password123");
		
		tokenValue=given()
				.log()
				.all()
				.contentType(ContentType.JSON)
		.body(details)
		.post("https://restful-booker.herokuapp.com/auth").jsonPath().get("token");
		
		Assert.assertNotNull(tokenValue);
	}
	
	
}
