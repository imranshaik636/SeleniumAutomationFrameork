package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void testvalidlogin() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername("admin@yourstore.com");
		loginpage.enterpassword("admin");
		loginpage.clicklogin();
		System.out.println("The title of the page is : "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...");

	}
}
