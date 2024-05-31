package api.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.UserPayload;
import io.restassured.response.Response;

public class Usertestcase {
	
	Faker faker;
	UserPayload userpaylods;
	
	@BeforeClass
	public void setUp() {
		faker = new Faker();
		userpaylods = new UserPayload();
		userpaylods.setId(faker.idNumber().hashCode());
		userpaylods.setUsername(faker.name().username());
		userpaylods.setFirstname(faker.name().firstName());
		userpaylods.setLastname(faker.name().lastName());
		userpaylods.setEmail(faker.internet().safeEmailAddress());
		userpaylods.setPassword(faker.internet().password(5,10));
		userpaylods.setPhone(faker.phoneNumber().cellPhone());
		
		
	}
	
	@Test(priority = 1)
	public void testpostUSer() {
		Response response = UserEndPoints.userCreate(userpaylods);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority = 2)
	public void testGetUSer() {
		Response response = UserEndPoints.readUser(this.userpaylods.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}

}
