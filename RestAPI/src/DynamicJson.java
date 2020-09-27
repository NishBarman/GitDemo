import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {

    @Test
	public void addBook()
	{
		String response=RestAssured.baseURI="https://rahulshettyacademy.com";;
		given().header("Content-Type","application/json").body(payload.Addbook()).when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js=new JsonPath(response);
		String id=js.get("ID");
		System.out.println(id);
		
	}
}
