import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ProductValueCheck {
	
	static String baseUrl= "http://live.guru99.com/index.php/";
	
  @Test
  public void toVerifyCost() {
	  
	  WebDriver driver = new ChromeDriver ();
	  driver.get(baseUrl);
	  driver.findElement(By.className("level0")).click();
	  String priceOnMpage= driver.findElement(By.className("price")).getText();
	  driver.findElement(By.linkText("SONY XPERIA")).click();
	  String priceOnProductPage= driver.findElement(By.className("price")).getText();
	  Assert.assertEquals(priceOnMpage, priceOnProductPage);
	  driver.close();
	  
  }
  @BeforeTest
  public void setters2() {
	  System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
  }

  @AfterTest
  public void afterTest() {
	  
  }

}
