package restAssuredTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class Demo2_POST_request {
	
	public static HashMap map = new HashMap();
	
	
	@BeforeClass
	public void postData()
	{
		
		map.put("FirstName", RestUtils.getFirstName());
		map.put("LastName", RestUtils.getLastName());
		map.put("UserName", RestUtils.getUserName());
		map.put("Password", RestUtils.getPassword());
		map.put("Email", RestUtils.getEmail());
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		RestAssured.basePath ="/register";
	}
	
	@Test
	public void testPost()
	{
		
		given()
			.log().all().contentType("application/json")
			.body(map)
		.when()
		
			.post()
		.then()
			.log().all().statusCode(201)
			.and()
			.body("SuccessCode" , equalTo("OPERATION_SUCCESS"))
			.and()
			.body("Message", equalTo("Operation completed successfully"));
			
	}

}
