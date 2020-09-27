import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicit wait
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//explicit wait
		 WebDriverWait w= new WebDriverWait(driver,5);

		int j='0';
		String[] veggies = { "Cucumber", "Beans", "Pumpkin", "Raspberry", "Cashews" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) 
		{
			String[] items = products.get(i).getText().split("-");
			String formatitems = items[0].trim();

			// format name

			// convert array into arraylist

			List veggiesList = Arrays.asList(veggies);
			if (veggiesList.contains(formatitems)) 
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==veggies.length)
				{
					break;
				}
			}
		}
      driver.findElement(By.cssSelector("img[alt='Cart']")).click();
      driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
      w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promoCode")));
      driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
      driver.findElement(By.cssSelector("button.promoBtn")).click();
      
      w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
      System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

}
