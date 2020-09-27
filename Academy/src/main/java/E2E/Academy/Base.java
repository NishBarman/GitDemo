package E2E.Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException 
	{
		 prop= new Properties();
		 //
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
     prop.load(fis);
     //String browsername=System.getProperty("browser");
    String browsername= prop.getProperty("browser");
    System.out.println(browsername);
    if(browsername.contains("chrome"))
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
    	ChromeOptions options=new ChromeOptions();
    	if(browsername.contains("headless"))
    	{
    		options.addArguments("headless");	
    	}
    	
		driver= new ChromeDriver(options);
    	//execute in chrome	
    }
    else if(browsername.equals("firefox")) 
    {
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\geckodriver.exe");
		driver= new FirefoxDriver();
    }
    else if(browsername.equals("IE"))
    {
    	//execute in IE
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
}

	public String getScreenShotPath(String testcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile= System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
