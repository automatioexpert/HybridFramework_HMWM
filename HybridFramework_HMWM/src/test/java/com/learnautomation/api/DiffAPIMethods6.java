package com.learnautomation.api;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DiffAPIMethods6 {

	
	/*
	 *  	2xx- Success
	 *  	3xx- Redirection
	 * 		4xx- User issue	
	 *      5xx- Server issue
	 */
	
	@Test
	public void testPost()
	{
		
		
		List<Map<String, Object>> totalBookings=new ArrayList<Map<String,Object>>();
		
		Map<String, Object> payload=new HashMap<String, Object>();
		payload.put("firstname", "Wakil");
		payload.put("lastname", "Khan");
		payload.put("totalprice", 123);
		payload.put("depositpaid",false);
		payload.put("additionalneeds", "dinner");
		
		Map<String, Object> dates=new LinkedHashMap<>();
		dates.put("checkin", "2021-05-02");
		dates.put("checkout", "2021-05-05");
		
		payload.put("bookingdates", dates);
		
		Map<String, Object> payload2=new HashMap<String, Object>();
		payload2.put("firstname", "Hasnath");
		payload2.put("lastname", "Khan");
		payload2.put("totalprice", 123);
		payload2.put("depositpaid",false);
		payload2.put("additionalneeds", "dinner");
		
		Map<String, Object> dates2=new LinkedHashMap<>();
		dates2.put("checkin", "2021-05-02");
		dates2.put("checkout", "2021-05-05");
		
		payload2.put("bookingdates", dates);
		
		
		Map<String, Object> payload3=new HashMap<String, Object>();
		payload3.put("firstname", "Mamun");
		payload3.put("lastname", "Khan");
		payload3.put("totalprice", 123);
		payload3.put("depositpaid",false);
		payload3.put("additionalneeds", "dinner");
		
		Map<String, Object> dates3=new LinkedHashMap<>();
		dates3.put("checkin", "2021-05-02");
		dates3.put("checkout", "2021-05-05");
		
		payload3.put("bookingdates", dates);
		
		
		totalBookings.add(payload);
		totalBookings.add(payload2);
		totalBookings.add(payload3);
		
	
		Response resp=given()
				.log()
				.all()
			.contentType(ContentType.JSON)
			.body(totalBookings)
			.post("https://restful-booker.herokuapp.com/booking");
		
		System.out.println(resp.getStatusCode());
		
		System.out.println(resp.asPrettyString());
		
		System.out.println(resp.jsonPath().get("bookingid"));
		
		System.out.println(resp.jsonPath().get("booking.bookingdates.checkout"));
		
		Assert.assertNotNull(resp.jsonPath().get("bookingid"));
		
		Assert.assertTrue(resp.jsonPath().get("bookingid")!=null);
		
		
	}
	
}
