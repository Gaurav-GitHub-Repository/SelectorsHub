package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import freemarker.log.Logger;

public class WebTable_Dashbaord {

	static WebDriver driver;
	
	static Logger log = Logger.getLogger(WebTable_Dashbaord.class.getName());
	
	Utility2 utility = new Utility2();
	
	public WebTable_Dashbaord(WebDriver driver)
	{
		this.driver=driver;
	}
	//Locator to scroll till system distributiom
	By SystemDistribution = By.xpath("//div[@data-id='8834854']/div/h2");
	//Locator for search button
	By SearchButton = By.xpath("//div[@id='tablepress-1_filter']/label/input");
	//Locator for header name
	By HeaderName = By.xpath("//table[@id='tablepress-1']/thead/tr");
	//Locator for Operating system
	By OperatingSystem = By.xpath("//table[@id='tablepress-1']/thead/tr/th[2]");
	//Locator for OS
	By OS = By.xpath("//table[@id='tablepress-1']/tbody/tr/td[2]");
	//Locator for web table
	By table = By.xpath("//table[@id='tablepress-1']/tbody");
	//Locator for search button
	By Search = By.xpath("//div[@class='elementor-shortcode']/div/div[2]/label/input");
	
	//Method to scroll system distribution
	public void scrollToSystemDistribution()
	{
		WebElement Element = driver.findElement(SystemDistribution);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	//Method to enter text in search button
	public void enterSearch(String value) throws InterruptedException
	{
		driver.findElement(SearchButton).clear();
		Thread.sleep(3000);
		driver.findElement(SearchButton).sendKeys(value);
	}
	//Method to enter value in search
	public void enterSearch2(String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Search));
		driver.findElement(Search).sendKeys(value);
	}
	//Method to count windows os
	public void countWindowsOS()
	{
	    List<WebElement> count = driver.findElements(By.xpath("//table[@id='tablepress-1']/tbody/tr/td[2]"));
		System.out.println(count.size());
		for(int i=1; i<count.size(); i++)
		{
			driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr/td[2]"));
			WebElement OS = driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr/td[2]"));
			System.out.println(OS.getText());
		}		
	}
	//Method to count mac os
	public void countMACOS()
	{	
	    List<WebElement> count = driver.findElements(By.xpath("//table[@id='tablepress-1']/tbody/tr/td[2]"));
		System.out.println(count.size());
		for(int i=1; i<count.size(); i++)
		{
			driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr/td[2]"));
			WebElement OS = driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr/td[2]"));
			System.out.println(OS.getText());
		}		
	}
	//Method to verify header name
	public void verifyHeader()
	{
		String header = driver.findElement(HeaderName).getText();
		if(header.contains("OS"))
		{
			System.out.println(header);
			System.out.println("OS header is verified");
			//log.info("Header is verified");
		}
		else if(header.contains("Browser"))
		{
			System.out.println(header);
			System.out.println("Browser header is verified");
			//log.info("Browser header is verified");
		}
		else if(header.contains("City"))
		{
			System.out.println(header);
			System.out.println("City header is verified");
			//log.info("City header is verified");
		}
		else if(header.contains("Country"))
		{
			System.out.println(header);
			System.out.println("Country header is verified");
			//log.info("Country header is verified");
		}
		else
		{
			System.out.println("Header is not verified");
			//log.info("Header is not verified");
		}
	}
}
