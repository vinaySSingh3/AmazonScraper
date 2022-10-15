package pageObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.action.actionDriver;
import com.opencsv.CSVWriter;

public class scrapePageObject {
	public WebDriver driver;
	public actionDriver adriver;
	
	public scrapePageObject(WebDriver driver) {
		 this.driver=driver;
		 adriver=new actionDriver();
	}
	
	By searchbar= By.xpath("//*[@id=\"twotabsearchtextbox\"]");
	By submit=By.xpath("//*[@id=\"nav-search-submit-button\"]");
	By minValPath= By.xpath("//*[@id=\"low-price\"]");
	By maxValuePath=By.xpath("//*[@id=\"high-price\"]");
	By rangeSubmit=By.xpath("//*[@id=\"a-autoid-1\"]/span/input");

	String homepage="https://www.amazon.in/ref=nav_logo";	//redirect to home page first
	
	//Setup your path here 
	String csvPath="C:\\Users\\VINAY SINGH\\eclipse-workspace\\amazonArtID\\output\\";
	String searchValue;
	
	public void openHomepage() {
		driver.navigate().to(homepage);
	}
	
	//search product
	public void search(String searchValue) {
		this.searchValue=searchValue;
		adriver.enter(searchbar, searchValue, submit);
	}
	
	// give range (optional)
	public void range(String minVal, String maxVal) {
		adriver.enter(minValPath,minVal);
		adriver.enter(maxValuePath,maxVal);
		adriver.enter(rangeSubmit);
	}	
	
	//scrape data and save in .csv
	public void scrapper() throws IOException {
		String csv=csvPath+searchValue+".csv";
		System.out.println(csv);
		String productName;
		String productPrice;
		
		CSVWriter writer = new CSVWriter(new FileWriter(csv));
		List<String[]> data = new ArrayList<String[]>();
		
		for(int iterator=2;iterator<=20;iterator++) {
			try { productName = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div["+iterator+"]/div/div/div/div/div/div[2]/div/div/div[1]/h2")).getText();}
			catch(NoSuchElementException e) {productName = "Name Not Found";}
			
			try {productPrice=driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div["+iterator+"]/div/div/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]/a/span[1]/span[2]/span[2]")).getText();}
			catch(NoSuchElementException e) {productPrice = "Price Not Found";}
			
			data.add(new String[] {productName, productPrice});	
		}
		writer.writeAll(data);
		writer.close();
	}
	
	public void wait(int seconds) throws InterruptedException {
		Thread.sleep(seconds*1000);
	}
}
