package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrganizationCreatePage {
	public OrganizationCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement plusimg;
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
 public WebElement getplusImg()
 {
	 return plusimg;
 }
 
 public WebElement getorgName()
 {
	 return orgName;
 }
 
 public WebElement getsaveButton()
 {
	 return saveButton;
 }
 
 //+img
 public void clickOrganization()
 {
	 plusimg.click();
 }
 
 //orgname
 public void organizationName(String orgName)
 {
	 //orgName.sendKeys(orgName);
	 
 }
 
 //save
 public  void SaveButton()
 {
	 saveButton.click();
 }
 
 
}