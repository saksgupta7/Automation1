package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import basePage.DashboardPage;
import basePage.LoginPage;
import basePage.SetupPage;
import basePage.TeamMembersPage;

public class TeamMembersPageTest extends Testbase{

	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	SetupPage setupPage;
	TeamMembersPage teamMembersPage;
	
		public TeamMembersPageTest(){
			super();
		}
		
		@BeforeMethod
		public void setUp(){
			initialization();
			dashboardPage = new DashboardPage();
			loginPage = new LoginPage();	
			setupPage = new SetupPage();
			teamMembersPage = new TeamMembersPage();
			
			loginPage.login();
			loginPage.clickOnSignIn();
			dashboardPage.clickOnSetUp();
			setupPage.clickOnManageforTeamMembers();
		}
		
		@Test
		public void validateTeamMemberPageHeader() {
			String teamMemberTitle = teamMembersPage.verifyTeamMemberPageHeader();
			Assert.assertEquals("Team Members", teamMemberTitle);
			
		}
		
		@Test
		public void iClickOnAddTeamMemberButton() {
			teamMembersPage.clickOnAddTeamMemberButton();			
		}
		
		@Test
		public void validateCreateProfileHeader() {
			teamMembersPage.clickOnAddTeamMemberButton();
			String createProfileTitle = teamMembersPage.verifyCreateProfileHeader();
			Assert.assertEquals("Create Profile", createProfileTitle);
		}
		
		@Test
		public void verifyTeamMemberIsAdded() throws InterruptedException{
			teamMembersPage.clickOnAddTeamMemberButton();
			teamMembersPage.addTeamMemberAndVerify();
		}
		
		@Test
		public void verifyAddAndEditNewTeamMember() throws InterruptedException{
			teamMembersPage.clickOnAddTeamMemberButton();
			teamMembersPage.addTeamMemberAndVerify();
			teamMembersPage.editTeamMemberAndVerify();
		}
		
		@Test
		public void validateTeamMemberAndVerify() throws InterruptedException {
			teamMembersPage.clickOnAddTeamMemberButton();
			teamMembersPage.viewTeamMemberAndVerify();
		}
		
		@Test
		public void validateDeleteTeamMember()throws InterruptedException {
			teamMembersPage.clickOnAddTeamMemberButton();
			 teamMembersPage.deleteTeamMember();
			
		}
		
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
}
