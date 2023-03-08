package Practies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Generic_Utilities.Property_Utility;
import Generic_Utilities.Webdriver_Utility;
import Organization.CreateOrganization;
import Product.CreateProduct;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
	public static WebDriver sdriver;
	public WebDriver driver;
	
	@BeforeSuite(groups= {"smoke","regression"})
	public void BS()
	{
		System.out.println("DataBase connection");
	}
@BeforeTest (groups= {"smoke","regression"})
   public void BT()
{
	System.out.println("Parallel Execution");
}
	@BeforeClass (groups= {"smoke","regression"})
	public void BC() throws Throwable
	{
		Property_Utility plib = new Property_Utility();
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
		}
		System.out.println("Launching the browser");
	}
	
	@BeforeMethod (groups= {"smoke","regression"})
	public void BM() throws Throwable
	{
		System.out.println("Login Application");
	}
	 
	@AfterMethod void AM()
	{
		System.out.println("Logout Application");
	}
	
	@AfterClass void AC()
	{
		System.out.println("close Browser");
	}
	
	@AfterSuite void AS()
	{
		System.out.println("Parallel Execution done");
	}
	
	@AfterTest void AT()
	{
		System.out.println("DataBase closed");
	}
	
}

