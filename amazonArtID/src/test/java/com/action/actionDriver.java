package com.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.browserCollection;

public class actionDriver {
	public WebDriver driver;
	
	public actionDriver() {
		driver=browserCollection.driver;
	}
	
	public void enter(By locator, String value, By clickLocator) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
		driver.findElement(clickLocator).click();
	}
	public void enter(By locator, String value) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);	
	}
	public void enter(By clickLocator) {
		driver.findElement(clickLocator).click();
		
	}
	
	

	
	
	
}
