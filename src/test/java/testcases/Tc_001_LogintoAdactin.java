package testcases;


import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class Tc_001_LogintoAdactin extends BaseClass {
	@Test
	public void Adactin_login()
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUser_name("vamshinani");
		lp.setpassword("Vamshi@133");
		lp.clicklogin();
	}
	
	

}
