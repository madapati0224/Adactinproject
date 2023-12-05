package testcases;


import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class Tc_001_LogintoAdactin extends BaseClass {
	@Test
	public void Adactin_login()
	{
		logger.info("Started execution for Tc_001_LogintoAdactin ");
		LoginPage lp=new LoginPage(driver);

//hardcoded

	/*	lp.setUser_name("vamshinani");
		logger.info("Enter the User_name");
		lp.setpassword("Vamshi@133");
		logger.info("Enter the password");
		lp.clicklogin();
		logger.info("click on login");*/
		
//Reading data using config
		
		lp.setUser_name(rb.getString("User_name"));
		logger.info("Enter the User_name");
		lp.setpassword(rb.getString("password"));
		logger.info("Enter the password");
		lp.clicklogin();
		logger.info("click on login");

	}
	
	

}
