package com.testing.flightbook;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class StreamExample {

	static WebDriver driver;
	
	public static void data_fetch() throws InterruptedException {
		
		// Disable chrome notifactions popup
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		driver.get("https://www.wego.co.in");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[id='outboundSearchQuery']")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[id='outboundSearchQuery']")).sendKeys("Delhi");
		Thread.sleep(3000);
		List<WebElement> data_list = driver.findElements(By.id("outboundSearchQueryList"));
		for (int i = 0; i < data_list.size(); i++) {
			Thread.sleep(1000);
			String matching = "Ghaziabad, India";
			String search_list = data_list.get(i).getText();
			//System.out.println("search_list >> "+search_list);
			System.out.println("Before enter into if loop..");
			if (search_list.equals(matching)) {
				System.out.println("Enter into if loop..");
				 String data = driver.findElements(By.xpath("//div[@data-pw='locationPicker_placeSuggestion']")).get(i).getText();
				 System.out.println("data >> "+data);
				 break;
			}
			
		}

//		WebElement sorted_list = (WebElement) data_list.stream().map(p->p.getText().contains("Delhi Airport, India")).collect(Collectors.toList());
//		System.out.println(">>"+sorted_list);

	}

	public static void main(String[] args) throws InterruptedException {
		data_fetch();
	}

}
