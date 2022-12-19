package com.learnautomation.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandleAuth 
{

	@Test
	public void testAuth()
	{
		
		Response resp=RestAssured.given()
		.auth()
		.basic("admin", "admin")
		.get("https://the-internet.herokuapp.com/digest_auth");
		
		System.out.println(resp.statusCode());
		
		Assert.assertEquals(resp.statusCode(), 200);
		
		
	}
	
	
	@Test
	public void testAuth1()
	{
		
		Response resp=RestAssured.given()
		.auth()
		.basic("admin1", "admin1")
		.get("https://the-internet.herokuapp.com/digest_auth");
		
		System.out.println(resp.statusCode());
		
		Assert.assertEquals(resp.statusCode(), 401);
		
		
	}
	
}
