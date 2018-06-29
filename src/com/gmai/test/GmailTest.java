package com.gmai.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gmail.java.ExampleInbox;
import com.gmail.java.GmailUserLoginPage;
import com.gmail.utils.BaseTestCase;

public class GmailTest extends BaseTestCase{

	public GmailTest() throws IOException {
		super();
		}
	@Test
	public void gmailTest() throws Exception {  
		
		GmailUserLoginPage login=new GmailUserLoginPage(driver);
		login.loginGmail();
		ExampleInbox inbox=new ExampleInbox(driver);
		String title=inbox.verifyTitle();
		System.out.println("inbox title: =========== "+title);
		String url1=inbox.verifyCurrentUrl();
		System.out.println("url =========== "+url1);
		Assert.assertEquals(p.getProperty("ExpectedTitle"), title);
		Assert.assertEquals(p.getProperty("ExpectedUrl"), url1);
		Assert.assertTrue(inbox.isLogoutDisplayed());
		//Assert.assertTrue(inbox.isLinkClickable());
		/*String tagname=inbox.isAnchorTag();
		System.out.println(" tag name: ========== "+tagname);*/
		System.out.println(" link is: ====== "+inbox.isAnchorTagEnabled());
		Assert.assertEquals("a",inbox.isAnchorTag());
		
	
	}
	

}
