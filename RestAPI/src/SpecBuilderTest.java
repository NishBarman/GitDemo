import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import POJO.Location;
import POJO.addPlace;

public class SpecBuilderTest {

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

p.setLocation(loc);

Response res=given().queryParam("key", "qaclick123").body(p).when().post("maps/api/place/add/json").then().assertThat().statusCode(200).extract().response();
	String responseString=res.asString();
	System.out.println(responseString);
	
	}

}
