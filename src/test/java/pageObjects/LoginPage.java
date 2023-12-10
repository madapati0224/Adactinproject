package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
		}

//xpaths
	
//	@FindBy(xpath="//input[@id='username']")
	@FindBy(xpath="//input[@name='username']")
	WebElement Username;
	
	//@FindBy(xpath="//input[@id='password']")
	@FindBy(xpath="//input[@name='password']")
	WebElement Pswd;
	
	//@FindBy(xpath="//input[@id='login']")
	@FindBy(xpath="//input[@name='login']")
	WebElement btn_login;

//Methods	

public void setUser_name(String User_name)
		{
			Username.sendKeys(User_name);
		}
		
	public void setpassword(String password )
		{
			Pswd.sendKeys(password);
		}
	
	
	public void clicklogin()
	{
		btn_login.click();
	}
	

}
