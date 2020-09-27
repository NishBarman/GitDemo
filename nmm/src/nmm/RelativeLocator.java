package nmm;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocator {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox =driver.findElement(By.xpath("//input[@name='name']"));
        System.out.println(driver.findElement(withTagName("label").above(nameEditBox)).getText());
		

	}

	private static By withTagname(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
