package Com.kite.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.kite.qa.base.TestBase;
import Com.kite.qa.pages.HomePage;
import Com.kite.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
	loginpage =	new LoginPage();
	homepage =  new HomePage();
	
	}
	
	@Test
	public void HomepagevalidateUserId() throws InterruptedException {
	homepage.validateKiteUserID1(props.getProperty("Username"),props.getProperty("Password"),props.getProperty("PIN"));
	Assert.assertTrue(true);
	
	}
	
	@AfterMethod
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(2000);
		
		driver.quit();
	}
}
