import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='sortableTable']//tr/th[2]/b")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//table[@id='sortableTable']//tr/th[2]/b")).click();
		List<WebElement> FirstCollist=driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		
		ArrayList<String> originalList=new ArrayList<String>();
		for(int i=0;i<FirstCollist.size();i++)
		{	
			originalList.add(FirstCollist.get(i).getText());
			
		}
		
		ArrayList<String> CopiedList= new ArrayList<String>();
		for(int i=0;i<originalList.size();i++)
		{
			CopiedList.add(originalList.get(i));

		}
		
		System.out.println("*****sorted list******");
		Collections.sort(CopiedList);
		Collections.reverse(CopiedList);
		for (String s:CopiedList)
		{
			System.out.println(s);
		}
		System.out.println("*****original list******");
		for (String s:originalList)
		{
			System.out.println(s);
		}
		Assert.assertTrue(originalList.equals(CopiedList));
		
	}

}
