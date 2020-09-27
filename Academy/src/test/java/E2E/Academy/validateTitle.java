package E2E.Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import pageObject.LandingPage;

public class validateTitle extends Base{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());


		@Test
		public void TitleValidation() throws IOException
		{
			driver=initializeDriver();
			log.info("Driver is initialized");
			driver.get(prop.getProperty("url"));
			log.info("Navigated to homepage");

			
			LandingPage l= new LandingPage(driver);
			
			Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
			log.info("Text validated successfully");

		}
		@AfterTest
		public void teardown()
		{
			driver.close();
		}
		
		
		}
		


