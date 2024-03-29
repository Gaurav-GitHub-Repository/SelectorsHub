package Pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import freemarker.log.Logger;

public class Dropdown_Dashboard {

	 static WebDriver driver;
	
	 static Logger log = Logger.getLogger(Dropdown_Dashboard.class.getName());
	
	 Utility2 utility = new Utility2();
	 
	 public Dropdown_Dashboard(WebDriver driver)
	 {
	 	this.driver=driver;
	 }
	 //Locator for car dropdown
	 // WebElement value1 = driver.findElement(By.xpath("//select[@id='cars']"));
	 //Locator for car dropdown
	 By value3 = By.xpath("//select[@id='cars']");
	 
	//Method to verify dropdown
	public void verifyDropdown()
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select select = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
		select.selectByVisibleText("Volvo");
		List<WebElement> var = select.getOptions();
		for(WebElement value: var)
		{
			System.out.println(value.getText());
		}
	}
	//Method to verify volvo car
	public void verifyDropdown(String value) throws IOException
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select select = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
		select.selectByVisibleText("Volvo");
		List<WebElement> var = driver.findElements(By.xpath("//select[@id='cars']"));
		for(WebElement value2: var)
		{
			if(value2.getText().contains("Volvo"))
			{
				System.out.println("Volvo car is verified");
				utility.takeScreenshot(driver);
				break;
			}
		}
	}
	//Method to verify Audi Car
	String value4 = "Audi";
	public void verifyDropdown(String value3, String value4) throws IOException
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select select = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
		select.selectByVisibleText("Audi");
		List<WebElement> var = driver.findElements(By.xpath("//select[@id='cars']"));
		for(WebElement value5: var)
		{
			if(value5.getText().contains("Audi"))		{
				System.out.println("Audi car is verified");
				utility.takeScreenshot(driver);
				break;
			}
		}
	}
}
