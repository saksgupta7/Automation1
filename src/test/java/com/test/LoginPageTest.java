package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import basePage.LoginPage;

public class LoginPageTest extends Testbase{
	
	LoginPage loginPage;
	
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	
	@Test
	public void verifyLogin() {
		String title = loginPage.login();
		Assert.assertEquals("", title);
		
	}
	
	@Test
	public void verifyHomePageTile() {
		loginPage.login();
		loginPage.clickOnSignIn();
		Assert.assertEquals("", null);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	


}
