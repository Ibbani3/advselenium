package Practies;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VBrowser_launch {
	public static void main(String[] args) throws Throwable {
		String Key="webdriver.chrome.driver";
		String Value="D:\\Advance selinium\\VtigerFramework\\src\\main\\resources\\chromedriver.exe";
		//String Value=".\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(Key, Value);
		WebDriver driver = new ChromeDriver();
		
		//.get("http://localhost:8888/");
		//driver.findElement(By.name("user_name")).sendKeys("admin");
		//driver.findElement(By.name("user_password")).sendKeys("admin");
		//driver.findElement(By.id("submitButton")).click();
		
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
		
	}

}

