import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class QuickChecks {
  @Test
  public void f() {
	  WebDriver driver = new ChromeDriver ();
	  
	  driver.get("http://live.guru99.com/index.php/");
	  driver.findElement(By.className("level0")).click();
	 // WebElement sortList=;
	  
	  
	  Select sortBy=new Select(driver.findElement(By.cssSelector("select[title='Sort By']")));
	  sortBy.selectByVisibleText("Name");
	  
	  
	//  List<WebElement> elementList= driver.findElements(By.cssSelector("ul.products-grid products-grid--max-4-col first last odd"));


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
	  
	  
	  
	  }
//
  
  
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
  }

  @AfterTest
  public void afterTest() {
  }

}
