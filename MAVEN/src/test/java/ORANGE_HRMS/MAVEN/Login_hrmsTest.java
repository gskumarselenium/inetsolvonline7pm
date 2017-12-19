package ORANGE_HRMS.MAVEN;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Login_hrmsTest {
	WebDriver driver;	
	
	public void takescreenshot(String str) throws Exception{
			
		DateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss"); // date and time format specification
		Date d=new Date();// it will collect the current system date
		String time=df.format(d);
		System.out.println(time);
		
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // to capture screenshot	
		//copy the screenshot from variable f to custom location.
		FileUtils.copyFile(f, new File("E:\\SELENIUM WORKSPACE 2017\\INETSOLV_ONLINE\\MAVEN\\screenshots\\"+str+time+".png"));
	}
	
	
	 @Test(priority=0)
	  public void login() throws Exception {
		  driver.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("Admin");
		  driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("admin");
		  driver.findElement(By.xpath(".//*[@id='btnLogin']")).click();
		  takescreenshot("login");
	  }
	  
	@Test(priority=1,enabled=true,description="this is for leave assignment")
	  public void Assignleave() throws Exception{
		  driver.findElement(By.xpath(".//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[1]/div/a/img")).click();
		  driver.findElement(By.id("assignleave_txtEmployee_empName")).sendKeys("linda");
		  driver.findElement(By.id("assignleave_txtEmployee_empName")).sendKeys(Keys.TAB);
	  new Select(driver.findElement(By.xpath(".//*[@id='assignleave_txtLeaveType']"))).selectByVisibleText("Maternity US");
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.findElement(By.linkText("view details")).click();
	  driver.findElement(By.xpath(".//*[@id='closeButton']")).click();
	  driver.findElement(By.xpath(".//*[@id='assignleave_txtFromDate']")).click();
	  driver.findElement(By.linkText("26")).click();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.findElement(By.xpath(".//*[@id='assignleave_txtToDate']")).clear();
	  driver.findElement(By.xpath(".//*[@id='assignleave_txtToDate']")).sendKeys("2017-10-30");
	  driver.findElement(By.linkText("30")).click();
	  driver.findElement(By.xpath(".//*[@id='assignleave_txtComment']")).sendKeys("this is linda anderson");
	  driver.findElement(By.xpath(".//*[@id='assignBtn']")).click();
	  driver.findElement(By.xpath(".//*[@id='confirmOkButton']")).click();
	  takescreenshot("assign leave");
	    }
 
	@BeforeTest
 
  public void browser() {
	  System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.navigate().to("http://opensource.demo.orangehrmlive.com/");
	  driver.manage().window().maximize();
	    
  }

  @AfterTest
  public void afterTest() throws Exception {
	  driver.findElement(By.linkText("Welcome Admin")).click();
	 // driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='welcome-menu']/ul/li[2]/a")).click();
	  
	  
  }

}
