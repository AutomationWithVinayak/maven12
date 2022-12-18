package Com.kite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.kite.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(id="userid")
	private WebElement Username;
	
	@FindBy(id="password")
	private WebElement Password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement LoginButton;
	
	@FindBy(id="pin")
	private WebElement Pin;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement ContinueButton;
	
	@FindBy(xpath ="//span[contains(text(),'GP8097')]")
	WebElement UserID1;
	
	
	

	public LoginPage() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String ValidateLoginPageTitle() throws InterruptedException {
		
		Thread.sleep(2000);
		
		return driver.getTitle();
	}
	
	public boolean ValidateLoginUserId(String UN, String PWD, String PIN) throws InterruptedException {
		
		Username.sendKeys(UN);
		Thread.sleep(3000);
		Password.sendKeys(PWD);
		Thread.sleep(3000);
		LoginButton.click();
		Thread.sleep(3000);
		Pin.sendKeys(PIN);
		Thread.sleep(3000);
		ContinueButton.click();
		
		return UserID1.isDisplayed();
		
		
		
		
		
	}
	

}
