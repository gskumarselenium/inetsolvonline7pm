package testng_scenarios;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestngGroupTest {
	
  @Test(priority=0,groups="this is group1")
  public void f() {
	  System.out.println("welcome");
  }
  
  @Test(priority=1,groups="this is group2")
  public void g(){
	  System.out.println("inetsolv");
  }
  
  @Test(priority=3,groups="this is group1")
  public void h(){
	  System.out.println("selenium");
  }
  
  @Test(priority=2,groups="this is group2")
  public void i(){
	  System.out.println("automation");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("hi...");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("bye...");
  }

}
