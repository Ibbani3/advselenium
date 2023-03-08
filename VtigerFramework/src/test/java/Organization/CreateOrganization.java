package Organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;
import POM_Repo.HomePage;
import POM_Repo.Login_Page;
import POM_Repo.OrganizationCreatePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {
	public static void main(String[] args) throws Throwable {
		/*Property_Utility plib = new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		    WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();		
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();		
		}
		else {
			driver=new ChromeDriver();
			
		}*/

		String Key="webdriver.chrome.driver";
		String Value="D:\\Advance selinium\\VtigerFramework\\src\\main\\resources\\chromedriver.exe";
		//String Value=".\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(Key, Value);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Fetching data from property file
		Property_Utility plib = new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		
		/*FileInputStream fis=new FileInputStream("D:\\Advance selinium\\VtigerFramework\\src\\test\\resources\\property_filedata.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password"); */
		
		//Login to Vtiger Application
		driver.get(URL);
		Login_Page login = new Login_Page(driver);
		login.LoginToApp(USERNAME, PASSWORD);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	        HomePage home=new HomePage(driver);
	        home.clickorganization();
	        
	        
            // driver.findElement(By.linkText("Organizations")).click();
             //click on +img
	        OrganizationCreatePage orgPage=new OrganizationCreatePage(driver);
	        orgPage.clickOrganization();
             
	        //driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	        
	          //random class to avoide Duplicate
	           Java_Utility jlib = new Java_Utility();
	           int ranNum = jlib.getRanDomNum();
	        
			// Random ran=new Random();
		    // int ranNum = ran.nextInt(1000);
	        
	        //fetching the data  from excel 
	        Excel_Utility elib = new Excel_Utility();
	        String orgName = elib.getExcelData("Organization", 0, 0)+ranNum;
		     String dataf = elib.getExcelUsingDataFormatter("Campaign", 0, 0);
	        
	        //fetching the data  from excel 
	      /*  FileInputStream fis1 = new FileInputStream("D:\\Advance selinium\\VtigerFramework\\src\\test\\resources\\EcxelFeb.xlsx");
	        Workbook book = WorkbookFactory.create(fis1);
	       Sheet sh = book.getSheet("Organization");
	       Row row = sh.getRow(0);
	        Cell cel = row.getCell(0);
	        String data= cel.getStringCellValue()+ranNum;*/
		     
		      orgPage=new OrganizationCreatePage(driver); 
	       //driver.findElement(By.name("accountname")).sendKeys(orgName);
		     orgPage.SaveButton();
	       //driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	       
	       
	        //logout
	        
	        Thread.sleep(1000);
		       driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		     
		       
		       
		       //using action class sign out
		    // Thread.sleep(2000);
	        //WebElement signoutImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        //Actions act = new Actions(driver);
	        //act.moveToElement(signoutImg).perform();	      
	        //WebElement signoutLinkText = driver.findElement(By.xpath("//a[text()='Sign Out']"));
	        //signoutImg.click();
	       
		       //validation the organization
		       String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		       if(actData.contains(orgName)) {
		    	   System.out.println("pass");
		       }
		       else
		       {
		    	   System.out.println("fail");
		       }
	       
	        home.logout(driver);

}

}
