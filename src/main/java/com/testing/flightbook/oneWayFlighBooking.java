package com.testing.flightbook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class oneWayFlighBooking {
	static WebDriver driver;
	static JavascriptExecutor executor1 = (JavascriptExecutor) driver;
	static {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver();
		driver.get("https://www.wego.co.in/");
		driver.manage().window().maximize();
//		WebElement gettextData = driver.findElement(By.cssSelector("div[class='description']"));
//		System.out.println(" gettextData >>>> "+gettextData.getText());
//		if(gettextData.getText().contains("Get latest Deals on Flights and Hotels from Wego. Click")) {
//			driver.findElement(By.id("allow")).click();
//		}else {
//			System.out.println("Notification is not displayed while executing..");
//		}
	}

	public static void onewaybooking() throws InterruptedException {

		WebElement main_data = driver.findElement(By.xpath("//div[@class='QuSmHFjB5BOx11SvNIV3']"));
		System.out.println(" >>> ++++ " + main_data.getText());
		Thread.sleep(1000);
//		if(main_data.getText().equalsIgnoreCase("Discover the real value of travel")) {
//			WebElement notification_data = driver.findElement(By.className("wrapper"));
//			notification_data.click();
//			driver.findElement(By.xpath("//*[@id='allow']")).click();
//			System.out.println("Inside verify the notification...");
//			
//		}else {
//			System.out.println("Notification didnt displayed...");
//		}
		Thread.sleep(1000);
		driver.findElement(By.className("c3rD1hcl4KOuj3QJqIhA")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[data-pw='searchForm_oneWay']")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("outboundSearchQuery")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("P4rKBkFmrKv8JqDfjjOS")).click();
		Thread.sleep(1000);
		List<WebElement> getlist = driver.findElements(By.className("grimIUnYfnbX9fDeJw8K"));

		for (WebElement option : getlist) {
			System.out.println(" From option >> " + option.getText());
			Thread.sleep(1000);
			if (option != null) {
				System.out.println("Inside if .... ");
				driver.findElement(By.xpath("(//*[@class='LMIHbU8OifNpK30_y6Oi'])[9]")).click();
				break;
			}
		}

	}

	public static void onewaytobooking() throws InterruptedException {
		driver.findElement(By.id("inboundSearchQuery")).click();
		Thread.sleep(1000);
		List<WebElement> from_oneway = driver.findElements(By.id("inboundSearchQuery"));
		//from_oneway.stream().filter(p->p.equals(from_oneway))
		for (WebElement options : from_oneway) {
			System.out.println(" To option >> " + options.getText());
			options.getText();
			if (from_oneway != null) {
				System.out.println(" To option >> " + options.getText());
				driver.findElement(By.xpath("(//*[@class='LMIHbU8OifNpK30_y6Oi'])[9]")).click();
				Thread.sleep(1000);
			}
		}
	}

	public static void selectAdults_oneway() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Inside selectAdults_oneway method...");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(1000);
		driver.findElement(By.className("dvaNnCiBXb6dFdBLR8Re")).click();
		Thread.sleep(1000);
		int i = 1;
		while (i <= 2) {
			driver.findElement(By.className("gvC_jym6919cQYQsoZjp")).click();
			i++;
		}
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[data-pw='noOfPassengers_applyBtn']")).click();
		Thread.sleep(1000);
		boolean data = driver.findElement(By.className("e9bkQONmwHEvxYBKjFyY")).isSelected();
		System.out.println(" >> ++ " + data);
		driver.findElement(By.className("e9bkQONmwHEvxYBKjFyY")).click();
		System.out.println(" >> ++ " + data);
	}

	public static void paymentSelectionCard() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div[data-pw='searchForm_paymentMethods']")).click();
		Thread.sleep(2000);
		List<WebElement> payment_list = driver.findElements(By.className("_nadRfLCQ3VmkFhmTjR0"));
		Thread.sleep(2000);
		// Get list of payment options
		driver.findElement(By.cssSelector("div[data-pw='paymentMethods_showMoreBtn']")).click();
		Thread.sleep(2000);

		for (int j = 0; j < payment_list.size(); j++) {
			
			List<WebElement> checked_list = driver
					.findElements(By.cssSelector("div[data-pw='searchForm_paymentMethodChecked']"));
			for (int x = 0; x < checked_list.size(); x++) {
				System.out.println(" Verifying thr checked box >> " + checked_list.get(x).getText());
				driver.findElement(By.cssSelector("div[data-pw='searchForm_paymentMethodChecked']")).click();
			}

			List<WebElement> payment_selection = driver
					.findElements(By.cssSelector("div[data-pw='searchForm_paymentMethodUnchecked']"));
			for (int y = 0; y < payment_selection.size(); y++) {
				if (payment_selection.get(y).getText().contains("UPI")) {
					Thread.sleep(1000);
					driver.findElements(By.cssSelector("div[data-pw='searchForm_paymentMethodUnchecked']")).get(y)
							.click();
				}
			}

			JavascriptExecutor executor2 = (JavascriptExecutor) driver;
			executor2.executeScript("window.scrollBy(0,480)", "");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("button[data-pw='paymentMethod_applyBtn']")).click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-600)", "");
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static void toDepartReturn() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(1000);
		//String city = "Dubai, United Arab Emirates";
		//driver.findElement(By.id("inboundSearchQuery")).click();
		//driver.findElement(By.id("inboundSearchQuery")).sendKeys("Dubai");
		//Thread.sleep(2000);
		//List<WebElement> listofcity = driver.findElements(By.id("inboundSearchQueryList"));
		//Thread.sleep(2000);
//		for(int z=0;z<listofcity.size();z++) {
//			System.out.println("Inside for loop toDepartReturn >> ");
//			System.out.println(listofcity.get(z).getText());
//			String citylist = listofcity.get(z).getText();
//			System.out.println(" citylist >>> "+citylist);
//			if(citylist.contains(city)) {
//				Thread.sleep(1000);
//				driver.findElements(By.id("inboundSearchQueryList")).get(z).click();
//			}
//		
//		Thread.sleep(1000);
//		driver.findElement(By.className("dvaNnCiBXb6dFdBLR8Re")).click();
//		Thread.sleep(1000);
//		int i=3;
//		for(int j=1;j<=i;j++) {
//			//driver.findElement(By.className("gvC_jym6919cQYQsoZjp")).click();	
//		}
		Thread.sleep(1000);
		driver.findElement(By.className("dvaNnCiBXb6dFdBLR8Re")).click();
		driver.findElement(By.cssSelector("div[data-pw='searchForm_noOfPassenger']")).click();
		Thread.sleep(1000);
		//String childrenlist = driver.findElement(By.cssSelector("div[data-pw='noOfPassengers_children']")).getText();
		//System.out.println("childrenlist >> "+childrenlist.trim());
		List<WebElement> childrenlist1 = driver.findElements(By.cssSelector("div[data-pw='noOfPassengers_children']"));
		
		for(int c=0;c<childrenlist1.size();c++) {
			String getData = childrenlist1.get(0).getText();
			System.out.println(">>>> "+childrenlist1.get(0).getText());
			System.out.println(">>>> "+getData.contains("Children"));
		}
	}

	public static void main(String[] args) throws InterruptedException {
//		onewaybooking();
//		onewaytobooking();
//		selectAdults_oneway();
		paymentSelectionCard();
//		toDepartReturn();
	}
}
