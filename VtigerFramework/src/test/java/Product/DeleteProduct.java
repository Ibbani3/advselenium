package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteProduct {
	
	public static void main(String[] args) throws Throwable {
		String Key="webdriver.chrome.driver";
		String Value="D:\\Advance selinium\\VtigerFramework\\src\\main\\resources\\chromedriver.exe";
		//String Value=".\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(Key, Value);
		WebDriver driver = new ChromeDriver(); 
		
		FileInputStream fis=new FileInputStream("D:\\Advance selinium\\VtigerFramework\\src\\test\\resources\\property_filedata.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
	
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//random class
		 Random ran=new Random();
	     int ranNum = ran.nextInt(1000);
	     
	        //fetching the data from the excel
			FileInputStream fes=new FileInputStream("D:\\Advance selinium\\VtigerFramework\\src\\test\\resources\\EcxelFeb.xlsx");
			Workbook book=WorkbookFactory.create(fes);
			Sheet sheetName = book.getSheet("Product");
			Row rownum = sheetName.getRow(0);
			Cell cellNum = rownum.getCell(0);
	        String orgName = cellNum.getStringCellValue()+ranNum;
	        
	        driver.findElement(By.name("productname")).sendKeys(orgName);
	         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	         
	           driver.findElement(By.xpath("(//input[@title='Delete [Alt+D]'])[1]")).click();
		       Alert alt = driver.switchTo().alert();
		       alt.accept();
	         
	           Thread.sleep(1000);
		       driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		       
		  

}
}