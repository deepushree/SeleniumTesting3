package com.testing.flightbook;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlighBookingExample {

	static WebDriver driver;

	static {
		driver = new ChromeDriver();
		//System.out.println("static block called... ");
		driver.get("https://www.wego.co.in/");
		driver.manage().window().maximize();
	}

	public static void main(String[] args) throws InterruptedException {
		// flightbook();
		//hotelselection();
		onewayflight();
	}

	public static void hotelselection() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Hotels")).click();
		Thread.sleep(1000);
		
		int i=1;
		while(i<4) {
			driver.findElement(By.className("wFeoDfTPl0_Q2nQgzl3A")).click();
			Thread.sleep(1000);
			i++;
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='SQOdmOkvQkUo9dSrI2WA']/button[2]")).click();
		//Search button
		//driver.findElement(By.xpath("//div[@class='IGTqPYyht3nr97oMOctk']/button")).click();
		
		driver.findElement(By.className("vSZlELYMnb5m1ZWm5i8Y")).click();
		Thread.sleep(1000);
		//FromDate picker
		WebElement fromdate = driver.findElement(By.className("Pa29ddYZ3YFicPBiUZHJ"));
		fromdate.click();
		System.out.println(">>>> "+fromdate.getText());
		WebElement todate = driver.findElement(By.className("Pa29ddYZ3YFicPBiUZHJ"));
		System.out.println("todate >> "+todate.getText());
		Thread.sleep(2000);
		todate.click();
		//ToDate picker
		
		//driver.findElement(By.xpath("//div[@class='rEbH14PcQ_dr5fc01KJZ AcKqDvbYSjuanmjsGDiI']/div")).click();

//		WebElement fromDate = driver.findElement(By.id("rEbH14PcQ_dr5fc01KJZ"));  
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
//		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", fromDate);  
	}

	public static void flightbook() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lingaraju\\Desktop\\Sree\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wego.co.in/");
		driver.manage().window().maximize();

		// *[@id="webpush-prompt"]/div/div
		// System.out.println(driver.findElement(By.xpath("//*[@id='webpush-prompt']/div/div/text()[1]")).getText());

//		WebElement linkverify = driver.findElement(By.linkText("Get latest Deals on Flights and Hotels from Wego. Click Allow to subscribe."));
//		System.out.println(" >>> "+linkverify.getText());
		// *[@id="webpush-prompt"]/div/div
		// driver.findElement(By.xpath("//*[@id='webpush-prompt']/div/div"));
		// *[@id="deny"]

		// driver.findElement(By.xpath("//button[@class='MSQJDySSVNcBm1PwzZzH']")).click();
		// Thread.sleep(1000);
		// *[@id="layoutPortalRoot"]/div/form/div[1]/svg
		// driver.findElement(By.xpath("//*[@id=\"layoutPortalRoot\"]/div/form/div[1]/svg")).click();
		// *[@id="layoutPortalRoot"]/div/form/div[1]/svg

		// *[@id="webpush-prompt"]/div/div
		// *[@id="outboundSearchQuery"]

		// driver.findElement(By.linkText("Get latest Deals on Flights and Hotels from
		// Wego. Click Allow to subscribe."));
		// System.out.println(driver.findElement(By.xpath("//div[@class='description'])[1]")));
		// driver.findElement(By.xpath("//button[text()='Allow']")).click();
		// driver.switchTo().alert().getText();
		// driver.findElement(By.id("//button[@id='deny']")).getText();
		// System.out.println(driver.findElement(By.xpath("//div[@class='description']")).getText());
		Thread.sleep(1000);

//		driver.findElement(By.xpath("//i[@class='MwRaN58Qt1V_siorMPb4 IZmYwAwizZy8L23aAr6Q']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='outboundSearchQuery']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='outboundSearchQuery']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='outboundSearchQuery']")).sendKeys("Ind");
		System.out.println(" >>> ");
		List<WebElement> options = driver.findElements(By.xpath("//div[@id='outboundSearchQueryList']"));
		System.out.println("1st .....");
		Thread.sleep(2000);
		// driver.findElement(By.id("//div[@id='outboundItem-1']")).click();
		System.out.println("1st .....");
		for (WebElement option : options) {
			System.out.println("Inside for loop....." + option.getText());
//			Thread.sleep(1000);
			if (option.getText().equalsIgnoreCase("Indore, India\r\nIDR")) {
				System.out.println("Inside if loop.....");
				option.click();
				break;
			}
		}

//		//*[@id="webpush-prompt"]/div[2]
//		//*[@id="webpush-prompt"]/div/div/text()[1]
//		//*[@id="outboundSearchQuery"]
//		
	}

	public static void testWebAlert() throws InterruptedException {
		// clicking on try it button
		WebDriver driver = new ChromeDriver();
		driver.findElement(By.xpath("//button[@class='description']")).getText();
		Thread.sleep(5000);

		// accepting javascript alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// clicking on try it button
		driver.findElement(By.xpath("//button[contains(text(),'I'll do this later')]")).click();
		Thread.sleep(5000);

		// accepting javascript alert
		// driver.switchTo().alert().dismiss();

		// clicking on try it button
		// driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		// Thread.sleep(5000);

		// accepting javascript alert
		// System.out.println(driver.switchTo().alert().getText());
		// driver.switchTo().alert().accept();
	}

	public static void onewayflight() throws InterruptedException {
		driver.findElement(By.linkText("Hotels")).click();
		Thread.sleep(1000);
		//driver.findElement(By.linkText("Flights")).click();
		//driver.switchTo().alert().getText();
		driver.findElement(By.className("c3rD1hcl4KOuj3QJqIhA")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[data-pw='searchForm_oneWay']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#inboundSearchQuery")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#inboundSearchQuery")).sendKeys("Dubai");
		List<WebElement> to_oneway = driver.findElements(By.cssSelector("input#inboundSearchQuery"));
		System.out.println(" >>> "+to_oneway);
		Thread.sleep(1000);
//		for(WebElement option: to_oneway) {
//			System.out.println("Inside for loop....."+option.getText());
//			if (option.getSize() != null) {
//				System.out.println("Inside if loop.....");
//				//driver.findElement(By.cssSelector("div[data-pw='locationPicker_placeSuggestion']")).click();
//				if(option.getText().equalsIgnoreCase("Dubai International Airport, United Arab Emirates")) {
//					System.out.println("Inside another if loop.....");
//					option.click();
//					break;
//				}else {
//					System.out.println("If is not executed..");
//				}
//			}
//		}
		
		for (WebElement option : to_oneway) {
			System.out.println("Inside for loop....." +option.getText());
			String option_oneway = option.getText();
			option_oneway = option_oneway.substring(0);
			System.out.println(" >>> ....." +option_oneway);
			Thread.sleep(1000);
			if (option.getText().equalsIgnoreCase("Dubai International Airport, United Arab Emirates")) {
				System.out.println("Inside if loop.....");
				option.click();
				break;
			}
		}
		
	}
}
