package basePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utils.Util;

import base.Testbase;

public class TeamMembersPage extends Testbase{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	SetupPage setupPage;
	TeamMembersPage teamMembersPage;
	

	
	
	@FindBy(xpath = "//h2[text()='Team Members']") WebElement teamMemberPageHeader;
	
	@FindBy(xpath = "//a[@title='Add Team Member']") WebElement addteamMemberButton;
	
	@FindBy(xpath = "//label[text()='Create Profile']") WebElement createProfileHeader;
	
	@FindBy(xpath = "//input[@id='firstName']") WebElement firstName;
	
	@FindBy(xpath = "//input[@id='lastName']") WebElement lastName;
	
	@FindBy(xpath = "//input[@id='email']") WebElement email;
	
	@FindBy(xpath = "//input[@id='username']") WebElement newusername;
	
	@FindBy(xpath = "//input[@id='password']") WebElement newpss;
	
	@FindBy(xpath = "//input[@id='confirmPassword']") WebElement confirmpass;
	
	@FindBy(xpath = "//span[contains(text(),'Save and Close')]") WebElement saveAndClose;
	
	@FindBy(xpath = "//input[@placeholder='Search team members']") WebElement memberSearchBox;
	
	@FindBy(xpath = "//table/tbody/tr/td[3]") List<WebElement> userList;
	
	@FindBy(xpath = "(//a[contains(text(),'Edit')])[1]") WebElement editButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Edit Team Member')]") WebElement editTeamMemberHeader;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]") WebElement editUserName;
	
	@FindBy(xpath = "//td//a[contains(text(),'View')]") WebElement viewButton;
	
	@FindBy(xpath = "(//div//div[@class='view-text'])[1]") WebElement viewFname;
	
	@FindBy(xpath = "(//div//div[@class='view-text'])[2]") WebElement viewLname;
	
	@FindBy(xpath = "(//div//div[@class='view-text'])[3]") WebElement viewEmail;
	
	@FindBy(xpath = "(//div//div[@class='view-text'])[5]") WebElement viewUsername;
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]") WebElement deleteButton;
	
	@FindBy(xpath = "(//button[contains(text(),'Delete')])[2]") WebElement deletePopupButton;
	
	@FindBy(xpath = "//p[contains(text(),'Are you sure you want to delete the Team Member')]") WebElement beforeDeleteMsg;
	
	public TeamMembersPage() {
	PageFactory.initElements(driver, this);
	}

	public String verifyTeamMemberPageHeader() {
		return teamMemberPageHeader.getText();
	}
	
	public void clickOnAddTeamMemberButton() {
		addteamMemberButton.click();
	}

	public String verifyCreateProfileHeader() {
		return createProfileHeader.getText();
	}
	
	public boolean addTeamMemberAndVerify() throws InterruptedException {
		
		
		String fName = Util.generateRandomFirstName(6);
	    String lName = Util.generateRandomLastName(6);
	    String mail = Util.generateRandomEmail(8);
	    String username = Util.generateRandomUsername(fName, lName);
	    String password = Util.generateRandomPassword();
	    Thread.sleep(5000);
	    
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mail);
        newusername.sendKeys(username);
        newpss.sendKeys(password);
        confirmpass.sendKeys(password);
        Thread.sleep(5000);
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveAndClose);
        waitForElementToBeClickable(saveAndClose,50000);

        saveAndClose.click();
        Thread.sleep(5000);
        memberSearchBox.sendKeys(lName +", "+ fName);
        Thread.sleep(5000);
        
        for(int i = 0; i<userList.size();i++) {
        	if(userList.get(i).getText().equalsIgnoreCase(mail)) {
        		System.out.println("Team Member Added in Table");
        	}
        }
		return false;   
	}
	
	
	public Boolean editTeamMemberAndVerify() throws InterruptedException {
		
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);

        		waitForElementToBeClickable(editButton,20000);
        		editButton.click(); 
        		Thread.sleep(5000);
        		
        		String fName = Util.generateRandomFirstName(6);
        	    String lName = Util.generateRandomLastName(6);
        	    Thread.sleep(5000);
        	    
        		firstName.clear();
        		firstName.sendKeys(fName);
        		lastName.clear();
                lastName.sendKeys(lName);
                
                
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveAndClose);
                Thread.sleep(5000);
                waitForElementToBeClickable(saveAndClose,50000);
                saveAndClose.click();
                Thread.sleep(5000);
                
                memberSearchBox.sendKeys(lName +", "+ fName);
                Thread.sleep(5000);
                String editedUser= lName +", "+ fName;
                Thread.sleep(5000);
                String edited = editUserName.getText();     
                Thread.sleep(5000);
                if(editedUser.equals(edited)) {
                	return true;
                }
                else {
                	return false;
                }
	}
	
		public Boolean viewTeamMemberAndVerify() throws InterruptedException {
		
			String fName = Util.generateRandomFirstName(6);
		    String lName = Util.generateRandomLastName(6);
		    String mail = Util.generateRandomEmail(8);
		    String username = Util.generateRandomUsername(fName, lName);
		    String password = Util.generateRandomPassword();
		    Thread.sleep(5000);
		    
	        firstName.sendKeys(fName);
	        lastName.sendKeys(lName);
	        email.sendKeys(mail);
	        newusername.sendKeys(username);
	        newpss.sendKeys(password);
	        confirmpass.sendKeys(password);
	        Thread.sleep(5000);
	        
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveAndClose);
	        waitForElementToBeClickable(saveAndClose,50000);

	        saveAndClose.click();
	        Thread.sleep(5000);
	        memberSearchBox.sendKeys(lName +", "+ fName);
	        Thread.sleep(5000);

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewButton);
        		waitForElementToBeClickable(viewButton,20000);
        		viewButton.click(); 
        		Thread.sleep(5000);

        		boolean verificationResult = false;
                try {
                    Assert.assertEquals(fName, viewFname.getText());
                    Assert.assertEquals(lName, viewLname.getText());
                    Assert.assertEquals(mail, viewEmail.getText());
                    Assert.assertEquals(username, viewUsername.getText());
                    verificationResult = true;
                } catch (AssertionError e) {
                    verificationResult = false;
                }
                return verificationResult;
            }
		
		
		public Boolean deleteTeamMember()throws InterruptedException {
			
			String fName = Util.generateRandomFirstName(6);
		    String lName = Util.generateRandomLastName(6);
		    String mail = Util.generateRandomEmail(8);
		    String username = Util.generateRandomUsername(fName, lName);
		    String password = Util.generateRandomPassword();
		    Thread.sleep(5000);
		    
	        firstName.sendKeys(fName);
	        lastName.sendKeys(lName);
	        email.sendKeys(mail);
	        newusername.sendKeys(username);
	        newpss.sendKeys(password);
	        confirmpass.sendKeys(password);
	        Thread.sleep(5000);
	        
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveAndClose);
	        waitForElementToBeClickable(saveAndClose,50000);
	        saveAndClose.click();
	        Thread.sleep(5000);
	        
	        memberSearchBox.sendKeys(lName +", "+ fName);
	        Thread.sleep(5000);

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
    		waitForElementToBeClickable(editButton,20000);
    		editButton.click(); 
    		Thread.sleep(5000);
    		
    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteButton);
    		waitForElementToBeClickable(deleteButton,20000);
    		deleteButton.click(); 
    		Thread.sleep(5000);
    		
    		
    		if(beforeDeleteMsg.getText().contains("Are you sure you want to delete the Team Member")) 
    			return false;
    		
    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deletePopupButton);
    		waitForElementToBeClickable(deletePopupButton,20000);
    		deletePopupButton.click(); 
    		Thread.sleep(5000);	
    		
    		Thread.sleep(5000);
	        memberSearchBox.sendKeys(lName +", "+ fName);
	        Thread.sleep(5000);
	        
	        for(int i = 0; i<userList.size();i++) {
	        	if(userList.isEmpty()) {
	        		System.out.println("No Member is available with given name");
	        		return false;
	        	}
	        }
	        return true;
            }
		
}
	



