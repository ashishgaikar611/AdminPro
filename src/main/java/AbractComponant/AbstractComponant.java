package AbractComponant;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import org.openqa.selenium.*;




public class AbstractComponant {

	WebDriver driver;
	
	public AbstractComponant(WebDriver driver) {
		
	    this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public static void waitForElementToAppear(WebDriver driver, WebElement ele, int a) {

		WebDriverWait wait = new WebDriverWait(driver,a);
		wait.until(ExpectedConditions.elementToBeClickable(ele));

	}
	
	
	public static void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

	
	
	
	
}
