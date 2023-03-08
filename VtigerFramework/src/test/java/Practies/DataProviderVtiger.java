package Practies;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderVtiger {
	
	@Test(dataProvider="dataProvider_test")
	public void companyDetails(String name,String phnum,String email) throws Throwable
	{
		String key="webdriver.chrome.driver";
		String Value="D:\\Advance selinium\\vtigerJan5\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key,Value);
	    WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.get("http://localhost:8888/");
		    driver.findElement(By.name("user_name")).sendKeys("admin");
	        driver.findElement(By.name("user_password")).sendKeys("admin");
	        driver.findElement(By.id("submitButton")).click();
	        driver.findElement(By.linkText("Organizations")).click();     
	        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	        
	        driver.findElement(By.name("accountname")).sendKeys(name);
	        driver.findElement(By.name("phone")).sendKeys(phnum);
	        driver.findElement(By.id("email1")).sendKeys(email);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 driver.quit();
		 Thread.sleep(2000);
}
	@DataProvider
	public Object[][] dataProvider_test() throws Throwable
	{
		Random ran = new Random();
		int randnm = ran.nextInt();
		Object[][] objarr=new Object[3][3];
		objarr[0][0]="AAA"+randnm;
		objarr[0][1]="9876542356";
		objarr[0][2]="asfguh@gmail.com";
		
		objarr[1][0]="BBB"+randnm;
		objarr[1][1]="9083561290";
		objarr[1][2]="abc@gmail.com";
		
		objarr[2][0]="CCC"+randnm;
		objarr[2][1]="8934561093";
		objarr[2][2]="rtgionm@gmail.com";
		return objarr;
		
	}
	
}
