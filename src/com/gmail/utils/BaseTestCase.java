package com.gmail.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTestCase {
	public Properties p;
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentHtmlReporter htmlreport;
	public ExtentTest test;
	
	public BaseTestCase() throws IOException {
		 p=new Properties();
		p.load(new FileInputStream(System.getProperty("user.dir")+"/src/com/gmail/properties/Gmail.properties"));
	}
	
	public WebDriver driver() {
		return driver;
	}
	
	@BeforeMethod
	public void setUp() {
		driver=BrowserUtils.browserStart(p.getProperty("browsername"), p.getProperty("url"));
		
		 htmlreport=new ExtentHtmlReporter("./reports/"+new Date().toString()+".html");
		 extent=new ExtentReports();
		 extent.attachReporter(htmlreport);
		 test=extent.createTest(new Date().toString());
		 test.log(Status.INFO, "browser started");
		 test.log(Status.INFO, "open the url");
		 test.log(Status.INFO, "doing operations");
		 test.log(Status.INFO, "close the browser");
		 
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
		String path=screenshot();
		test.fail("fail report", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		//test.pass("pass report", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		extent.flush();
		driver.quit();
		
	}

	public String screenshot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshot/"+new Date().toString()+".png";
		
		File dest=new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
