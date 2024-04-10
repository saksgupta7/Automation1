package basePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class LoginPage extends Testbase {
	
	
	LoginPage loginPage;
	
	@FindBy(id="UserName") WebElement username;
	
	@FindBy(id="Password") WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'Sign in')]") WebElement signIn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String login() {
		System.out.println(driver.getTitle());
		username.click();
		username.sendKeys("kavithasub");
		password.sendKeys("Welcome123");
		return driver.getTitle();
	}
	
	public DashboardPage clickOnSignIn() {
		signIn.click();
		return new DashboardPage();
		
	}
	

}
