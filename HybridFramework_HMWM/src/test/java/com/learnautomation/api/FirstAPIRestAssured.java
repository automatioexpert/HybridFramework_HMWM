package com.learnautomation.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class FirstAPIRestAssured {
	
	
	@Test
	public void getResponseCode()
	{
		Response resp=RestAssured.get("https://reqres.in/api/users");
		
		System.out.println(resp.statusCode());
		
		Assert.assertEquals(resp.statusCode(), 200);
		
	}
	
	@Test
	public void getResponseData()
	{
		Response resp=RestAssured.get("https://reqres.in/api/users");
		
		System.out.println(resp.contentType());
		
		//System.out.println(resp.body().asPrettyString());
		
		JsonPath json=resp.jsonPath();
		
		System.out.println(json.get("total"));
		
		System.out.println(json.get("data[0].last_name"));
		
		System.out.println(json.get("support.url"));
	}
	
	@Test
	public void testSite()
	{
		System.out.println(RestAssured.get("https://rest-assured.io/").statusCode());
	}

}
