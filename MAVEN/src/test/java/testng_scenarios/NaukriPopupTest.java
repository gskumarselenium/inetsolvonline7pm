package testng_scenarios;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class NaukriPopupTest {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver;
		 System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
			driver=new ChromeDriver();		
		
        //Launching the site.				
            driver.get("https://www.naukri.com");			
        driver.manage().window().maximize();	
        System.out.println(driver.getTitle());
          
        String MainWindow=driver.getWindowHandle();		
		
        // To handle all new opened window.				
           Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
       
          while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                    // Switching to Child window
            	
                    driver.switchTo().window(ChildWindow);	   
                    Assert.assertEquals("Tech Mahindra", driver.getTitle());
                      driver.findElement(By.xpath("html/body/a/img")).click();		
                  Thread.sleep(2000);                       
                      // driver.findElement(By.name("btnLogin")).click();		
            	
                                
			// Closing the Child Window.
                        driver.close();//to close pop up window.		
            }		
        }		
        // Switching to Parent window i.e Main Window.
            driver.switchTo().window(MainWindow);				
    }
        
        

}
