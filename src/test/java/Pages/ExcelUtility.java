package Pages;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExcelUtility {

	static WebDriver driver;
	
	    void utility() throws IOException
	    {
	    	String Filename = "C:\\Selenium Temp\\Dumps\\SelectorsHub.xlsx";
	    	XSSFWorkbook workbook = new XSSFWorkbook();
	    	XSSFSheet sheet = workbook.createSheet("Credentials");
	    	XSSFRow rowhead = sheet.createRow((int)0); 
	    	rowhead.createCell(0).setCellValue("UserEmail");
	    	rowhead.createCell(1).setCellValue("Password");			
	    	rowhead.createCell(2).setCellValue("Company");		
	    	rowhead.createCell(3).setCellValue("MobileNumber");	
	    	XSSFRow row = sheet.createRow((int)1);
	    	row.createCell(0).setCellValue("gaurav@gmail.com");
        	row.createCell(1).setCellValue("SelectorsHub");
        	row.createCell(2).setCellValue("SelectorsHub");
        	row.createCell(3).setCellValue("1234567891");
        	
        	String UserEmail_Sheet = sheet.getRow(1).getCell(0).getStringCellValue();
        	System.out.println("UserEmail_Sheet from the excel sheet is:" + UserEmail_Sheet);
        	String Password_Sheet = sheet.getRow(1).getCell(1).getStringCellValue();
        	System.out.println("Password_Sheet from the excel sheet is:" + Password_Sheet);
        	String Company_Sheet = sheet.getRow(2).getCell(2).getStringCellValue();
        	System.out.println("Company_Sheet from the excel sheet is:" + Company_Sheet);
        	String MobileNumber_Sheet = sheet.getRow(3).getCell(3).getStringCellValue();
        	System.out.println("MobileNumber_Sheet from the excel sheet is:" + MobileNumber_Sheet);
        	
        	//Enter user email from the excel sheet
        	WebElement Email = driver.findElement(By.xpath("//div[@class='userform']/input[@name='email']"));
        	Email.clear();
        	Email.sendKeys(UserEmail_Sheet);            
        	//Enter password from the excel sheet
        	WebElement Password = driver.findElement(By.xpath("//div[@class='userform']/input[2]"));
        	Password.clear();
        	Password.sendKeys(Password_Sheet);                    	
        	//Enter company from the excel sheet
        	WebElement Company = driver.findElement(By.xpath("//div[@class='userform']/div/div/div/div/input[@name='company']"));
        	Company.clear();
        	Company.sendKeys(Company_Sheet);
        	//Enter mobile number from the excel sheet
        	WebElement MobileNumber = driver.findElement(By.xpath("//div[@class='userform']/div/div/div/div/input[2]"));
        	MobileNumber.clear();
        	MobileNumber.sendKeys(MobileNumber_Sheet);
        	//Submit button
        	WebElement SubmitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        	SubmitButton.click();
        	
        	FileOutputStream fileOut = new FileOutputStream(Filename);
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();				
	    }   
	}
	


