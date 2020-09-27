import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggest {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/flights/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement popup = driver.findElement(By.cssSelector(".autopop__wrap.makeFlex.column.defaultCursor"));

		WebElement account = driver.findElement(By.xpath("//li[@data-cy='account']"));
        if (popup.isDisplayed()) {account.click();}
	
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("fromCity")).click();
		

		WebElement source = driver.findElement(By.xpath("//input[@placeholder='From']"));

		source.sendKeys("DEL");

         Thread.sleep(4000);
		source.sendKeys(Keys.ARROW_DOWN);

		source.sendKeys(Keys.ENTER);

// Enter text Bangalore to destination search

		WebElement destination = driver.findElement(By.xpath("//input[@placeholder='To']"));

		destination.sendKeys("CHE");
		Thread.sleep(4000);

		destination.sendKeys(Keys.ARROW_DOWN);

		destination.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

	}

}
