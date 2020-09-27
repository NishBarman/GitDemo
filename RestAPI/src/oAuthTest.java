import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import POJO.API;
import POJO.GetCourse;
import POJO.WebAutomation;



public class oAuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] CourseTitles= {"Selenium Webdriver Java","Cypress","Protractor"};
	
		String accesstokenresponse=given().urlEncodingEnabled(false).queryParams("code","4%2F4QFcffdRlEdddj_H9D0bQ-FUZ2M7ptODq-m0pzkf9hXfyHUVXh1yuXJNLvARGLbcsFGSbUP1X45jwsoSyw78050")
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code").when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js=new JsonPath(accesstokenresponse);
		String acesstoken=js.getString("access_token");
		
		
		
		GetCourse gc=given().queryParam("access_token", acesstoken).expect().defaultParser(Parser.JSON)
				.when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		
		List<API> apiCourses=gc.getCourses().getApi();
		for (int i=0;i<apiCourses.size();i++)
		{
			if (apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
				System.out.println(apiCourses.get(i).getPrice());
			}
			
		}
		
		ArrayList<String> a=new ArrayList<String>();
		
		
		List<WebAutomation> WebAutomationCourses=gc.getCourses().getWebAutomation();
		for (int j=0;j<WebAutomationCourses.size();j++)
		{
			a.add(WebAutomationCourses.get(j).getCourseTitle());
			//System.out.println(WebAutomationCourses.get(j).getPrice());
		}
		List<String> expectedlist=Arrays.asList(CourseTitles);
		Assert.assertTrue(a.equals(expectedlist));
	}

}
