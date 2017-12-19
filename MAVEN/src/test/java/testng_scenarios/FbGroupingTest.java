package testng_scenarios;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class FbGroupingTest {
	WebDriver driver;
	
  @Test(priority=0,groups="regression")
  public void login() throws Exception {
	  System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.navigate().to("http://www.fb.com");
	  driver.manage().window().maximize();
  driver.findElement(By.name("email")).sendKeys("inetsolv@gmail.com");
  driver.findElement(By.name("pass")).sendKeys("25641333");
  driver.findElement(By.xpath(".//*[@type='submit'][@value='Log In']")).click();
  Thread.sleep(3000);
  }
 
  @Test(priority=1,groups="sanity")
  public void Signupforaccount(){
	  driver.findElement(By.xpath(".//*[@id='u_0_h'][@name='firstname']")).sendKeys("inetsolv");
  }
  
  @Test(priority=2,groups="regression")
  public void messenger(){
	  driver.findElement(By.linkText("Messenger")).click();
  }
  

}
