package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*Task: Write automation script for login website
URL: https://adactinhotelapp.com/
Username: vamshinani
Password: Vamshi@133 */

public class BasePage {
	
WebDriver driver;
	
	public BasePage(WebDriver driver) //constructor name same as class name
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

}
