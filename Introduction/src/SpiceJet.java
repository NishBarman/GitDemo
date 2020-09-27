import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SpiceJet {

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
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("https://www.spicejet.com/");
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
			;
		{
			System.out.println("its enabled");
		}
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		driver.findElement(By.xpath("//a[@value='AMD']")).click();

		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();

		driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();

		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();

		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();

		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[2]/td[1]/a")).click();

		driver.findElement(By.id("divpaxinfo")).click();

		Select t = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		t.selectByIndex(4);

		Select u = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		u.selectByValue("2");

		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByVisibleText("INR");
		Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());

		driver.findElement(By.xpath("//input[@value='Search']")).click();

	}

}
