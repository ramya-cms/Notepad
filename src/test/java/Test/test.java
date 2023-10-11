package Test;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {
	
	public static void main (String [] args) throws Exception{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//To open URL
		driver.get("http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html");
		//Download Text File
		driver.findElement(By.xpath("//*[@id='post-body-5864649494765988891']/div[1]/form/div[1]/a[1]")).click();
		//To call the AutoIt script
		Runtime.getRuntime().exec("D:\\Softwares\\AutoIt3\\SciTE\\DownloadFile.exe");
		//'close' method is used to close the browser window
		//driver.close();
	}
	
}
    	
