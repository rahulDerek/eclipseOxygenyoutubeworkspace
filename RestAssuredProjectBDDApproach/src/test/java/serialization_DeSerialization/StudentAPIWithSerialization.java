package serialization_DeSerialization;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.*;

public class StudentAPIWithSerialization {


	//create the courses list
	//@Test
	public void createNewStudentSerialization()
	{

		RestAssured.baseURI ="http://localhost:8085";

		RestAssured.basePath="/student";
		List<String> courseList = new ArrayList<String>();

		courseList.add("Java");

		courseList.add("python");

		Student stu = new Student();

		stu.setFirstName("Kathir");
		stu.setLastName("valavan");
		stu.setProgramme("Engineering");
		stu.setEmail("kathir.v@remail.com");
		stu.setCourses(courseList);


		given()
			.contentType(ContentType.JSON)
			.body(stu)
		.when()
			.post()
		.then()
		
			.statusCode(201)
			.assertThat().body("msg", equalTo("Student added"))
			.log().all();
	}
	
	@Test(priority=2)
	public void getStudentRecordInformation()
	{
		RestAssured.baseURI ="http://localhost:8085";

		RestAssured.basePath="/student/102";
		
		Student s = get().as(Student.class);
		
		System.out.println("The student id is "+s.getStudentRecord());
		
		
	//   assert.assertEquals(s.getId(), 102);
	    
		
	}
}