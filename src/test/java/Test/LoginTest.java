package Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Configurations.DriverFactory;


public class LoginTest extends DriverFactory {
	
	

	
	
	
	
	@Test (dataProvider="getData" , invocationCount = 1)
	public void loginTest(HashMap<String,String> input) throws InterruptedException {
		Hp.Goto();
		Hp.Enter_EmailAddress(input.get("email"));
		Hp.Enter_Password(input.get("pass"));
		//Hp.click_On_rememberMe_checkbox();
		Hp.click_On_Cntinue_button();
		System.out.println(input.get("mb")+" "+input.get("tb"));
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data= getJsonDataToMap("C:\\Users\\hp\\eclipse-workspace\\Final\\src\\test\\java\\Utils\\Login.json");
		//return new Object[][]  {{data.get(0)} };
		return new Object[][]  {{data.get(1)},{data.get(0)}, {data.get(2)} };
	}



	

}
