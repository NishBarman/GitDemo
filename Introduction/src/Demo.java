import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//selenium code-
		
				//Create Driver object for chrome Browser
				
				/* Class name- ChromeDriver,
				 
				 X driver=new X();*/
				//invoke .exe file first
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
				WebDriver driver= new ChromeDriver();
				driver.get("https://www.google.com/");
				System.out.println(driver.getTitle());
				
				driver.navigate().to("https://in.yahoo.com/?p=us");
				driver.navigate().back();
				driver.navigate().forward();
				driver.close();
	}

}
