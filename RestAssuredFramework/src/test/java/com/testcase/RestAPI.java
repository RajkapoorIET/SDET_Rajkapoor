package com.testcase;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class RestAPI {
	
	
	@Test
	public void restPublicAPI() {
		
		given()
		   
		   .header("Authorization", "Basic YW51cGFtYS5iYWNoY2hhQHNvZnR3YXJlYWcuY29tOkMhMHVkQzBudEAhbmVyUUAybzI2")
		   .contentType("application/json")
		   .accept("application/json")
		   
		.when()
		    .get("https://customqaaws.acmeco.cloud/integration/restv2/development/fl44bef96ead95ed3b98701f/CopiedRestAPI/test")
		    
		.then()
		  .statusCode(200)
		  .log().all();
		
	}

}
