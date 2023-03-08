package Campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCampaign {
	public static void main(String[] args) throws IOException, InterruptedException {
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
	        
	        
	     
	        driver.findElement(By.linkText("More")).click();
	        driver.findElement(By.linkText("Campaigns")).click();
	        driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	        
	          //random class
			 Random ran=new Random();
		     int ranNum = ran.nextInt(1000);
		     
	        
	        //fetching the data  from excel 
	        FileInputStream fis1 = new FileInputStream("D:\\Advance selinium\\VtigerFramework\\src\\test\\resources\\EcxelFeb.xlsx");
	        Workbook book = WorkbookFactory.create(fis1);
	       Sheet sh = book.getSheet("Campaign");
	       Row row = sh.getRow(0);
	       Cell cel = row.getCell(0);
	        String data= cel.getStringCellValue()+ranNum;
	       driver.findElement(By.name("campaignname")).sendKeys(data);
	       driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	       
	       Thread.sleep(2000);

	       driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	       
	       
	       
	        

}

}
