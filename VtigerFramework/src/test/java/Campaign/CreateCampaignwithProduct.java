package Campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Webdriver_Utility;

public class CreateCampaignwithProduct {
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
		
		   Thread.sleep(2000);

	        driver.findElement(By.linkText("Products")).click();
	        driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	        
	        //Avoid duplicate values
	         Random ran = new Random();
	         int ranNum = ran.nextInt(1000);
	        
	        //fetching the data  from excel 
	        FileInputStream fes = new FileInputStream("D:\\Advance selinium\\VtigerFramework\\src\\test\\resources\\EcxelFeb.xlsx");
	        Workbook book = WorkbookFactory.create(fes);
	       Sheet sheetname = book.getSheet("Product");
	       Row rownum = sheetname.getRow(0);
	       Cell celvalue = rownum.getCell(0);
	        String prdvalue= celvalue.getStringCellValue()+ranNum;
	      // String prdData= cel.getStringCellValue();
	       driver.findElement(By.name("productname")).sendKeys(prdvalue);
	       driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
	       
	      // Thread.sleep(2000);
	       
	       //navigate to campaign
	       driver.findElement(By.linkText("More")).click();
	       driver.findElement(By.linkText("Campaigns")).click();
	    
	     //click on plus sign
	       driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	       
	       
	       //fetching the data  from excel to campaign
	       FileInputStream fis1 = new FileInputStream("D:\\Advance selinium\\VtigerFramework\\src\\test\\resources\\EcxelFeb.xlsx");
	        Workbook book1 = WorkbookFactory.create(fis1);
	        Sheet sh1 = book1.getSheet("Campaign");
	       Row row1 = sh1.getRow(0 );
	       Cell cel1 = row1.getCell(0);
	        String data= cel1.getStringCellValue()+ranNum;
	       driver.findElement(By.name("campaignname")).sendKeys(data);
	       
	       //click on product plus icon
	       driver.findElement(By.xpath("//img[@alt='Select']")).click();
	       Thread.sleep(2000);
	       
	       //switch to window
	      Webdriver_Utility wlib = new Webdriver_Utility();
	      wlib.switchToWindow(driver, "Products&action");
	       
	       //switch the window
	     /*  Set<String> allId = driver.getWindowHandles();
	       Iterator<String> it = allId.iterator();
	       while(it.hasNext())
	       {
	    	   Thread.sleep(2000);
	    	   String wid=it.next();
	    	   Thread.sleep(6000);
	    	   driver.switchTo().window(wid);
	    	   Thread.sleep(3000);
	    	   String title = driver.getTitle();
	    	   Thread.sleep(8000);
	    	   if(title.contains("Products&action"));
	    	   {
	    		   break;
	    	   }
	       }*/
	       
	      //driver.findElement(By.name("search_text")).sendKeys(prdvalue);
	        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(prdvalue);
	       Thread.sleep(2000);
	       driver.findElement(By.name("search")).click();
	      // driver.findElement(By.xpath("//input[@name='search']")).click();
	       Thread.sleep(1000);
	       driver.findElement(By.id("1")).click();
	      // driver.findElement(By.xpath("//a[text()='"+prdvalue+"']")).click();
	       Thread.sleep(2000);
	       
	       //using webdriver utility to reduce the number of lines in window switching in campaign&action
	       wlib.switchToWindow(driver, "Campaigns&action");
	       
	   /*    Set<String> allId1 = driver.getWindowHandles();
	       Iterator<String> it1 = allId1.iterator();
	       while(it1.hasNext())
	       {
	    	   String wid1 = it1.next();
	    	   driver.switchTo().window(wid1);
	    	   String title1 = driver.getTitle();
	    	   if(title1.contains("Campaigns&action"))
	    	   {
	    		   break;
	    		   
	    	   }
	       }*/
	      
	     //click on save button 
	     driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	     
	     Thread.sleep(2000);
	     
	     //click on administractor
	     driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	        
	     
}

}

