package com.learnautomation.api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandlOAuth 
{

	@Test
	public void testAuth()
	{
		
		Response resp=RestAssured.given()
				.log().all()
				.auth().oauth2("AAAAAAAAAAAAAAAAAAAAAHzA6gAAAAAALs5Nf%2FVsvjH8JPr4lCCYhoQeACY%3DxIHmK1FQfv5WtokpAlgUb2viYBeFEEAmv9oCbDm6Zc8kmVpZo5")
		.get("https://api.twitter.com/2/users/by?usernames=MukeshOtwani");
	
		System.out.println(resp.statusCode());
		
		System.out.println(resp.asPrettyString());
		
	}
	

	
}
