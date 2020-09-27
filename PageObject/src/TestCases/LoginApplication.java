package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectrepository.RediffHome;
import objectrepository.RediffLogin;

public class LoginApplication {
	
	@Test
	public void login() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	RediffLogin rd=new RediffLogin(driver);
	rd.EmailId().sendKeys("user");
	rd.Password().sendKeys("123");
	rd.submit().click();
	rd.Home().click();
	RediffHome rh=new RediffHome(driver);
	Thread.sleep(6000);
	rh.Search().sendKeys("hello");
	rh.SearchButton().click();
	
	}
}
