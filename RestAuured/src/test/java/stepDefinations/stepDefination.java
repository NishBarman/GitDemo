package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.addPlace;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefination extends Utils {
	 RequestSpecification res;
	 ResponseSpecification resspec;
	 Response response;
	 TestDataBuild data=new TestDataBuild();
	static String place_id;
	 @Given("Add place Payload with {string} {string} {string}")
	 public void add_place_payload_with(String name, String language, String address) throws IOException {
		  
		   res=given().spec(requestSpecification()).body(data.addPlacePayLoad(name, language, address));
	    }

	 @When("User calls {string} with {string} http request")
	 public void user_calls_with_http_request(String resource, String method) throws Throwable {
	    	
	    	APIResources resourceAPI=APIResources.valueOf(resource);
	    	System.out.println(resourceAPI.getResource());
	    	
	    	resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	    	
	    	if(method.equalsIgnoreCase("POST"))
	         response=res.when().post(resourceAPI.getResource());	
	    	else if(method.equalsIgnoreCase("GET"))
	    		response=res.when().post(resourceAPI.getResource());	
	    		
	    	
	    }

	    @Then("API call is success with status code {int}")
	    public void api_call_is_success_with_status_code(Integer int1) {
		    // Write code here that turns the phrase above into concrete actions
			assertEquals(response.getStatusCode(),200);
	    }

	    @And("{string} in response body is {string}")
	    public void something_in_response_body_is_something(String keyValue, String ExpectedValue) throws Throwable {
	        
	        	
	        assertEquals(getJsonPath(response,keyValue),ExpectedValue);
	        
	    }

	    @Then("verify place_Id created maps to {string} using {string}")
		public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws Throwable {
		
		   // requestSpec
	     place_id=getJsonPath(response,"place_id");
			 res=given().spec(requestSpecification()).queryParam("place_id",place_id);
			 user_calls_with_http_request(resource,"GET");
			  String actualName=getJsonPath(response,"name");
			  assertEquals(actualName,expectedName);
			  
		    
		}
			 
		    
	    @Given("DeletePlace Payload")
	    public void deleteplace_Payload() throws IOException {
	        // Write code here that turns the phrase above into concrete actions
	       
	    	res =given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	    }
	}

