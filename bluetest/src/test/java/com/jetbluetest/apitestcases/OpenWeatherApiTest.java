package com.jetbluetest.apitestcases;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class OpenWeatherApiTest{  
	
	
	
	//@Test(priority=1)
	public void verifyPostWithoutKey(){
		
		//RestAssured.basePath= "http://api.openweathermap.org/data/3.0/stations";
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("external_id", "SF_TEST001");
		requestParams.put("name", "San Francisco Test Station");
		requestParams.put("latitude", 37.76);
		requestParams.put("longitude", -122.43);
		requestParams.put("altitude", 150);
		
		Response res= RestAssured
				.given()
				.contentType("application/json")
				.body(requestParams)
				.when()
				.post("http://api.openweathermap.org/data/3.0/stations");
		
			Assert.assertEquals(res.getStatusCode(),401);
			Assert.assertEquals(res.jsonPath().get("message"),"Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.");	
				
	}
	
	//@Test(priority=2)
	public void verifyPostWithKey(){
		
		//RestAssured.basePath= "http://api.openweathermap.org/data/3.0/stations";
		
		JSONObject requestParams1 = new JSONObject();
		requestParams1.put("external_id", "DEMO_TEST001");
		requestParams1.put("name", "Interview Station1");
		requestParams1.put("latitude", 33.33);
		requestParams1.put("longitude", -111.43);
		requestParams1.put("altitude", 444 );
		
		JSONObject requestParams2 = new JSONObject();
		requestParams2.put("external_id", "Interview1 ");
		requestParams2.put("name", "Interview Station2");
		requestParams2.put("latitude", 33.44);
		requestParams2.put("longitude",-12.44);
		requestParams2.put("altitude", 444 );
		
		Response res= RestAssured
				.given()
				.contentType("application/json")
				.body(requestParams1)
				.and()
				.body(requestParams2)
				.when()
				.post("http://api.openweathermap.org/data/3.0/stations?id=testuser1&appid=56c6bb18a491cbea51ddb5b6f577e694");
		
			Assert.assertEquals(res.getStatusCode(),201);				
	}
	
	@Test(priority=3)
	public void verifyGetWithID(){
		
		String id1="601081fb09e7430001b9d6c5";
		String id2="601082f009e7430001b9d6c6";
		RestAssured.baseURI= "http://api.openweathermap.org";
		RestAssured.basePath= "/data/3.0/stations/601081fb09e7430001b9d6c5";
		
		Response res1= RestAssured
				.given()
				.param("id", "testuser1")
				.param("appid", "56c6bb18a491cbea51ddb5b6f577e694")
				.when()
				.get();
		
		//System.out.println(res1.jsonPath().get("external_id").toString());
		
			Assert.assertEquals(res1.jsonPath().get("external_id").toString(),"DEMO_TEST001");
			Assert.assertEquals(res1.jsonPath().get("name").toString(),"Interview Station1");
			Assert.assertEquals(res1.jsonPath().get("latitude").toString(),"33.33");
			Assert.assertEquals(res1.jsonPath().get("longitude").toString(),-111.43);
			Assert.assertEquals(res1.jsonPath().get("altitude").toString(),444);
			
		Response res2= RestAssured
					.given()				
					.when()
					.get("http://api.openweathermap.org/data/3.0/stations/id2?i{d=testuser1&appid=56c6bb18a491cbea51ddb5b6f577e694");
			
				Assert.assertEquals(res2.jsonPath().get("external_id").toString(),"Interview1");
				Assert.assertEquals(res2.jsonPath().get("name").toString(),"Interview Station2");
				Assert.assertEquals(res2.jsonPath().get("latitude").toString(),33.44);
				Assert.assertEquals(res2.jsonPath().get("longitude").toString(),-12.44);
				Assert.assertEquals(res2.jsonPath().get("altitude").toString(),444);
			
				
	}
	
	@Test(priority=4)
	public void verifyDeleteWithID(){
		
		
		RestAssured.baseURI= "http://api.openweathermap.org";
		RestAssured.basePath= "/data/3.0/stations/601081fb09e7430001b9d6c5";
		
		Response res1= RestAssured
				.given()
				.param("id", "testuser1")
				.param("appid", "56c6bb18a491cbea51ddb5b6f577e694")
				.when()
				.delete();
		
		//System.out.println(res1.jsonPath().get("external_id").toString());
		
			Assert.assertEquals(res1.jsonPath().get("external_id").toString(),"DEMO_TEST001");
			Assert.assertEquals(res1.jsonPath().get("name").toString(),"Interview Station1");
			Assert.assertEquals(res1.jsonPath().get("latitude").toString(),"33.33");
			Assert.assertEquals(res1.jsonPath().get("longitude").toString(),-111.43);
			Assert.assertEquals(res1.jsonPath().get("altitude").toString(),444);
			
		Response res2= RestAssured
					.given()				
					.when()
					.get("http://api.openweathermap.org/data/3.0/stations/id2?i{d=testuser1&appid=56c6bb18a491cbea51ddb5b6f577e694");
			
		Assert.assertEquals(res1.getStatusCode(),204);	
		Assert.assertEquals(res2.getStatusCode(),204);	
			
				
	}
	
	@Test(priority=5)
	public void verifyDeleteWithID404(){
		
		
		RestAssured.baseURI= "http://api.openweathermap.org";
		RestAssured.basePath= "/data/3.0/stations/601081fb09e7430001b9d6c5";
		
		Response res1= RestAssured
				.given()
				.param("id", "testuser1")
				.param("appid", "56c6bb18a491cbea51ddb5b6f577e694")
				.when()
				.delete();
		
		//System.out.println(res1.jsonPath().get("external_id").toString());
		
			Assert.assertEquals(res1.jsonPath().get("external_id").toString(),"DEMO_TEST001");
			Assert.assertEquals(res1.jsonPath().get("name").toString(),"Interview Station1");
			Assert.assertEquals(res1.jsonPath().get("latitude").toString(),"33.33");
			Assert.assertEquals(res1.jsonPath().get("longitude").toString(),-111.43);
			Assert.assertEquals(res1.jsonPath().get("altitude").toString(),444);
			
		Response res2= RestAssured
					.given()				
					.when()
					.get("http://api.openweathermap.org/data/3.0/stations/id2?i{d=testuser1&appid=56c6bb18a491cbea51ddb5b6f577e694");
			
		Assert.assertEquals(res1.getStatusCode(),404);	
		Assert.assertEquals(res2.getStatusCode(),404);	
			
				
	}


	
	
}
