package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger ; //used to create step by step log
	public ResourceBundle rb; //to enter data using config file

	/*when doing the parallel testing if declare webdriver as static then only one webdriver will be created.
	one webdriver instance cannot run two parallel browsers.
	so, if the webdriver is public it will create as many instances required for parallel execution.*/
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br)
	{
		logger=LogManager.getLogger(this.getClass());//get test case name
		rb=ResourceBundle.getBundle("config1");// read values from config.properties file
		
	if(br.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else 
		{
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//driver.get("https://adactinhotelapp.com/"); //Hard coded the url
		driver.get(rb.getString("baseURL"));
	}
	
//	@AfterClass
	public void close()
	{
		driver.close();
	}
	
	//********************Screenshots-Listeners*************************************************
	
	public String captureScreen(String tname) {
		String timestamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot Screenshot=((TakesScreenshot)driver);
		File source=Screenshot.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		}catch(Exception e) {
			e.getMessage();
		}
		return destination;
	}

}


