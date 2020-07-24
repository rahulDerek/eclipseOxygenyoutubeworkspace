package restAssuredTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


/*1.Status code
 * 2.verify log response
 * 3.verify single line content in response body
 * 4.Verify multiple contents in the response body
 * 5.Setting Parameters and headers
 * 
 * 
 * 
 * 
 * 
 */

public class Demo5_BasicValidations_JSON {
	

	
	//@Test(priority=0)
	public void testStatusCode()
	{
		
		RestAssured.baseURI="http://jsonplaceholder.typicode.com";
		
		RestAssured.basePath="/posts/2";
		
		Response resp = given()
		
		.when()
		
				.get()
				
		.then()
		
				.log().all().statusCode(200).extract().response();
		
		String respData = resp.asString();
		
		System.out.println("The response data is" +respData);
	}
	
	
	//JSON Finder
	//@Test(priority=1)
	public void testSingleContentInResponse()
	{
		RestAssured.baseURI ="http://restapi.demoqa.com";
		RestAssured.basePath="/utilities/weather/city/chennai";
		
		Response resp = given()
		
		.when()
				.get()
				
				
		.then()
		
			.statusCode(200)
			.body("City",equalTo("Chennai"))
			.extract().response();
		
		
		String responseCity = resp.asString();
		
		boolean ExpectedCity	=responseCity.contains("Chennai");
		
		System.out.println("The single line content is "+ExpectedCity);
		
		
	}
	
	//https://restcountries.eu/rest/v2/all
	
	//@Test
	public void multiContentCheck()
	{
		RestAssured.baseURI="https://restcountries.eu";
		RestAssured.basePath="/rest/v2/all";
		
		Response resp =given()
		.when()
		
				.get()
		.then()
		
			.body("name",hasItems("Afghanistan","India"))
			.extract().response();
		
		String responseItem = resp.asString();
		
		System.out.println("The responseItems is "+responseItem.contains("India"));
		
	
		
		
	}

	
	@Test
	public void settingParamAndHeaders()
	{
		RestAssured.baseURI="https://restcountries.eu";
		RestAssured.basePath="/rest/v2/all";
		
		given()
				.param("MyName", "hellobc")
				.header("NyJOB", "Scientist")
		.when()
		
				.get()
		.then()
		.body("name",hasItems("Afghanistan","India"))
			.log().all();
		
		
		
	
		
		
	}
}
