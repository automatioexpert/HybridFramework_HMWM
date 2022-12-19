package com.learnautomation.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DiffAPIMethods {

	
	/*
	 *  	2xx- Success
	 *  	3xx- Redirection
	 * 		4xx- User issue	
	 *      5xx- Server issue
	 */
	
	@Test
	public void testPost()
	{
	
		Response resp=given()
			.contentType(ContentType.JSON)
			.body("{\r\n" + 
					"    \"firstname\" : \"Jim\",\r\n" + 
					"    \"lastname\" : \"Brown\",\r\n" + 
					"    \"totalprice\" : 111,\r\n" + 
					"    \"depositpaid\" : true,\r\n" + 
					"    \"bookingdates\" : {\r\n" + 
					"        \"checkin\" : \"2018-01-01\",\r\n" + 
					"        \"checkout\" : \"2019-01-01\"\r\n" + 
					"    },\r\n" + 
					"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
					"}")
			.post("https://restful-booker.herokuapp.com/booking");
		
		System.out.println(resp.getStatusCode());
		
		System.out.println(resp.asPrettyString());
		
		System.out.println(resp.jsonPath().get("bookingid"));
		
		System.out.println(resp.jsonPath().get("booking.bookingdates.checkout"));
		
		Assert.assertNotNull(resp.jsonPath().get("bookingid"));
		
		Assert.assertTrue(resp.jsonPath().get("bookingid")!=null);
		
		
	}
	
}
