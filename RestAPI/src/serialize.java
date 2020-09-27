import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import POJO.Location;
import POJO.addPlace;

public class serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI="https://rahulshettyacademy.com/";

addPlace p=new addPlace();
p.setAccuracy(40);
p.setAddress("49, side layout, cohen 19");
p.setLanguage("English");
p.setName("Nishant");
p.setPhone_number("(+91) 703 893 3937");
p.setWebsite("http://google.com");
List<String> mylist=new ArrayList<String>();
mylist.add("shog park");
mylist.add("shoe");
p.setTypes(mylist);
Location loc=new Location();
loc.setLat(-48.383494);
loc.setLng(43.427362);

RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
.setContentType(ContentType.JSON).build();
p.setLocation(loc);

ResponseSpecification resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
RequestSpecification res=given().spec(req).body(p);
Response response=res.when().post("/maps/api/place/add/json").then().spec(resspec).extract().response();
	String responseString=response.asString();
	System.out.println(responseString);
		
	}

}
