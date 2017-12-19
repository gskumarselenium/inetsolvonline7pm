package actions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Actions_spicejetTest {
	WebDriver driver;
	
	
  @Test(priority=0)
  public void action() throws Exception {
	  Actions a=new Actions(driver); // actions is a class to handle actions from keybaord and mouse
	  Thread.sleep(2000);
	  
	  Assert.assertEquals("SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets", driver.getTitle());
	 // driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	  a.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
	Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[contains(text(),'Hot Meals')]")).click();
	 //keyboard action//
	  a.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();//  it will click ctrl+End button to navigate to end of page
	  Thread.sleep(2000);
	  a.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
  }
  
  @BeforeTest
  public void browser() {
	  System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.navigate().to("http://www.spicejet.com");
	  driver.manage().window().maximize();
	    
  }
  @AfterTest
  public void afterTest() {
  }

}
