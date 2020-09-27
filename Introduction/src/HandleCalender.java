import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCalender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		int i = 0;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		Thread.sleep(9000);
		driver.findElement(By.id("travel_date")).click();
		//WebElement month = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"));

		//while (!month.getText().contains("October 2020"))
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("December 2020"))
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
			//System.out.println(month.getText());
		}
		int count = driver.findElements(By.cssSelector("td[class*='day']")).size();

		for (i=0;i<count;i++)
         {
        String text = driver.findElements(By.xpath("//td[@class='day']")).get(i).getText();
        if (text.equalsIgnoreCase("1"))
        {
        // driver.findElements(By.cssSelector("td[class*='day']")).get(i).click();
         driver.findElements(By.xpath("//td[@class='day']")).get(i).click();
         System.out.println(text);
          break;

			}
		}

	}

}
