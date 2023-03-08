package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_Utility {
	private static final Object Driver = null;
	public void maximizeScreen(WebDriver driver)
	{
		WebDriver driver2;
		driver.manage().window().maximize();
	}
		/**
		 * Wait for page to load before identifying any Synchronized element in DOM
		 * @author pani
		 */
  public void waitForPageToLoad(WebDriver driver)
  {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  /**
   * after every action it will wait for next action to perform
   * @author pani
   */
public void scriptTimeout(WebDriver driver)
{
	driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
}
/**
 * used to wait for element to be clickable in GUI and check for specific element for every 500millisecond
 * 
 */
public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime)
{
	FluentWait wait = new FluentWait(Driver);
	wait.pollingEvery(Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	
}
/**
 * used to switch to any window based on wait title
 * @author driver
 * @param partialWindowTitle
 * @author Pani
 */

public void switchToWindow(WebDriver driver,String partialWindowTitle)
{
	Set<String> allId = driver.getWindowHandles();
	Iterator<String> it = allId.iterator();
	while(it.hasNext())
	{
		String wid = it.next();
		driver.switchTo().window(wid);
		if(driver.getTitle().contains(partialWindowTitle)) 
		{
			break;
		}
	}
}

/**
 * used to switch to AlertWindow and accept(click on ok button)
 * @param driver
 * @author pani
 */
public void switchToAlertAndAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * used to switch to AlertWindow and dismiss(click on cancel button)
 * @param driver
 * @author pani
 */
public void switchToAlertAndDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * used to switch to frame window based on Index
 * @param driver
 * @param index
 * @author pani
 */
public void switchToframe(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * used to switch to frame window based on id or name attribute
 * @param driver 
 * @param id_name_attribute
 * @author pani
 */
public void switchToframe(WebDriver driver,String id_name_Attribute)
{
	driver.switchTo().frame(id_name_Attribute);
}
/**
 * used to select the value from the dropdown based on index
 * @param element
 * @param index
 * @author pani
 */
public void select (WebElement element,int index)
{
	Select sel = new Select(element);
	sel.selectByIndex(index);
}
/**
 *  used to select the value from the dropdown based on text
 * @param element
 * @param index
 * @author pani
 */
public void select (WebElement element,String text)
{
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}
/**
 * used to place mouse cursor on specified element
 * @param driver
 * @param element
 * @author pani
 */
public void mouseOverOnElement(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * used to right click on specific element
 * @param driver
 * @param element
 * @author pani
 */
public void rightClickOnElement(WebDriver driver,WebElement element) 
{
	Actions act = new Actions(driver);
	act.contextClick(element).perform();
}
  public void moveByOffset(WebDriver driver,int x,int y)
  {
	  Actions act = new Actions(driver);
	  act.moveByOffset(x, y).click().perform();
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
