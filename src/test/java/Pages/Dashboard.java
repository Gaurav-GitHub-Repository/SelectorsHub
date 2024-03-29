package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import freemarker.log.Logger;

public class Dashboard extends Utility2{

	static WebDriver driver;
	
	static Logger log = Logger.getLogger(Dashboard.class.getName());
	
	Utility2 utility = new Utility2();
	
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	//Locator for Practice Page
	By PracticePage = By.xpath("//ul[@id='menu-1-505c1be']/li[4]/a");
	//Locator for enabled button
	By Button = By.xpath("//div[@data-id='dfae242']/div/div/label");
	//Locator for First Name
	By FirstName = By.xpath("//input[@class='nameFld' and @placeholder='First Enter name']");
	//Locator for checkout link
	By CheckoutLink = By.xpath("//div[@class='dropdown']/button");
	//Locator for selectorhub channel
	By SelectorHubChannel = By.xpath("//div[@class='dropdown-content']/a[1]");
	//Locator for TestCase Studio
	By TestCaseStudio = By.xpath("//div[@class='dropdown-content']/a[3]");
	//Locator to click on date
	By DatePick = By.xpath("//input[@id='datepicker' and @class='hasDatepicker']");
	
	//Method to click on PracticePage
	public void page()
	{
		try {
		driver.findElement(PracticePage).click();
		System.out.println("Successfully landed on the page");
		//log.info("Successfully landed on the page");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Exception: NoSuchElementException Occured");
			//log.info("Exception: NoSuchElementException Occured");
		}
	}
	//Method to verify page
	public void verifyPage()
	{
		Assert.assertEquals(driver.getTitle(), "SelectorsHub- Free Productivity Booster Tools For Testers");
		System.out.println("Title is verified");
		//log.info("Title is verified");
	}
	//Method to enable button
	public void enableButton() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Button));
		driver.findElement(Button).click();
	}
	//Method to enter first name
	public void enterFirstName()
	{
		 WebElement element = driver.findElement(By.xpath("//input[@class='nameFld' and @placeholder='First Enter name']"));
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].value='Gaurav';", element);
	}
	//Method to click on checkout link
	public void clickOnCheckoutLink() throws InterruptedException, IOException
	{
		Thread.sleep(6000);
		driver.findElement(CheckoutLink).click();
		System.out.println("Successfully clicked on checkout link");
		//log.info("Successfully clicked on checkout link");
	}
	//Method to click on checkout link
	public void clickOnCheckoutLink2()
	{
		WebElement element = driver.findElement(By.xpath("//div[@class='dropdown']/button"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	//Method to click on checkout link
	public void clickOnCheckoutLink3() throws InterruptedException
	{
		try {
		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(CheckoutLink));
			Thread.sleep(6000);
			driver.findElement(CheckoutLink).click();
		}
		catch(ElementClickInterceptedException e)
		{
			System.out.println("Clicked on checkout link");
		}
	}
	//Method to click on Shyoutube link
	public void clickOnSelectorHubLink() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(SelectorHubChannel).click();
		System.out.println("Successfully clicked on SelectorHubChannel link");
		//log.info("Successfully clicked on SelectorHubChannel link");
	}
	//Method to click on test case studio link
	public void clickOnTestCaseStudioLink() throws InterruptedException, IOException
	{
		Thread.sleep(5000);
		driver.findElement(TestCaseStudio).click();
		System.out.println("Successfully clicked on TestCaseStudio link");
		//log.info("Successfully clicked on TestCaseStudio link");
	}
	//Method to switch link window
	public void switchToWindow()
	{
		Set<String> id = driver.getWindowHandles();
		System.out.println(id);
		for(String value: id)
		{
			driver.switchTo().window(value);
			System.out.println("Successfully switched to window");
		}
	}
	//Method to scroll
	public void scroll()
	{
		utility.scroll(driver);
	}
	//Method to enter date
	public void enterDate(String value) throws IOException
	{
		try {
			 driver.findElement(DatePick).sendKeys(value);
			 utility.takeScreenshot(driver);
		}
		catch(IOException e)
		{
			System.out.println("Date is not verified");
			//log.info("Date is entered");
		}
	}
}
