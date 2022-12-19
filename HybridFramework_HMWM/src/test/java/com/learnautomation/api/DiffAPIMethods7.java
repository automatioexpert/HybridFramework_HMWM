package com.learnautomation.api;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DiffAPIMethods7 {

	
	/*
	 *  	2xx- Success
	 *  	3xx- Redirection
	 * 		4xx- User issue	
	 *      5xx- Server issue
	 */
	
	@Test
	public void testPost()
	{
		
		File src=new File(System.getProperty("user.dir")+"/payload/Booking.json");
	

		Response resp=given()
				.log()
				.all()
			.contentType(ContentType.JSON)
			.body(src)
			.post("https://restful-booker.herokuapp.com/booking");
		
		System.out.println(resp.getStatusCode());
		
		System.out.println(resp.asPrettyString());
		
		System.out.println(resp.jsonPath().get("bookingid"));
		
		System.out.println(resp.jsonPath().get("booking.bookingdates.checkout"));
		
		Assert.assertNotNull(resp.jsonPath().get("bookingid"));
		
		Assert.assertTrue(resp.jsonPath().get("bookingid")!=null);
		
		
	}
	
}
