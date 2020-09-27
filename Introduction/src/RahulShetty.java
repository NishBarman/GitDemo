import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RahulShetty {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Create Driver object for chrome Browser
		
				/* Class name- ChromeDriver,
				 
				 X driver=new X();*/
				//invoke .exe file first
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
				WebDriver driver= new ChromeDriver();
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
                driver.findElement(By.id("autosuggest")).sendKeys("au");
                Thread.sleep(3000);
				List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
                for(WebElement option: options)
                {
                	if(option.getText().equalsIgnoreCase("Macau"))
                	{
                		option.click();
                		break;
                	}
                }
                	
					}

}
