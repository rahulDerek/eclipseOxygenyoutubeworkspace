package restAssuredTestsPractice;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Demo1_GETRequest_Pra {
	
	
	@Test
	public void demo()
	{
	
	RestAssured.baseURI ="http://jsonplaceholder.typicode.com";
	
	RestAssured.basePath="/posts/1";
	

	given().
	
	when().
	
		get().
	then()
	
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
		.header("Content-Type", equalTo("application/json; charset=utf-8"))
		.log().all();

}
}
