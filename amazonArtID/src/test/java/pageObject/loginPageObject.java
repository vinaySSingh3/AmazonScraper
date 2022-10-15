package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.action.actionDriver;

public class loginPageObject {
	public WebDriver driver;
	public actionDriver adriver;

	By phoneNumberPath =By.xpath("//*[@id=\"ap_email\"]");
	By phoneNumberSubmitPath= By.xpath("//*[@id=\"continue\"]");
	
	By passwordPath= By.xpath("//*[@id=\"ap_password\"]");
	By passwordSubmitPath=By.xpath("//*[@id=\"signInSubmit\"]");
	
	public loginPageObject(WebDriver driver) {
		this.driver=driver;	
		adriver= new actionDriver();
	}
	
	public void enterUsername(String username) {
		adriver.enter(phoneNumberPath,username,phoneNumberSubmitPath);
	}
	
	public void enterPassword(String password) {
		adriver.enter(passwordPath, password,passwordSubmitPath);
	}
}
