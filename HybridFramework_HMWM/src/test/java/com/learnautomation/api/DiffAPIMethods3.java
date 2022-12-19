package com.learnautomation.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DiffAPIMethods3 {

	
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
		tokenValue=given()
				.log()
				.all()
		.contentType(ContentType.JSON)
		.body("{\"username\" : \"admin\",\"password\" : \"password123\"}")
		.post("https://restful-booker.herokuapp.com/auth").jsonPath().get("token");
		
		Assert.assertNotNull(tokenValue);
	}
	
	@Test(priority=2,dependsOnMethods="createToken")
	public void getBookingID()
	{
	  
		List<String> allBookings=get("https://restful-booker.herokuapp.com/booking").jsonPath().getList("bookingid");
		
		System.out.println(allBookings);
		
		int lastIndex=allBookings.size()-1;
		
		lastBookingId=String.valueOf(allBookings.get(lastIndex));
		
		Assert.assertNotNull(lastBookingId);
		
	}
	
	
	@Test(priority=3,dependsOnMethods="getBookingID")
	public void deleteBooking()
	{
		Response resp=given()
				.log()
				.all()
			.contentType(ContentType.JSON)
			.cookie("token",tokenValue)
			.delete("https://restful-booker.herokuapp.com/booking/"+lastBookingId);
		
		Assert.assertEquals(resp.statusCode(), 201);
	}
	
}
