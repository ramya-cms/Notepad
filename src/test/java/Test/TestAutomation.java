package Test;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;

public class TestAutomation {

	public static WebDriver driver;
	public WebElement webElement;
	public static AutoItX x;

	@BeforeTest
	public  /*static*/ void setUpBeforeClass() 
	{

		configure();
	}

	@BeforeSuite
	public void beforeTest() {
		
		if(TestCommons.WEBDRIVER_TO_USE.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if (TestCommons.WEBDRIVER_TO_USE.equals("gecko")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		x = new AutoItX();
	}

	@AfterTest
	public void afterEachTest() {
		driver.close();
	}

	@AfterMethod
	public /*static*/ void tearDownAfterClass() {
		driver.quit();
	}

	private  /*static*/ void configure() {

		String pathToJacobLibrary;
		String pathToChromeDriver;
		String pathToGeckoDriver;

		if (jvmBitVersion().contains("32")) {
			pathToJacobLibrary = TestCommons.JACOB_DLL_FILE_X86;
			pathToChromeDriver = TestCommons.PATH_TO_CHROMEDRIVER_X86;
			pathToGeckoDriver = TestCommons.PATH_TO_GECKODRIVER_X86;
		} else {
			pathToJacobLibrary = TestCommons.JACOB_DLL_FILE_X64;
			pathToChromeDriver = TestCommons.PATH_TO_CHROMEDRIVER_X64;
			pathToGeckoDriver = TestCommons.PATH_TO_GECKODRIVER_X64;		
		}

		System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
		System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);
		File file = new File(pathToJacobLibrary);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

	}

	public  /*static*/ String jvmBitVersion() {
		   System.out.println(System.getProperty("sun.arch.data.model"));
		return System.getProperty("sun.arch.data.model");
	}
	
	protected  /*static*/ void sleep(long millis) {

		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}