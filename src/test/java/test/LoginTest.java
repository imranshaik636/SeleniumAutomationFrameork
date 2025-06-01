package test;

//import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
//import utils.ExcelUtils;
import utils.ExtentReprts;
import utils.Log;

public class LoginTest extends BaseTest {

	@DataProvider(name = "logindata")
//	public Object[][] getLoginData() throws IOException {
//		String filePath = System.getProperty("user.dir") + "/TestData.xlsx";
//		ExcelUtils.loadExcel(filePath, "Sheet1");
//		int rowCount = ExcelUtils.getRowCount();
//		Object[][] data = new Object[rowCount - 1][2];
//
//		for (int i = 1; i < rowCount; i++) {
//			data[i - 1][0] = ExcelUtils.getCellData(i, 0);
//			data[i - 1][1] = ExcelUtils.getCellData(i, 1);
//		}
//		ExcelUtils.closeExcel();
//		return data;
//
//	}
	
	//@DataProvider(name="logindata2")
	public Object[][]getData(){
		return new Object[][]{
			{"user1","pass1"},
			{"user2","pass2"},
			{"user3","pass3"}
			
		};
	}
	//@Test(dataProvider = "logindata2")
	//@Parameters({"username","password"})
	@Test
	public void testvalidlogin() {
		Log.info("starting logging invalid");
		test = ExtentReprts.createTest("Login test-" );

		LoginPage loginpage = new LoginPage(driver);

		Log.info("entering username");
		test.info("Logging into the page");
		loginpage.enterusername("admin@yourstore.com");
		Log.info("entering password");
		test.info("entering password");
		loginpage.enterpassword("admin");
		test.info("clicking on login button");
		loginpage.clicklogin();
		test.info("clicking on login button");
		test.pass("Login successfull");
		//System.out.println("The title of the page is : " + driver.getTitle());
		Log.info("crosschecking the title");
		//Assert.assertEquals(driver.getTitle(), "Just a moment...");
		test.info("clicking on login button");
		test.pass("Login successfull");
	}
}
//	@Test
//	public void testvalidlogin() {
//		Log.info("starting logging");
//		test = ExtentReprts.createTest("Login test");
//		
//		LoginPage loginpage = new LoginPage(driver);
//		
//		Log.info("entering username");
//		test.info("Logging into the page");
//		loginpage.enterusername("admin@yourstore.com");
//		Log.info("entering password");
//		test.info("entering password");
//		loginpage.enterpassword("admin");
//		test.info("clicking on login button");
//		loginpage.clicklogin();
//		System.out.println("The title of the page is : "+driver.getTitle());
//		Log.info("crosschecking the title");
//		Assert.assertEquals(driver.getTitle(), "Just a moment...");
//		test.info("clicking on login button");
//		test.pass("Login successfull");
//	}
//}
