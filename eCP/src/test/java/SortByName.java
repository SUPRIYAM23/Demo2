import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class SortByName {
	static String baseUrl= "http://live.guru99.com/index.php/";
	 static String homeTitle ="Home page";
	 static String mobilePgTitle ="Mobile";
	//static  WebDriver driver = new ChromeDriver ();
	
  /**
 * 
 */
@Test
  public static void toSortByName() {
	  WebDriver driver = new ChromeDriver ();
	  driver.get(baseUrl);
	  String actTitle =driver.getTitle();
	 try {
	  Assert.assertEquals(homeTitle, actTitle);
	
	  //Clicking on the Mobile Link
	  driver.findElement(By.className("level0")).click();
	  Assert.assertEquals(mobilePgTitle, driver.getTitle());
	
	  
	  Select sortBy=new Select(driver.findElement(By.cssSelector("select[title='Sort By']")));
	  sortBy.selectByVisibleText("Name");
	 
	 ArrayList <String> obtainedMobileList = new ArrayList<String>();
		List<WebElement> elementList= driver.findElements(By.cssSelector("li.item.last"));
				  for(WebElement we:elementList){
					  obtainedMobileList.add(we.getText());
		  }
		  ArrayList<String> sortedList = new ArrayList<String>();   
		  for(String s:obtainedMobileList){
		  sortedList.add(s);
		  }
		  Collections.sort(sortedList);
		  Assert.assertTrue(sortedList.equals(obtainedMobileList));
		  System.out.println("All products are sorted");
		  driver.close();
	  }
	  catch (Exception e) {
		  System.out.println("Page Title did not match" +actTitle);
		  driver.close();
	  }
	  
	  
 }
  @BeforeTest
  public  void setters() {
	  
	  System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	
	 
  }
 /* 
  public void getTitle()
  {
	  String actTitle =driver.getTitle();
  }
  */

  @AfterTest
  public void afterTest() {
	  
	  
  }
  
  

}
