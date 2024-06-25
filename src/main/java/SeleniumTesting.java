import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTesting {

	public static void main(String[] args) {  
        
	    
		
		 System.setProperty("webdriver.chrome.driver", 
		    		"C:\\Users\\Lingaraju\\Desktop\\Sree\\chromedriver.exe");  
		      WebDriver driver = new ChromeDriver();
		      String url = "https://www.tutorialspoint.com/index.htm";
		      driver.get(url);
		      driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		      // identify element
		      WebElement l = driver.findElement(By.id("gsc-i-id1"));
		      // enter texts
		      l.sendKeys("Selenium");
		      // get value attribute with getAttribute()
		      String val = l.getAttribute("value");
		      System.out.println("Entered text is: " + val);
		      driver.quit();
		   }

}
