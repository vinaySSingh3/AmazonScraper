package testCase;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.browserCollection;
import pageObject.scrapePageObject;

public class scrapeInfo extends browserCollection{
	@BeforeMethod
	public void openBrowser() {
		browserCollection brc= new browserCollection();
		brc.chromeSetup();
	}
	@Test
	public void phonesInfo() throws InterruptedException, IOException {
		scrapePageObject scrp=new scrapePageObject(driver);
		scrp.openHomepage();
		
		scrp.search("iphone");			//search product
		scrp.range("40000","90000");	//give range for product price (optional)
		scrp.scrapper();				//scrape data
		scrp.wait(2);					// wait 2 seconds
		
		scrp.search("32 inch TV");		//search other product
		scrp.scrapper();				//scrape data
	}
}

