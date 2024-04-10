package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import basePage.DashboardPage;
import basePage.LoginPage;
import basePage.SetupPage;

public class SetupPageTest extends Testbase {
	
LoginPage loginPage;
DashboardPage dashboardPage;
SetupPage setupPage;
	
	public SetupPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		dashboardPage = new DashboardPage();
		loginPage = new LoginPage();	
		setupPage = new SetupPage();
		loginPage.login();
		loginPage.clickOnSignIn();
		dashboardPage.clickOnSetUp();
	}
	
	
	@Test
	public void verifyAccountSetUpHeader() {
		String setuptitle = setupPage.verifySetupPageHeader();
		Assert.assertEquals("Account Setup", setuptitle);
	}
	
	@Test
	public void validateManagementTeamMembersHeader() {
		String managementTeamtitle = setupPage.verifyManageTeamMembersHeader();
		Assert.assertEquals("MANAGE TEAM MEMBERS", managementTeamtitle);
	}
	
	@Test
	public void iClickOnManageButtonforTeamManagement() {
		setupPage.clickOnManageforTeamMembers();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
