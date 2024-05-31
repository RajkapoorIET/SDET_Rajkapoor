package api.endpoints;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Oauth2Authentication {
	
	private String secret = "EJa4H5ormBaRhmya5GUcsaJ3-e0D5zAa6kS14YCD11_nFCA4fC5cJLxHdCFwS9-3B03N7mu1caSgub7N";
   private String clienID = "AUCqsuxmgEVXThPpvoQ5nCNMX1RmA-bM3RSKHsK40k3X1lHkdREj0qUeT71PaUAAss-4ArPfbz0aK_tx";
    private String AccessToken;
    
    @Test
    public void oauth2Demo() {
    	
    	RequestSpecification requestSpec = RestAssured.given();
    	requestSpec.baseUri("https://api-m.sandbox.paypal.com");
    	requestSpec.basePath("/v1/oauth2/token");
    	
    	Response response = requestSpec.auth().preemptive().basic(clienID, secret).param("grant_type", "client_credentials").post();
    	//response.prettyPrint();
    	AccessToken = response.getBody().path("access_token");
    	System.out.println("Accesstoken :"+AccessToken);
    	
    }
    
}
