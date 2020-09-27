import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	//selenium code-
				
						//Create Driver object for chrome Browser
						
						/* Class name- ChromeDriver,
						 
						 X driver=new X();*/
						//invoke .exe file first
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		String text="Nishant";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("[value='Alert']")).click();
		Thread.sleep(1500);
		System.out.println( driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1500);
		System.out.println( driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}

}
