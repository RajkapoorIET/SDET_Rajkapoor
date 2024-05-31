package com.testcase;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;

public class FirstTestcase {
	int id;
	
	
	//@Test(priority = 1)
	public void getusers() {
		
		when()
		   .get("https://restful-booker.herokuapp.com/booking/1365")
		   
		 .then()
		    .statusCode(200)
		   // .body("firstname",equalTo("John"))
		    //.body("bookingdates.checkin", equalTo("2018-01-01"))
		    //.body("bookingdates.checkout", equalTo("2019-01-01"))
		    .log().all();
		
	}
	
  @SuppressWarnings("unchecked")
  @Test(priority = 2)
  public void createBooking() {
	  
	  HashMap data  = new HashMap();
		  
	  data.put("firstname", "adada");
	  data.put("lastname", "land");
	  data.put("totalprice", 11311);
	  data.put("depositpaid", true);
	  Map bookingdates = new HashMap();
	  bookingdates.put("checkin", "2024-03-06");
	  bookingdates.put("checkout", "2024-03-08");
	  data.put("bookingdates", bookingdates);
	  data.put("additionalneeds" ,"Breakfast");
	  
	 id =given()
	   .contentType("application/json")
	   .body(data)
	  .when()
	    .post("https://restful-booker.herokuapp.com/booking")
	    .jsonPath().getInt("bookingid");
	    
	  //.then()
	    //  .statusCode(200)
	      //.body("booking.firstname", equalTo("hifgd"))
	      //.body("booking.bookingdates.checkin", equalTo("2024-03-01"))
	    //  .log().all();
	      
	  System.out.println(id);
  }
  
  @Test(priority = 3)
  public void updateBooking() {
	  HashMap data  = new HashMap();
	  
	  data.put("firstname", "sdsdsdsdsdssdsdsd");
	  data.put("lastname", "land");
	  data.put("totalprice", 344343);
	  data.put("depositpaid", true);
	  Map bookingdates = new HashMap();
	  bookingdates.put("checkin", "2024-06-06");
	  bookingdates.put("checkout", "2024-05-08");
	  data.put("bookingdates", bookingdates);
	  data.put("additionalneeds" ,"Breakfast");
	  Header authorization = new Header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
	  given()
	    .contentType("application/json; charset=utf-8")
	    .accept("application/json")
	    //.cookie("_ga=GA1.1.1103943481.1709143809; _ga_2Q48X98CJ6=GS1.1.1709277574.3.1.1709279342.0.0.0")
	    .header(authorization)
	    .body(data)
	  .when()
	    .put("https://restful-booker.herokuapp.com/booking/"+id)
	  .then()
	   .statusCode(200)
	   .log().all();
	  //getusers();
  }
  @Test(priority = 4)
  public void partialupdate() {
	  
      HashMap data  = new HashMap();
	  
	  data.put("firstname", "after uodate");
	  data.put("lastname", "updateLAstname");
	  
	  Header authorization = new Header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
	  given()
	    .contentType("application/json; charset=utf-8")
	    .accept("application/json")
	    //.cookie("_ga=GA1.1.1103943481.1709143809; _ga_2Q48X98CJ6=GS1.1.1709277574.3.1.1709279342.0.0.0")
	    .header(authorization)
	    .body(data)
	  .when()
	    .patch("https://restful-booker.herokuapp.com/booking/"+id)
	  .then()
	   .statusCode(200)
	   .log().all();
  }
  
  @Test(priority = 5)
  public void deleteBooking() {
	  Header authorization = new Header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
	  given()
	    .contentType("application/json; charset=utf-8")
	    .accept("application/json")
	    .header(authorization)
	  .when()
	   .delete("https://restful-booker.herokuapp.com/booking/"+id)
	    //.dele
	  .then()
	   .statusCode(201)
	   .log().all();
	    
  }

}
