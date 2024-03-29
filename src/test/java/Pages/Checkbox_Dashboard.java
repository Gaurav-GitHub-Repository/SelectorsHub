package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import freemarker.log.Logger;

public class Checkbox_Dashboard {

    static WebDriver driver;
	
	static Logger log = Logger.getLogger(Checkbox_Dashboard.class.getName());
	
	Utility2 utility = new Utility2();
	
	public Checkbox_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	//Locatoe for web table
	By table1 = By.xpath("//table[@id='resultTable']");
	//Locator for username header
	By UsernameHeader = By.xpath("//table[@id='resultTable']/thead/tr/th[2]/a");
	//Locator for user role
	By UserRole = By.xpath("//table[@id='resultTable']/thead/tr/th[3]/a");
	//Locator for employee name
	By EmployeeName = By.xpath("//table[@id='resultTable']/thead/tr/th[4]/a");
	//Locator for status 
	By Status = By.xpath("//table[@id='resultTable']/thead/tr/th[5]/a");
	//Locator for usertable checkbox
	By checkbox = By.xpath("//input[@name='chkSelectAll']");
	
	//Method to retrieve name of web table
	public void verifyTable()
	{
		List<WebElement> var = driver.findElements(table1);
		for(WebElement value: var)
		{
			System.out.println(value.getText());
			//log.info(value.getText());
			try {
				 utility.takeScreenshot(driver);
				} 
			catch (IOException e) {
				
				System.out.println("Successfully retrieved all the web table values");
			}
		}
	}
	//Method to verify table header
	public void verifyHeaderTable()
	{
		String header1 = driver.findElement(UsernameHeader).getText();
		String header2 = driver.findElement(UserRole).getText();
		String header3 = driver.findElement(EmployeeName).getText();
		String header4 = driver.findElement(Status).getText();
		
		String header5;
		int header =3;
		switch(header)
		{
			case 1:
				header1="Username";	
				System.out.println(header1);
				//log.info(header1);
				break;
			case 2:
				header2="User Role";
				System.out.println(header2);
				//log.info(header2);
				break;
			case 3:
				header3="Employee Name";
				System.out.println(header3);
				//log.info(header3);
				break;
			case 4:
				header4="Status";
				System.out.println(header4);
				//log.info(header4);
				break;
			default:
				header5="Invalid header";
				System.out.println(header5);
				//log.info(header5);
				break;
		}
	}
	//Method to click on user table checkbox
	public void clickOnCheckbox()
	{
		try {
			 utility.scroll(driver);
			 driver.findElement(checkbox).click();
			 utility.takeScreenshot(driver);
		} catch (IOException e)
		{
			System.out.println("Successfully clicked on checkbox");
		}
	}
	//Method to verify checkbox is enabled
	public void verifyCheckbox()
	{
		WebElement value = driver.findElement(checkbox);
		if(value.isDisplayed())
		{
			System.out.println("Checkbox is verified");
			//log.info("Checkbox is verified");
		}
		else
		{
			System.out.println("Checkbox is not verified");
			//log.info("Checkbox is not verified");
		}
	}
}
