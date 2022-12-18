package Com.kite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.kite.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(id ="userid")
	WebElement Username;	
	

	@FindBy(id="password")
	WebElement Password;

	@FindBy(xpath ="//button[@type=\"submit\"]")
	WebElement LoginButton;

	@FindBy(id="pin")
	WebElement Pin;

	@FindBy(xpath ="//button[@type=\"submit\"]")
	WebElement ContinueButton;

	@FindBy(xpath ="//span[contains(text(),'GP8097')]")
	WebElement UserID2;

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public boolean validateKiteUserID1(String UN,String PWD,String PIN) throws InterruptedException {

		Username.sendKeys(UN);
		Thread.sleep(1000);
		Password.sendKeys(PWD);
		Thread.sleep(2000);
		LoginButton.click();
		Thread.sleep(2000);
		Pin.sendKeys(PIN);
		Thread.sleep(2000);
		ContinueButton.click();


		return UserID2.isDisplayed();
	}






}
