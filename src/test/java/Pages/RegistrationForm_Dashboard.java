package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationForm_Dashboard {

	static Logger log = Logger.getLogger(RegistrationForm_Dashboard.class.getName());

	Utility2 utility = new Utility2();

	static WebDriver driver;
	
	public RegistrationForm_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	//Locator for User Email
	By UserEmail = By.xpath("//div[@class='userform']/input[@name='email']");
	//Locator for Password
	By Password = By.xpath("//div[@class='userform']/input[2]");
	//Locator to enter company
	By Company = By.xpath("//div[@class='userform']/div/div/div/div/input[@name='company']");
	//Locator to enter mobile number
	By MobileNumber = By.xpath("//div[@class='userform']/div/div/div/div/input[2]");
	//Locator for submit button
	By SubmitButton = By.xpath("//button[text()='Submit']");
	
	//Method to enter user email
	public void enterUserEmail(String value) throws InterruptedException
	{
		driver.findElement(UserEmail).sendKeys(value);
		System.out.println("Email is entered");
		//log.info("Email is entered");
		Thread.sleep(2000);
	}
	//Method to enter Password
	public void enterPassword(String value) throws InterruptedException
	{
		driver.findElement(Password).sendKeys(value);
		System.out.println("Password is entered");
		//log.info("Password is entered");
		Thread.sleep(2000);
	}
	//Method to enter company
	public void enterCompany(String value) throws InterruptedException
	{
		driver.findElement(Company).sendKeys(value);
		System.out.println("Company is entered");
		//log.info("Company is entered");
		Thread.sleep(2000);
	}
	//Method to enter mobile number
	public void enterMobileNumber(String value) throws InterruptedException
	{
		driver.findElement(MobileNumber).sendKeys(value);
		System.out.println("MobileNumber is entered");
		//log.info("MobileNumber is entered");
		Thread.sleep(2000);
	}
	//Method to click on submit button
	public void clickOnSubmitButton() throws FileNotFoundException
	{
		  try {
			  driver.findElement(SubmitButton).click();
			  System.out.println("Successfully clicked on submit button");
			  //log.info("Successfully clicked on submit button");
			  utility.takeScreenshot(driver);
		} catch (IOException e) {
			System.out.println("Exception: IOException occured");
		}
	}
	
}
