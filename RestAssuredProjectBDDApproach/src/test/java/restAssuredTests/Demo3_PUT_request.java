package restAssuredTests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class Demo3_PUT_request {
	
	public static HashMap map = new HashMap();
	
		String empName	= RestUtils.getEmployeeName();
		
		String empSalary= RestUtils.getEmployeeSalary();
		
		String empAge =RestUtils.getEmployeeAge();
		
		int emp_id =16;
	
	
	@BeforeClass
	public void postData()
	{
		map.put("employee_name", empName);
		map.put("employee_salary",empSalary);
		map.put("employee_age",empAge);
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath ="/update/"+emp_id;
		
	}
	
	@Test
	public void testPut()
	{
		given()
			.log().all()
			.contentType("application/json")
			.body(map)
		.when()
				.log().all().put()
		.then()
		
				.log().all()
				.statusCode(200);
		
	}

}
