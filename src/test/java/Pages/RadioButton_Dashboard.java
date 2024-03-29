package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import freemarker.log.Logger;

public class RadioButton_Dashboard {

	static WebDriver driver;
	
	static Logger log = Logger.getLogger(RadioButton_Dashboard.class.getName());
	
	Utility2 utility = new Utility2();
	
	public RadioButton_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	//Locator to scroll till radio button
	By scrollToRadioButton = By.xpath("//div[text()='Cross Origin iframe Scenario']");
	//Locator to switch frame radio button
	By RadioButtonFrame = By.xpath("//iframe[@id='coming google']");
	//Locator for yes radio button
	By Button1 = By.xpath("//*[@id='i5']/div[3]/div");
	//Locator for no radio button
	By Button2 = By.xpath("//div[@class='SG0AAe']/div[2]/label/div/div/div/div[3]/div");
	//Locator for installed now radio button
	By Button3 = By.xpath("//div[@id='i11']/div[3]/div");
	//Locator for clear section
	By ClearSection = By.xpath("//span[text()='Clear selection']");
	//Locator for submit button
	By SubmitButton = By.xpath("//div[@class='lRwqcd']/div/span/span");
	//Locator to verify submit button
	By response = By.xpath("//div[@class='idZHHb']/div[3]");
	
	//Method to scroll till radio button
	public void scrollToRadioButton()
	{
		WebElement Element = driver.findElement(scrollToRadioButton);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	//Method to scroll
	public void scroll()
	{
		utility.scroll3(driver);
	}
	//Method to come out of the frame
	public void exitframe()
	{
		driver.switchTo().defaultContent();
	}
	//Method to switch to radio button frame
	public void switchToFrame() throws InterruptedException
	{
		Thread.sleep(6000);
		WebElement RadioButtonFrame = driver.findElement(By.xpath("//iframe[@id='coming google']"));
		driver.switchTo().frame(RadioButtonFrame);
	}
	//Method to click on yes radio button
	public void radiobutton1()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Button1));
		driver.findElement(Button1).click();
	}
	//Method to verify radio button1
	public void verifyRadioButton()
	{
		WebElement button = driver.findElement(Button1);
		if(button.isEnabled())
		{
			System.out.println("Radio Button1 is enabled ");
		}
		else
		{
			System.out.println("Radio Button1 is not enabled ");
		}
	}
	//Method to click on no radio button
	public void radiobutton2()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Button2));
		driver.findElement(Button2).click();
	}
	//Method to verify radio button2
	public void verifyRadioButton2()
	{
		WebElement button = driver.findElement(Button2);
		if(button.isEnabled())
		{
			System.out.println("Radio Button2 is enabled ");
		}
		else
		{
			System.out.println("Radio Button2 is not enabled ");
		}
	}
	//Method to click on installed radio button
	public void radiobutton3()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Button3));
		driver.findElement(Button3).click();
	}
	//Method to verify radio button2
	public void verifyRadioButton3()
	{
		WebElement button = driver.findElement(Button3);
		if(button.isEnabled())
		{
			System.out.println("Radio Button3 is enabled ");
		}
		else
		{
			System.out.println("Radio Button3 is not enabled ");
		}
	}
	//Method to click on submit button
	public void clickOnSubmitButton() throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(SubmitButton));
		Thread.sleep(5000);
		driver.findElement(SubmitButton).click();
	}
	//Method to verify submit button
	public void verifySubmitResponse() throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(response));
		Thread.sleep(6000);
		String value = driver.findElement(response).getText();
		if(value.contains("Your response has been recorded"))
		{
			System.out.println("Submit response is verified");
		}
		else
		{
			System.out.println("Submit response is not verified");
		}
	}
	//Method to click on clear section
	public void clickOnClearSection()
	{
		driver.findElement(ClearSection).click();
	}
}
