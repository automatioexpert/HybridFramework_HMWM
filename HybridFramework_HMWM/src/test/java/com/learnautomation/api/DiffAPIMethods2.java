package com.learnautomation.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DiffAPIMethods2 {

	
	/*
	 *  	2xx- Success
	 *  	3xx- Redirection
	 * 		4xx- User issue	
	 *      5xx- Server issue
	 */
	
	@Test
	public void testPost()
	{
	
		String tokenValue=given()
				.log()
				.all()
		.contentType(ContentType.JSON)
		.body("{\r\n" + 
				"    \"username\" : \"admin\",\r\n" + 
				"    \"password\" : \"password123\"\r\n" + 
				"}")
		.post("https://restful-booker.herokuapp.com/auth").jsonPath().get("token");
		
		System.out.println(tokenValue);
		
		List<String> allBookings=get("https://restful-booker.herokuapp.com/booking").jsonPath().getList("bookingid");
		
		System.out.println(allBookings);
		
		int lastIndex=allBookings.size()-1;
		
		String lastBookingId=String.valueOf(allBookings.get(lastIndex));
		
		System.out.println(lastBookingId);
		
		
		Response resp=given()
				.log()
				.all()
			.contentType(ContentType.JSON)
			.cookie("token",tokenValue)
			.delete("https://restful-booker.herokuapp.com/booking/"+lastBookingId);
		
		Assert.assertEquals(resp.statusCode(), 201);
		
		System.out.println(resp.asPrettyString());

		System.out.println(resp.statusCode());
		
	}
	
}
