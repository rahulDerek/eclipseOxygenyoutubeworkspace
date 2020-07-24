package restAssuredTests;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import groovy.util.logging.Log;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class Demo6_BasicValidations_XML {
	
	//http://www.thomas-bayer.com/sqlrest/CUSTOMER/15
	
	//@Test(priority=0)
	public void singleContentCheck()
	{
		RestAssured.baseURI="http://www.thomas-bayer.com";
		RestAssured.basePath="/sqlrest/CUSTOMER/15";
		
		
		given()
		
		.when()
			.get()
		.then()
			.statusCode(200)
			.body("CUSTOMER.ID",equalTo("15"))
			.log().all();
		
		
	}
	
	//Multiple Content Check
//	@Test(priority=1)
	public void multipleContentCheck()
	{
		RestAssured.baseURI="http://www.thomas-bayer.com";
		RestAssured.basePath="/sqlrest/CUSTOMER/15";
		
		
		given()
		
		.when()
			.get()
		.then()
			.statusCode(200)
			.body("CUSTOMER.ID",equalTo("15"))
			.body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
			.body("CUSTOMER.LASTNAME",equalTo("Clancy"))
			.body("CUSTOMER.STREET",equalTo("319 Upland Pl."))
			.body("CUSTOMER.CITY",equalTo("Seattle"));
			
		
		
	}
	
	//Verifying xml response in single go
	//	@Test(priority=2)
		public void multipleContentCheckInOneGo()
		{
			RestAssured.baseURI="http://www.thomas-bayer.com";
			RestAssured.basePath="/sqlrest/CUSTOMER/15";
			
			
			given()
			
			.when()
				.get()
			.then()
				.statusCode(200)
				.body("CUSTOMER.text()",equalTo("15BillClancy319 Upland Pl.Seattle"))
				.log().all();
				
			
			
		}
	
		//verifying data using Xpath1
		//@Test(priority=3)
		public void testUsingXpath1()
		{
			RestAssured.baseURI="http://www.thomas-bayer.com";
			RestAssured.basePath="/sqlrest/CUSTOMER/15";
			
			
			given()
			
			.when()
				.get()
			.then()
				.statusCode(200)
			//	.body("CUSTOMER.text()",equalTo("15BillClancy319 Upland Pl.Seattle"))
				.body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")));

		}
	
		
		//verifying values in the resposne using xpath
		
		
		@Test(priority=4)
		public void testUsingXpath2()
		{
			RestAssured.baseURI="http://www.thomas-bayer.com";
			RestAssured.basePath="/sqlrest/INVOICE";
			
			
			given()
			
			.when()
				.get()
			.then()
				.statusCode(200)
			
				.body(hasXPath("//INVOICE[text()='30']"))
				.log().all();

		}
	
	
	
	

}
