package restAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo1_GET_request {
	
	/*
	 * given()
	 * 			set cookies,add auth,add param,set headers info etc
	 * 			All pre requsites
	 * When()
	 * 		get,post,put,delete,options (All the requests will be placed here)
	 * 
	 * Then()
	 * 			Validations
	 * 			Validation status code,extract response,extract headers cookies & response body
	 */
	
	//http://jsonplaceholder.typicode.com/posts/1
	
	@Test(priority=1)
	public void getWeatherDetails()
	{
		given()
		.when()
				.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
		.then()
		
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.assertThat().body("City", equalTo("Hyderabad"))
				.header("Content-Type", "application/json");
	}

}
