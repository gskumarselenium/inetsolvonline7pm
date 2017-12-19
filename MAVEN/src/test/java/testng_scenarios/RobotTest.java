package testng_scenarios;

import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.InputEvent;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class RobotTest {
	  WebDriver driver;
	  
  @Test
  public void f() throws AWTException, Exception {
	  Robot rb=new Robot();
	   driver.findElement(By.xpath(".//*[@id='exp_new']")).click();
	  	  driver.findElement(By.xpath("//a[text()='CONTINUE TO LOGIN']")).click();
	  	  Thread.sleep(2000);
	  	  driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("selenium");
	  	  
	  	  driver.findElement(By.name("password")).sendKeys("inetsolv");
	  	rb.keyPress(KeyEvent.VK_ENTER);
	  	rb.keyRelease(KeyEvent.VK_ENTER);
	  	Thread.sleep(2000);
	  	driver.findElement(By.linkText("Home")).click();
	  	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.findElement(By.linkText("Corporate Website")).click();
	  
	  rb.mouseWheel(10);
	 	Thread.sleep(2000);
	 	rb.mouseWheel(-10);
  }
  @BeforeTest
  public void beforeTest() {
	
		 System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
			driver=new ChromeDriver();	
			  driver.get("https://www.onlinesbi.com");			
		        driver.manage().window().maximize();	
  }

}
