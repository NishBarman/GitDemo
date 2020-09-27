package E2E.Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;

public class validateNavBar extends Base{

	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@Test
	public void BarValidation() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		
		LandingPage l= new LandingPage(driver);
		Assert.assertTrue(l.getNavigation().isDisplayed());
		log.info("Navigation Bar is Displayed");
		Assert.assertFalse(false);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	}


