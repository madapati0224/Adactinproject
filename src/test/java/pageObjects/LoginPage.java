package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
		}

//xpaths
	
	@FindBy(xpath="//input[@id='username']")
	WebElement Username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Pswd;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement btn_login;

//Methods	

public void setUser_name(String User_name)
		{
			Username.sendKeys("name");
		}
		
	public void setpassword(String password )
		{
			Pswd.sendKeys("pswd");
		}
	
	
	public void clicklogin()
	{
		btn_login.click();
	}
	

}
