package com.testcase;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Testcase2 extends RnadonString{
	
	Response res2=null;
	Response res = null;
	String id = null;
	@Test(priority = 0)
	public void getTravelers() {
		
		res = given()
		.when()
		  .get("http://restapi.adequateshop.com/api/Customer");
		
		System.out.println(res.headers());
		String name = res.jsonPath().get("name").toString();
       //System.out.println(name);
         String[] namearr = name.split(",");
         
         Map<String, Integer> m =  new HashMap<String, Integer>();
             for(String s:namearr) {
            	 m.put(s, m.getOrDefault(s,0)+1);
             }
       System.out.println("Duplicates String name");
       for(Map.Entry<String, Integer> entry: m.entrySet()) {
    	   if(entry.getValue()>1) {
    		   System.out.println(entry.getKey());
    	   }
       }
       
       
		
	}
	
	@Test(priority = 1)
	   public void userRegistration() {
		  Map<String, String> JO =  new HashMap<String, String>();
		  JO.put("name", "abc");
		  JO.put("email", ""+RandomStringUtils.random(1)+"@gmail.com");
		  JO.put("password", "abc@1234");
		   
		   given()
		     .contentType("application/json")
		     .body(JO)
		    
		   .when()
		      .post("http://restapi.adequateshop.com/api/Account/Registration")
		   .then()
		   .statusCode(200)
		   .log().all();
	   }
	@Test(priority = 2)
	public void addCusotmer() {
		
		Map<String, String> JO =  new HashMap<String, String>();
		  JO.put("name", "ab1c");
		  JO.put("email", ""+RnadonString.randonNumbervalue()+"@gmail.com");
		  JO.put("password", "abc@1234");
		  JO.put("location", "IN");
		   
		  res2 = given()
		     .contentType("application/json")
		     .body(JO)
		    
		   .when()
		      .post("http://restapi.adequateshop.com/api/Customer");
		   
		 
		 id = res2.jsonPath().get("id").toString();
		 System.out.println(id);
		 System.out.println(res2.jsonPath().get("email").toString());
		 
	}
	
	@Test(priority = 3)
	public void getCustomer()
	{
		when()
		 .get("http://restapi.adequateshop.com/api/Customer/"+id)
		 
		.then()
		  .body("name", equalTo("ab1c"))
		  .body("location", equalTo("IN"));
		  
		
	}
	
  @Test(priority = 4)
  public void updateCustomerRecord() {
	  Map<String, String> JO =  new HashMap<String, String>();
	  JO.put("name", "ab123");
	  JO.put("email", ""+RnadonString.randonNumbervalue()+"@gmail.com");
	  JO.put("password", "abc@100234");
	  JO.put("location", "China");
	   
	  given()
	     .contentType("application/json")
	     .body(JO)
	  .when()
	    .put("http://restapi.adequateshop.com/api/Customer/"+id)
      .then()
      .log().all()
       .statusCode(200)
		  .body("name", equalTo("ab123"))
		  .body("location", equalTo("China"));
  }
  
  //@Test(priority = 5)
	public void getupdadetrecordforCustomer()
	{
		when()
		 .get("http://restapi.adequateshop.com/api/Customer/"+id)
		 
		.then()
		  .body("name", equalTo("ab123"))
		  .body("location", equalTo("China"));
		  
		
	}
}
