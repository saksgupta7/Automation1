package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import basePage.DashboardPage;
import basePage.LoginPage;
import basePage.SetupPage;

public class DashboardPageTest extends Testbase{

LoginPage loginPage;
DashboardPage dashboardPage;
	
	
	public DashboardPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		dashboardPage = new DashboardPage();
		loginPage = new LoginPage();	
		loginPage.login();
		loginPage.clickOnSignIn();
	}
	
	
	
	@Test
	public void verifyHomePageTile() {
		String title = dashboardPage.getitleOfDashboardPage();
		Assert.assertEquals("", title);
	}
	
	@Test
	public void iClickOnSetUpAndVerifyTile() {
		dashboardPage.clickOnSetUp();
		String title = dashboardPage.verifyDashboardPageTitle();
		Assert.assertEquals("Here's a look at how things are going", title);
	}
	

	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
