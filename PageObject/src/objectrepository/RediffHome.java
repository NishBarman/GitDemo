package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHome {

		
		WebDriver driver;

		public RediffHome(WebDriver driver)
		{
			this.driver=driver;
		}
		
		By search=By.name("srchword");
		By srchbtn=By.xpath("//input[@type='submit']");
		
		public WebElement Search()
		{
		return driver.findElement(search);
		}
		public WebElement SearchButton()
		{
		return driver.findElement(srchbtn);
		}
}
