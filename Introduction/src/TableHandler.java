import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableHandler {

	public static void main(String[] args) throws InterruptedException {
		int sum=0;
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nnishu\\Documents\\My Docs\\Selenium\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/23254/eng-vs-ire-1st-odi-ireland-tour-of-england-2020");
		WebElement table = driver.findElement(By.xpath("(//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'])[1]"));
		//WebElement table=driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		int rowcount= table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
		int count=table.findElements(By.xpath("//div[@id='innings_1']//div[@class='cb-col cb-col-100 cb-scrd-itms']")).size();
		//int count=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
        
        for(int i=0;i<count-2;i++)
        {
        	//System.out.println(table.findElements(By.cssSelector("div[class='class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText());
        	String value=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
        	int valueinteger=Integer.parseInt(value);
        	sum=sum+valueinteger;
        }
        
        System.out.println(sum);
        String extras=driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
        int Extrasinteger=Integer.parseInt(extras);
        int TotalSum=sum=sum+Extrasinteger;
        System.out.println(TotalSum);
       //System.out.println(driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText());
       System.out.println(driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());
	}

}
