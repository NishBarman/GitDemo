package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgetPassword {
	
	public WebDriver driver;

	By Email=By.id("user_email");
	By instruction=By.xpath("//input[@value='Send Me Instruction']");
	
	
	public forgetPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public WebElement getEmail()
	{
		return driver.findElement(Email);
	}
	
	public WebElement sendInstructions()
	{
		return driver.findElement(instruction);
	}
}
