package com.learnautomation.api;

import static io.restassured.RestAssured.get;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SecondAPITest {
	
	
	@Test(enabled=false)
	public void testJSON()
	{
		
		Response resp=get("http://jsonplaceholder.typicode.com/users");
		
		JsonPath json=resp.jsonPath();
		
		List<String> respList=json.getList("$");
		
		System.out.println(respList.size());
		
	}
	
	@Test(enabled=false)
	public void testJSON1()
	{
		
		Response resp=get("http://jsonplaceholder.typicode.com/users");
		
		JsonPath json=resp.jsonPath();
		
		System.out.println(json.getString("username"));
	
		System.out.println(json.getString("username[1]"));
		
		List<String> allUsername=json.getList("username");
		
		System.out.println(allUsername.get(4));
		
		List<String> allNames=json.getList("name");
		
		boolean userStatus=false;
		
		for(String name:allNames)
		{
			System.out.println(name);
			if(name.contains("Nicholas"))
			{
				userStatus=true;
				break;
			}
		}
		
		Assert.assertTrue(userStatus);
		
	}

	// frequently asked
	@Test
	public void testJSON2()
	{
		Response resp=get("http://jsonplaceholder.typicode.com/users");
		
		JsonPath json=resp.jsonPath();
		
		Map<String, String> data=json.getMap("company[0]");
		
		System.out.println(data.get("name"));
	
		List<Map<String, String>> myCompany=json.getList("company");
		
		// frequently asked
		String name=myCompany.get(myCompany.size()-1).get("name");
		
		System.out.println(name);
		
		Assert.assertTrue(name.contains("Hoeger"));
	}
	

}
