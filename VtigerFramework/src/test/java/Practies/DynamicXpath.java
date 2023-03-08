package Practies;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {
	public static void main(String[] args) throws Throwable {
		String Key="webdriver.chrome.driver";
		String Value="D:\\Advance selinium\\VtigerFramework\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(Key, Value);
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		//driver.findElement(By.xpath("//div[text()='February 2023']"
				//+ "/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='22']")).click();
		
		String month = "March 2023";
		String date = "23";
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		
		
	

}
}