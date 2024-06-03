package Configurations;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjectory.HomePage;



public class DriverFactory {
	
static WebDriver driver;

public HomePage Hp;


	
	public static void createInstance(String browser)
	{
		switch(browser) {
		case "chrome":
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\chromedriver-win64\\chromedriver.exe");
         driver = new ChromeDriver();
         DriverManager.setDriver(driver);
         driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String Filepath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(Filepath), 
			StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	
	//{map, map}

	}
	
	
     @BeforeMethod(alwaysRun = true)
	public HomePage launchApplication() throws IOException
	{
		
		DriverFactory.createInstance("chrome");
		driver= DriverManager.getDriver();
		  Hp = new HomePage(driver);
		 
		return Hp;
	
		
	}

     @AfterMethod(alwaysRun=false)
 	
 	public void tearDown()
 	{
 		driver.close();
 	}

}
