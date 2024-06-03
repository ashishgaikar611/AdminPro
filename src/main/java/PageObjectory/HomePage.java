package PageObjectory;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbractComponant.AbstractComponant;
import junit.framework.Assert;


public class HomePage extends AbstractComponant {
	
	WebDriver driver;
	InputStreamReader reader;
	Properties prop;
	//AbstractComponant ac = new AbstractComponant(driver);
		
	
	public HomePage(WebDriver driver) throws IOException {
        super(driver);
	    this.driver= driver;
		PageFactory.initElements(driver, this);
		reader=new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\Demo.properties");
		prop= new Properties();
		prop.load(reader);
		
		
	}
	
	
   

	@FindBy (xpath = "//*[@formcontrolname=\"email\"]")
	WebElement txtemailAddress;
	
	@FindBy (xpath = "//*[@formcontrolname=\"password\"]")
	WebElement txtPassword;
	
	
	
   @FindBy (xpath = "//*[@class=\"ant-checkbox-input ng-pristine ng-valid ng-touched\"]")
   WebElement RememberMeCheckbx;
    
   @FindBy (xpath="//*[@class=\"login-form-button ant-btn ant-btn-primary\"]")
   WebElement  btnContinue;
   
   @FindBy (xpath="//*[@nzmode=\"horizontal\"]")
   WebElement Notification;
   
  
  
   

	public void Goto() {
		
		//driver.get(prop.getProperty("applicationURL"));
	driver.get("https://admin-board-phl-uat.flexm.com/auth");
		
		AbstractComponant.waitForElementToAppear(driver, txtPassword, 30);
		
	}
	public void Enter_EmailAddress(String txtemail) {
		AbstractComponant.explicitWait(driver, txtemailAddress, 30);
		 txtemailAddress.sendKeys(txtemail);
		
		   }
		 
	
	public void Enter_Password(String Password) {
	
		 txtPassword.sendKeys(Password);
		
		   }
	
	public void click_On_rememberMe_checkbox() {
		
		RememberMeCheckbx.click(); 
		
		   }
	
	public void click_On_Cntinue_button() throws InterruptedException {
		AbstractComponant.explicitWait(driver,btnContinue, 30);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", btnContinue);
		Thread.sleep(5000);
		Notification.isDisplayed();
	
		
		
		
		
	   }
	
	

	
	
	
	
	
	

}

