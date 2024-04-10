package basePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Testbase;

public class DashboardPage extends Testbase{

	DashboardPage dashboardPage;
	LoginPage loginPage;
	
	@FindBy(xpath = "(//a[contains(text(),'Setup')])[1]") WebElement setup;
	
	@FindBy(xpath = "//h4[contains(text(),'how things are going')]") WebElement dasboardHeader;
	
	public DashboardPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyDashboardPageTitle() {
		return dasboardHeader.getText();
	}
	
	public String getitleOfDashboardPage() {
		return driver.getTitle();
	}
	
	public void clickOnSetUp() {
		setup.click();
	}
}
