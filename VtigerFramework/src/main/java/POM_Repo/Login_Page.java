package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Generic_Utilities.Webdriver_Utility;

public class Login_Page {
	
	public  Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	//Declaration
	   @FindBy(name="user_name")
	   private WebElement userTextField;
	   
	   @FindBy(name="user_password")
	   private WebElement passwordTextField;
	   
	   @FindBy(id="submitButton")
	   private WebElement submitButton;
	   
	   //getter Method
	   public WebElement getUserTextField()
	   {
		   return userTextField;
	   }
	   public WebElement getPasswordTextField()
	   {
		   return passwordTextField;
	   }
	   
	   public WebElement getSubmitButton()
	   {
		   return  submitButton;
	   }
	   //Business Logics
	   public void LoginToApp(String username,String password)
	   {
		   userTextField.sendKeys(username);
		   passwordTextField.sendKeys(password);
		   submitButton.click();
		   
	   }
	/*public void setUserTextField(WebElement userTextField) {
		this.userTextField = userTextField;
	}
	public void setPasswordTextField(WebElement passwordTextField) {
		this.passwordTextField = passwordTextField;
	}
	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}*/
}
