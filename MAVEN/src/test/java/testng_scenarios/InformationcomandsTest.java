package testng_scenarios;

import org.testng.annotations.Test;

import java.security.KeyStore.Entry.Attribute;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class InformationcomandsTest {
	WebDriver driver;
	
  @Test
  public void spicejetinformation() {
	 String str=driver.findElement(By.id("u_0_2")).getAttribute("type");
	 System.out.println(str);
	 String str1= driver.findElement(By.id("u_0_2")).getAttribute("value");
	 System.out.println(str1);
	 System.out.println(driver.getTitle());
	 System.out.println(driver.getCurrentUrl());
	// System.out.println(driver.getPageSource());
	 String str2=driver.findElement(By.name("websubmit")).getText();
	 System.out.println(str2);
	 List<WebElement> str3=new Select(driver.findElement(By.xpath(".//select[@id='month']"))).getOptions();
	
	 System.out.println(str3.size());
	 for (int i = 0; i < str3.size(); i++) {
	 	
	 	if(str3.get(i).getText() != null) // it will get all dropdwon information
	 	{
	 	System.out.println(str3.get(i).getText());// to prin
	 	}
	 }
  }
  
  @BeforeTest
  public void browser() {
	  System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.navigate().to("http://www.fb.com");
	  driver.manage().window().maximize();
	    
  }

}
