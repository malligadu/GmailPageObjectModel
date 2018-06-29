package com.gmail.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExampleInbox {
	
	WebDriver driver;
	
	By logout_button=By.xpath("//*[contains(@title,'Google Account')]/span");
	By link=By.xpath("//*[@title='Gmail']");

	public ExampleInbox(WebDriver driver) {
		this.driver=driver;
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public String verifyCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isLogoutDisplayed() {
		return driver.findElement(logout_button).isDisplayed();
	}
	
	/*public boolean isLinkClickable() {
		
		WebElement link_button= new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(link));
		return link_button.isDisplayed();
	}*/
	
	public boolean isAnchorTagEnabled() {
		return driver.findElement(link).isEnabled();
	}
	
	public  String isAnchorTag() {
		return driver.findElement(link).getTagName();
	}
}
