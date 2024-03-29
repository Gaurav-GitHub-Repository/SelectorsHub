package Pages;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import freemarker.log.Logger;

public class FileUpload_Dashboard extends Utility2{

	static WebDriver driver;
	
	static Logger log = Logger.getLogger(FileUpload_Dashboard.class.getName());
	
	Utility2 utility = new Utility2();
	
	public FileUpload_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	//Locator for file choosen button
	By FileChoosen = By.xpath("/html/body/div[1]/main/div/div[1]/section[2]/div/div[2]/div/div[2]/div/input[3]");
	//Locator to download png file
	By DownloadLink = By.xpath("//a[@href='https://selectorshub.com/wp-content/uploads/2023/12/Mega-sale-600-%C3%97-360-px-30.png']");

	//Method to scroll
	public void scroll()
	{
		utility.scroll2(driver);
	}
	//Method to upload file
	public void uploadFile() throws InterruptedException, IOException
	{
		try {
		//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(FileChoosen));
			Thread.sleep(6000);
			driver.findElement(FileChoosen).click();
			utility.uploadFile();
			System.out.println("File is uploaded");
		}
		catch (AWTException e) 
		{
			System.out.println("Exception: AWTException occured");
			//log.info("Exception: AWTException occured");
		} 
	}
	//Method to upload file
	public void uploadFile2() throws InterruptedException, IOException
	{
		try {
			 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			 //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(FileChoosen));
			 driver.findElement(FileChoosen).click();
			 utility.uploadFile(null);
			 System.out.println("File is uploaded");
		}
		catch (AWTException e) 
		{
			System.out.println("Exception: AWTException occured");
			//log.info("Exception: AWTException occured");
		}
	}
	//Method to click on download png
	public void clickOnDownloadLink()
	{
		driver.findElement(DownloadLink).click();
	}
}
