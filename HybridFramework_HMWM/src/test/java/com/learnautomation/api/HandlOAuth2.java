package com.learnautomation.api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandlOAuth2 {

	@Test
	public void testAuth() {

		Response resp = RestAssured.given().log().all().auth()
				.oauth("rAmpf4IjzvnIWDB1mE5hQNwLZ", "FRmtng2lqea0d3BM2M1qaQvX1wOjMzhS6Wf3XxJTEYULlxiLOn",
						"327819018-S0lAgRp2WSF3pCoP1PWB8HNIMHMW8GZ6EIM1gqJ5",
						"TN6HYqQJFtoNP9vNZrlZXBBVvHaOQqfWx3Kt88FUmuTi3")
				.post("https://api.twitter.com/1.1/statuses/destroy/1398143295461621760.json");

		System.out.println(resp.statusCode());

		System.out.println(resp.asPrettyString());

		// System.out.println(resp.jsonPath().get("id"));

		// Assert.assertEquals(resp.statusCode(), 200);

	}

}
