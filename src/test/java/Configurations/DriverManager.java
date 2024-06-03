package Configurations;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	

	static ThreadLocal<WebDriver> Webdriver = new ThreadLocal<>();
	
	public static void setDriver(WebDriver driver)
	{
		Webdriver.set(driver);
	}
	
	public static WebDriver getDriver()
	{
		return Webdriver.get();
	}
	
	public static void removeDriver()
	{
		Webdriver.remove();
	}

	
	
}
