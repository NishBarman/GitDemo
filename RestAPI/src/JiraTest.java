import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
RestAssured.baseURI="https://nishu-123.atlassian.net";

// Login

SessionFilter session=new SessionFilter();
String response=given().header("Content-Type","application/json").body("{ \"username\": \"nishbarman4u@gmail.com\", \r\n" + 
		"\"password\": \"Nish@135\" }").log().all().filter(session).when().post("/rest/auth/1/session").then().extract().response().asString();

		//given().pathParam("id", "10101").body("");
	}

}
