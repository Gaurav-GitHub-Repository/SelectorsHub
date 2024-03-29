package Pages;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert_Dashboard {

	static Logger log = Logger.getLogger(Alert_Dashboard.class.getName());

	Utility2 utility = new Utility2();

	static WebDriver driver;
	
	public Alert_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	//Locator for window alert button
	By AlertButton = By.xpath("//button[text()='Click To Open Window Alert']");
	//Locator for prompt window alert
	By PromptAlert = By.xpath("//button[text()='Click To Open Window Prompt Alert']");
	//Locator for bottom slide
	By BottomSlide = By.xpath("//button[text()='Open Modal']");
	//Locator for bottom slide text
	By BottomText = By.xpath("//div[@id='myModal']/div/div/h2/a");
	//Locator for bottom close button
	By CloseButton = By.xpath("//div[@id='myModal']/div/div/span");
	
	//Method to click on alert button
	public void clickOnAlertButton()
	{
		driver.findElement(AlertButton).click();
	}
	//Method to verify alert text
	public void verifyAlert() throws InterruptedException
	{
		Thread.sleep(5000);
		String value = driver.switchTo().alert().getText();
		//String value = alert.getText();
		System.out.println(value);
		//log.info(alert);
		if(value.equalsIgnoreCase("Press a button!"))
		{
			System.out.println("Alert message is verified");
			//log.info("Alert message is verified");
		}
		else
		{
			System.out.println("Alert message is not verified");
			//log.info("Alert message is not verified");
		}
	}
	//Method to accept alert
	public void alert1() throws InterruptedException
	{
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Successfully clicked on OK button");
		//log.info("Successfully clicked on OK button");
	}
	//Method to accept alert
	public void alert2() throws InterruptedException
	{
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		System.out.println("Successfully clicked on Cancel button");
		//log.info("Successfully clicked on Cancel button");
	}
	//Method to click on prompt alert button
	public void clickOnPromptAlert()
	{
		utility.scroll2(driver);
		driver.findElement(PromptAlert).click();
	}
	//Method to verify prompt alert
	public void verifyPromptAlert() throws InterruptedException
	{
		Thread.sleep(5000);
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		if(alert.equalsIgnoreCase("Do you have Testing Daily Mobile App?"))
		{
			System.out.println("Prompt alert is verified");
			//log.info("Prompt alert is verified");
		}
		else
		{
			System.out.println("Prompt alert is not verified");
			//log.info("Prompt alert is not verified");
		}
	}
	//Method to enter text in prompt alert
	public void enterAlertMessage()
	{
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Unable to clear text in prompt alert ");
	}
	//Method to click on bottom window
	public void clickOnBottomSlide()
	{
		
		driver.findElement(BottomSlide).click();
	}
	//Method to verify bottom slide
	public void verifyBottomSlide() throws InterruptedException
	{
		Thread.sleep(5000);
		String var = driver.findElement(BottomText).getText();
		System.out.println(var);
		//log.info(var);
		if(var.equalsIgnoreCase("Testing Daily - Free App to get the latest testing feed."))
		{
			System.out.println("Bottom text is verified");
			//log.info("Bottom text is verified");
		}
		else
		{
			System.out.println("Bottom text is not verified");
			//log.info("Bottom text is not verified");
		}
	}
	//Method to close bottom slide
	public void closeBotton()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(CloseButton));
		driver.findElement(CloseButton).click();
		System.out.println("Successfully closed the button");
	}
	
}
