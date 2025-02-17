package com.sdetadda.allure;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostTest {
  @Test
  public void test2() {
	  Map<String, Object>map = new HashMap<String, Object>();
		
//		map.put("name", "Anshu");
//		map.put("job", "Tester");
//		
//		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		request.put("name", "Anshu");
		request.put("job", "Tester");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
  }
}
