package testng_scenarios;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class ValidationCommandsTest {
	WebDriver driver;
	
  @Test
  public void validatingoneway() {
	// driver.findElement(By.xpath(".//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click(); // to click on roundtrip
	   driver.findElement(By.xpath(".//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click(); // to click on oneway
	 boolean str= driver.findElement(By.xpath(".//input[@id='ctl00_mainContent_txt_Todate']")).isDisplayed();
	 if(str)
	 {
		 System.out.println("to date picker available");
	 }
	 else
	 {
		 System.out.println("to date picker not available");
	 }
	// driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_chk_IndArm'][@type='checkbox']")).click();
	 if(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_chk_IndArm'][@type='checkbox']")).isSelected()){
		 System.out.println("selected the indian armed forces");
	 }
	 else
	 {
		 System.out.println("not selected indian army forces");
	 }
	 
	 
	 
  }
  @BeforeTest
  public void browser() {
	  System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.navigate().to("http://www.spicejet.com");
	  driver.manage().window().maximize();
	    
  }


}
