package com.gmail.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserUtils {
	
	public static WebDriver driver;
	
	public static WebDriver browserStart(String browsername,String url) {
		if(browsername.equalsIgnoreCase("mozilla")) {
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/nagendra/Downloads/chromedriver");
			driver=new ChromeDriver();
		}
		else {
			driver=new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}
	

}
