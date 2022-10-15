package testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.browserCollection;

import pageObject.loginPageObject;

public class login extends browserCollection{
	@BeforeMethod
	public void openBrowser() {
		browserCollection brc= new browserCollection();
		brc.chromeSetup();
	}
	
	@Test
	public void loginAmazon() throws InterruptedException {
		loginPageObject log = new loginPageObject(driver);
		log.enterUsername("YOUR USER NAME");	//pass username
		log.enterPassword("YOUR PASSWORD");		//pass password
		log.wait(2000);							//wait 2 seconds	
	}
}