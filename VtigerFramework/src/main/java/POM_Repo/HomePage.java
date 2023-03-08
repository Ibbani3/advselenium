package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLinkText;
	
	@FindBy(linkText="Products")
	private WebElement productLinkText;
	
	@FindBy(linkText="More")
	private WebElement campaignLinkText;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLinkText;
	
	//getter Method
	public WebElement getOrganizationLinkText()
	{
		return organizationLinkText;
	}
	
	public WebElement getProductLink()
	{
		return productLinkText;
	}
 
	
	public WebElement getsignoutImg()
	{
		return signoutImg;
	}
	public WebElement getSignoutLinkText1()
	{
		return signoutLinkText;
	}
	
	public WebElement getMoreLink()
	{
		return getMoreLink();
	}
	public WebElement getcampaignLinkText()
	{
		return campaignLinkText;
		
	}

	public WebElement getProductLinkText() {
		return productLinkText;
	}

	public WebElement getCampaignLinkText() {
		return campaignLinkText;
	}

	public WebElement getSignoutImg() {
		return signoutImg;
	}

	public WebElement getSignoutLinkText() {
		return signoutLinkText;
	}

	public void setOrganizationLinkText(WebElement organizationLinkText) {
		this.organizationLinkText = organizationLinkText;
	}

	//Business login for Organization
	public void clickorganization()
	{
		organizationLinkText.click();
	}
	
	//business logic for signout
	public void logout (WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(signoutImg).perform();
		signoutLinkText.click();
	}
	
	
	
	
	
	
	

}
