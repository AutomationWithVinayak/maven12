package Com.kite.qa.TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import Com.kite.qa.base.TestBase;
import Com.kite.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	

	LoginPage loginpage;     // 1. Import LoginPageClass From Com.kite.qa.base Package (Globaly becuase we use Object name in Diff Diff Method)
	

	/*--------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	
	
	
	public LoginPageTest() throws IOException {                         // 2. import Constructor because we initiliaze the properrt in contructor , in TestBase Class From pakage Com.kite.qa.base , that variable name is probs 
		super();
		
	}
	
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	
	
	/*-----------------------------------------------------------------------------------------------------------------------------------------*/
	
 
	@BeforeMethod                             //@TestNg Annotation run this method before run of Evry test_Method --(@Test)
	public void setup() throws IOException {
		
		initialization();                                // setup use from testbase class in that this method is static & we extends this class in currunt class 
		log.info("driver is  initilization");
		loginpage = new LoginPage();
		
		
	}
	
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/	
	
	
	
	@Test                                                                 
	public void KiteUserID() throws InterruptedException {                         //use loginpage variable or object name of LoginPage POM class Alredr we decleare globaly see above we use props  varible name this extends from testbase class in that all properties contain like pass,user id , pin url etc.
		
	boolean UserId=loginpage.ValidateLoginUserId(props.getProperty("Username"),props.getProperty("Password"),props.getProperty("PIN"));
	Assert.assertTrue(true);  //(userid)
	log.info("KiteUserID");
	System.out.println("   ");
	
	}	
	

	
	/*------------------------------------------------------------------------------------------------------------------------------------------*/
	
	@Test
	public void LoginPageTitle() throws InterruptedException {
		
		String Title=loginpage.ValidateLoginPageTitle();              //call ValidateLoginPageTitle method from loginpage class
		Assert.assertTrue(false);
		
		log.info("LoginPageTitle");
		
	}
	
	/*---------------------------------------------------------------------------------------------------------------------------------------*/
	
	
	
	@AfterMethod
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(4000);
		driver.quit();
	}
	
}
