package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

public class validateTitle extends Base{

	@Test
	public void getTitle() throws IOException
	{
	driver=initializeDriver();
	driver.get("https://rahulshettyacademy.com/#/index");
	LandingPage l= new LandingPage(driver);
//Assert.assertEquals(l.gettitle().getText(), "Featured Courses");


	}
}

