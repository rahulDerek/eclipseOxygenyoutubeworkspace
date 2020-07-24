package restAssuredTestsPractice;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import restAssuredTests.RestUtils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class Demo2_POSTRequest_pra {

	public static HashMap map = new HashMap();
	
	@BeforeClass
	public void postData()
	{
		
		/*map.put("title", "Raghav13");
		map.put("author", "Pal13");*/
		
		map.put("title", RestUtils.getTite());
		map.put("author", RestUtils.getFirstName());
		
		
		RestAssured.baseURI="http://localhost:3000";
		RestAssured.basePath="/posts";
		
	}
	
	@Test
	public void postData1() {
		
		Response res = given()
			.log().all()
			.contentType("application/json")
			.body(map)
			
		.when()
			.post()
		.then()
				.log().all()
				.statusCode(201)
				.contentType("application/json; charset=utf-8")
				.statusLine("HTTP/1.1 201 Created")
				.extract().response();
	
		String responseData =res.asString();
		
		System.out.println("The response data is "+responseData);
		
	}

}
