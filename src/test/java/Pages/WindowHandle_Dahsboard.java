package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import freemarker.log.Logger;

public class WindowHandle_Dahsboard {

	static WebDriver driver;
	
	static Logger log = Logger.getLogger(WindowHandle_Dahsboard.class.getName());
	
	Utility2 utility = new Utility2();
	
	public WindowHandle_Dahsboard(WebDriver driver)
	{
		this.driver=driver;
	}
	//Locator to click on checkout link
	By CheckoutLink = By.xpath("//button[text()='Checkout here']");
	//Locator for TestCase Studio
	By TestCaseStudio = By.xpath("//div[@class='dropdown-content']/a[3]");
		
	//Method to click on checkout link
	public void clickOnCheckoutLink() throws InterruptedException, IOException
	{
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(CheckoutLink));
		Thread.sleep(6000);
		driver.findElement(CheckoutLink).click();
		System.out.println("Successfully clicked on checkout link");
		//log.info("Successfully clicked on checkout link");
	}
	//Method to click on test case studio
	public void clickOnTestCaseStudio()
	{
		driver.findElement(TestCaseStudio).click();
		System.out.println("Successfully clicked on TestCaseStudio link");
		//log.info("Successfully clicked on SelectorHubChannel link");
	}
	//Method to scroll
	public void scroll()
	{
		utility.scroll(driver);
	}
	//Method to switch to test case studio window
	public void switchToWindow()
	{
		Set<String>	var = driver.getWindowHandles();
		System.out.println(var);
		for(String value: var)
		{
			driver.switchTo().window(value);
			System.out.println("Succssfullt switched to test case studio window");
			//log.info("Succssfullt switched to test case studio window");
			try {
					utility.takeScreenshot(driver);
			} catch (IOException e) 
			{	
				System.out.println("Exception Occured");
			}
			System.out.println(driver.getTitle());
		}
	}
	//Method to verify switched window
	public void verifySwitchedWindow()
	{
		Assert.assertEquals(driver.getTitle(), "Xpath Practice Page | Shadow dom, nested shadow dom, iframe, nested iframe and more complex automation scenarios.");
		System.out.println("Page title of the switched window is verified");
		//log.info("Page title of the switched window is verified");
	}
	
}

