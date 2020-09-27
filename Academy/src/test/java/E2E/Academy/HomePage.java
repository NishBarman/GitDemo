package E2E.Academy;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.forgetPassword;

public class HomePage extends Base{
	public WebDriver driver;

	public static Logger log =LogManager.getLogger(Base.class.getName());

	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password,String Text) throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		
		LandingPage l= new LandingPage(driver);
		l.getLogin().click();
		LoginPage lo= new LoginPage(driver);
		lo.getEmail().sendKeys(Username);
		lo.getPassword().sendKeys(Password);
		//System.out.println(Text);
		log.info(Text);
		lo.clickLogin().click();
		forgetPassword fp=lo.forgotPassword();
		fp.getEmail().sendKeys("nishu@nn.com");
		fp.sendInstructions().click();
	}
	
	@AfterTest
    public void teardown()
	{
	driver.close();
   
    }
	
	@DataProvider
	public Object[][] getData()
	{
	//0th row
	Object[][] data= new Object[2][3];
	data[0][0]="nonrestricted@nn.com";
	data[0][1]="123456";
	data[0][2]="Non Restricted User";
	//1st row
	data[1][0]="restricted@nn.com";
	data[1][1]="789819";
	data[1][2]="Restricted User";
	
	return data;
	}
	
}
