package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.Dropdown_Dashboard;

@Listeners(Utility.class)
public class TestCase82 {

    static WebDriver driver;
	
	static Logger log = Logger.getLogger(TestCase82.class.getName());
	
	@Parameters("browserName")
	@BeforeTest
	public void initializeBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("GoogleChrome"))
		{ 
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			System.setProperty("WebDriver.chrome.driver", "C:\\Selenium Temp\\BDD_Cucumber\\SelectorsHub\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://selectorshub.com/xpath-practice-page/");
			//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			System.out.println("Chrome browser is successfully launched");
			//log.info("Chrome browser is successfully launched");
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			FirefoxOptions options = new FirefoxOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			System.setProperty("WebDriver.gecko.driver", "C:\\Selenium Temp\\BDD_Cucumber\\SelectorsHub\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.get("https://selectorshub.com/xpath-practice-page/");
			//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);		
			System.out.println("Firefox browser is successfully launched");
			//log.info("Firefox browser is successfully launched");
		}
		else if(browserName.equalsIgnoreCase("MicrosoftEdge"))
		{
			System.setProperty("WebDriver.edge.driver", "C:\\Selenium Temp\\BDD_Cucumber\\SelectorsHub\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://selectorshub.com/xpath-practice-page/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
			System.out.println("Microsoft Edge browser is successfully launched");
			//log.info("Microsoft Edge browser is successfully launched");
		}
		else
		{
			System.out.println("Browser is not launched");
			//log.info("Browser is not launched");
		}
	}
	//@Test(groups="RegressionTest")
	@Test(priority=1)
	public void regression() throws InterruptedException, IOException
	{
		Dashboard dashboard = new Dashboard(driver);	
		//dashboard.page();
		//dashboard.verifyPage();
		Dropdown_Dashboard dropdown = new Dropdown_Dashboard(driver);
		dropdown.verifyDropdown(null);
		System.out.println("Regression test cases are passed");
		//log.info("Regression test cases are passed");
	}
	@AfterTest
	public void logout()
	{
		driver.close();
		//log.error("Exception: java.net.SocketException Occured");
	}  
}
