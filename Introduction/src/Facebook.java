import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Create Driver object for chrome Browser

		/*
		 * Class name- ChromeDriver,
		 * 
		 * X driver=new X();
		 */
		// invoke .exe file first
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110");

		driver.findElement(By.id("email")).sendKeys("helo");

		driver.findElement(By.id("pass")).sendKeys("mudaseer");
		driver.findElement(By.id("loginbutton")).click();

		WebElement text = driver.findElement(By.xpath("//*[@id='globalContainer']/div[3]/div/div/div]"));

		System.out.println(text.getText());
	}

}
