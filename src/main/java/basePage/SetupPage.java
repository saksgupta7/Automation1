package basePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class SetupPage extends Testbase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	SetupPage setupPage;
	
	@FindBy(xpath = "//h1[contains(text(),'ccount Setup')]") WebElement setUpPageHeader;
	
	@FindBy(xpath = "//h3[text()='Manage Team Members']") WebElement managementTeamHeader;
	
	@FindBy(xpath = "//a[@aria-label='Manage Team Members']") WebElement managementTeamMembersButton;
	
	public SetupPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySetupPageHeader() {
		return setUpPageHeader.getText();
	}
	
	public String verifyManageTeamMembersHeader() {
		return managementTeamHeader.getText();
	}
	
	public void clickOnManageforTeamMembers() {
		managementTeamMembersButton.click();
		
	}
	

	

}
