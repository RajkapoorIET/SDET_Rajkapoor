package com.testcase;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class TestCase3 {
	
	
	@Test
	public void getdata()
	{
		
		given()
		  .pathParam("dateCreated","1677157752289")
		.when()
		  .get("http://localhost:4000/integration")
		.then()
		  .log().all();
		
	}

}
