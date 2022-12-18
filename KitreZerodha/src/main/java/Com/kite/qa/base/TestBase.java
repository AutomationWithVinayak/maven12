package Com.kite.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Com.kite.qa.Util.TestUtil;
import net.bytebuddy.utility.RandomString;

public class TestBase {

	public static WebDriver driver;
	public static Properties props;


	public TestBase() throws IOException {

		props =new Properties();

		FileInputStream ip = new FileInputStream("C:\\Users\\hp elitebook\\eclipse-workspace\\KitreZerodha\\src\\main\\java\\Com\\kite\\qa\\config\\config.properties");

		props.load(ip);
	}

	@SuppressWarnings("deprecation")
	public static void initialization() { 
        System.out.println(" ");
		System.setProperty("webdriver.chrome.driver", "C://installer//chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

		driver.get(props.getProperty("url"));

	}
	
	public String getScreenshotPath(String testCaseName) throws IOException {
		
	
	
	TakesScreenshot ts= (TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	
    String Random=RandomString.make(10);
    String destinationFile= System.getProperty("user.dir")+"\\reports\\"+testCaseName+""+Random+".png";
	FileUtils.copyFileToDirectory(source, new File(destinationFile));
    return destinationFile;
	
    
//    File dest = new File("C:\\Users\\hp elitebook\\eclipse-workspace\\KitreZerodha\\Screenshot"+testCaseName+Random+".jpg");
//	FileHandler.copy(source, dest);
	
	
    
	

	
	
//	TakesScreenshot ts= (TakesScreenshot) driver;
// 	
// 	File source = ts.getScreenshotAs(OutputType.FILE);
// 	
//	String Random = RandomString.make(10);
//	
// 	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+""+Random+".png";
// 	
// 	FileUtils.copyFile(source,new File(destinationFile));
// 	return destinationFile;

	}
}
