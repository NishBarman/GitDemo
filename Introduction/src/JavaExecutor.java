import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).click();
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String script= "return document.getElementById(\"fromPlaceName\").value;";
		String text=(String) js.executeScript(script);
	
	
	while(!text.equalsIgnoreCase("BENGALURU"))
	{
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
		text=(String) js.executeScript(script);
		System.out.println(text);
		break;
	}
		
	}

}
