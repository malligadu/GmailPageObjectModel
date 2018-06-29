package com.gmail.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmail.utils.BaseTestCase;

public class GmailUserLoginPage extends BaseTestCase {
	
	WebDriver driver;
	
	 By signin=By.id("headingText");
     By subText=By.xpath("//div[@id='headingSubtext']/content");
	 By username=By.id("identifierId");
	 By forget_link=By.xpath("//*[text()='Forgot email?']");
	 By next_button=By.xpath("//*[text()='Next']");
	 By password=By.name("password");
	public GmailUserLoginPage(WebDriver driver) throws Exception{
		this.driver=driver;
	}
	
	public void loginGmail() throws InterruptedException {
		
		
		
		String Signinmsg=driver.findElement(signin).getText();
		System.out.println(" display message is: ========= "+Signinmsg);
		String subText1=driver.findElement(subText).getText();
		System.out.println("sub text message: ========= "+subText1);
		
		driver.findElement(username).sendKeys(p.getProperty("user"));
		driver.findElement(next_button).click();
		String msg=driver.findElement(signin).getText();
		System.out.println(" display message is: ========= "+msg);
		
		driver.findElement(password).sendKeys(p.getProperty("pwd"));
		//Thread.sleep(3000);
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(next_button));
		driver.findElement(next_button).click();
		}

}
