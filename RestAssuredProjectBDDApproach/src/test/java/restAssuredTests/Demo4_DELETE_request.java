package restAssuredTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class Demo4_DELETE_request {
	
	
	@Test
	public void deleteEmployeeRecord()
	{
	
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/20";
		
		//The Response is stored in response variable
		//But it is in json format
		Response response = 
				
				given()
		
				.when()
					.delete()
				.then()
			
					.statusCode(200)
					.statusLine("HTTP/1.1 200 OK")
					.log().all()
					.extract().response();
		
		//we need to convert to String format
			String resp	= response.asString();
			
			System.out.println("The response of the delete is "+resp);
			
			Assert.assertEquals(resp.contains("Successfully! deleted Records"),true);
		
	}

}
