package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	By Email=By.id("user_email");
	By password=By.id("user_password");
	By Login=By.xpath("//input[@type='submit']");
	By forgotPass=By.xpath("//a[contains(text(),'Forgot Password?')]");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(Email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement clickLogin()
	{
		return driver.findElement(Login);
	}

	public forgetPassword forgotPassword()
	{
		driver.findElement(forgotPass).click();
		return new forgetPassword(driver);
		
	}
}
