package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	
	public Testbase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("src/main/java/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/saksh/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/saksh/Documents/SeleniumServer/geckodriver");	
			driver = new FirefoxDriver(); 
		}
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
		public WebElement waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	        return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
		
}
