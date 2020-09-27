import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;


public class Basiscs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//given= all input
		//when- submit the API, resource, http method
		//then- validate response
	
		// add place
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Frontline house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"Frnch-IN\"\r\n" + 
				"}\r\n" + 
				"").when().post("maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().asString();
	System.out.println(response);
	JsonPath js=new JsonPath(response);
	String placeID=js.get("place_id");
	System.out.println(placeID);
	
	//update place
	
	String newaddress= "Summer Wlk, Africa";
	
	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
	body("{\r\n" + 
			"\"place_id\":\""+placeID+"\",\r\n" + 
			"\"address\":\""+newaddress+"\",\r\n" + 
			"\"key\":\"qaclick123\"\r\n" + 
			"}").when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
	.body("msg", equalTo("Address successfully updated"));
	
	// get place
	
	String getPlaceResponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeID).when().get("maps/api/place/get/json")
	.then().assertThat().statusCode(200).extract().asString();
	JsonPath js1=new JsonPath(getPlaceResponse);
	String actualaddress=js1.getString("address");
	System.out.println(actualaddress);
	Assert.assertEquals(actualaddress, newaddress);
	
	

	}

}
