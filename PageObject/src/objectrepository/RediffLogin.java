package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLogin {
	
	public RediffLogin(WebDriver driver)
	{
		this.driver=driver;
	}
	
	WebDriver driver;
	By username=By.id("login1");
	By password=By.id("password");
	By signin=By.name("proceed");
	By home=By.linkText("rediff.com");
	
public WebElement EmailId()
{
return driver.findElement(username);
}
public WebElement Password()
{
return driver.findElement(password);
}
public WebElement submit()
{
return driver.findElement(signin);
}
public WebElement Home()
{
return driver.findElement(home);
}
}
