package serialization_DeSerialization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class StudentAPIWithoutSerialization {

	HashMap map =new HashMap();
	
	
	//@Test(priority=1)
	public void createStudent()
	{
			
		/*
		{
			"firstName":"Oscar",
			"lastName":"Barclay",
			"email":"non.ante.bibendum@risusDonecegestas.edu",
			"programme":"Mechanical Engineering",
			"courses":
					["Machine Element Design","Engineering Analysis I",
					"Calculus & Linear Algebra I "]}*/
		
		RestAssured.baseURI ="http://localhost:8085";
		
		RestAssured.basePath="/student";
		
		map.put("firstName","Raghu");
		map.put("lastName", "Raman");
		map.put("email", "raghu.ramam@kmail.com");
		map.put("programme", "ArtificalIntelligence");
		
		List<String> courseList = new ArrayList<String>();
		
		courseList.add("Art101");
		courseList.add("ArI102");
		map.put("courses", courseList);
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
		
			.post()
		.then()
			.statusCode(201)
			.assertThat()
			.body("msg", equalTo("Student added"))
			.log().all();
		
	}
	
	@Test(priority=2)
	public void getStudentInformation()
	{
		RestAssured.baseURI ="http://localhost:8085";
		
		RestAssured.basePath="/student/101";
		given().
		
		when()
			.get()
		.then()
		
			.statusCode(200)
			.assertThat()
			.body("id", equalTo(101))
			.log().all();
		
				
		
		
	}
}
