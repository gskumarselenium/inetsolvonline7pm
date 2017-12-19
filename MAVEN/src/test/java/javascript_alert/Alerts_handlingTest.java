package javascript_alert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Alerts_handlingTest {
	WebDriver driver;
	
  @Test(priority=0)
    public void onewaysearch() {
	  driver.findElement(By.xpath(".//input[@id='ctl00_mainContent_rbtnl_Trip_1' and @type='radio']")).click();
	  driver.findElement(By.xpath(".//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	  driver.findElement(By.linkText("Hyderabad (HYD)")).click();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.findElement(By.linkText("Bengaluru (BLR)")).click();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.findElement(By.linkText("28")).click();
	  new Select(driver.findElement(By.xpath(".//select[@id='ctl00_mainContent_ddl_Adult']"))).selectByVisibleText("9 Adults");
	  new Select(driver.findElement(By.xpath(".//select[@id='ctl00_mainContent_ddl_Child']"))).selectByVisibleText("1 Child");
	  driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_btn_FindFlights']")).click();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }
  
  @Test(priority=1)
 
    public void alert(){
	  try{
		  
	  String str; // variable declaration
	 str=driver.switchTo().alert().getText(); // to capture alert message and store in str variable
	 System.out.println(str); // to print the alert from str variable
	 driver.switchTo().alert().accept(); //to click on ok button
	  //driver.switchTo().alert().dismiss(); // to click on cancel button
  }
	  catch(Exception e){
		  e.printStackTrace(); // printstack trace  is amethod and will help you to understand where the actual problem occured.
	  }
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
	  driver.quit();
  }

}
