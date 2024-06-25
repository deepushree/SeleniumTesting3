package com.testing.flightbook;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewTabs {
	WebDriver driver;

	NewTabs() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.wego.co.in");
	}

	public void switchingtabs() {
		driver.manage().window().maximize(); // maximize the window
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS); // Implict wait

		// Switch to new tab by using link
		driver.findElement(By.linkText("Hotels")).sendKeys(Keys.CONTROL, Keys.ENTER);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switches to new tab
		driver.findElement(By.id("destinationSearchQuery")).click();
		driver.switchTo().window(tabs.get(0)); // switches to new tab

	}

	public static void main(String[] args) {
		NewTabs newTabs = new NewTabs();
		newTabs.switchingtabs();
	}

}
