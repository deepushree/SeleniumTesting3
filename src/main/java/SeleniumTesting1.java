import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTesting1 {
	public static void main(String[] args) throws InterruptedException {

		SeleniumTesting1 t = new SeleniumTesting1();
		// t.testing();
		// t.drivertest();
		// t.googleSearch();
		//Samplerequest();
		//Samplerequest_1();
		W3schools();
	}

	public void drivertest() throws InterruptedException {
		// Setting the driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lingaraju\\Desktop\\Sree\\chromedriver.exe");

		// Creating WebDriver instance
		WebDriver driver = new ChromeDriver();

		// Navigate to web page
		driver.get("https://demoqa.com/login");

		// Maximizing window
		driver.manage().window().maximize();

		// Retrieving web page title
		String title = driver.getTitle();
		System.out.println("The page title is : " + title);

		// Locating web element
		WebElement uName = driver.findElement(By.xpath("//*[@id='userName']"));
		System.out.println(" >>>> " + uName.getAccessibleName());
		WebElement pswd = driver.findElement(By.cssSelector("'#login'"));
		// WebElement loginBtn = driver.findElement(By.xpath("//*[@id='login']"));

		Thread.sleep(1000);
		WebElement buttonlogin = driver.findElement(By.xpath("//*[@id='login']"));
		// WebElement buttonlogin = driver.findElement(By.linkText("Login"));
		// WebElement buttonlogin =
		// driver.findElement(By.xpath("//button[@id='login']"));
		// WebElement buttonlogin =
		// driver.findElement(By.xpath("//button[@id='login']"));
		// WebElement buttonlogin = driver.findElement(By.id("login"));
		// Peforming actions on web elements
		uName.sendKeys("testuser");
		pswd.sendKeys("Password@123");
		// loginBtn.click();

		System.out.println("Before clicking.......");
		buttonlogin.click();

		// Putting implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			System.out.println("Inside the try condition...");
			// Locating web element
			WebElement logoutBtn = driver
					.findElement(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']"));
			// Validating presence of element
			if (logoutBtn.isDisplayed()) {

				// Performing action on web element
				logoutBtn.click();
				System.out.println("LogOut Successful!");
			}
		} catch (Exception e) {
			System.out.println("Incorrect login....");
		}

		// Closing browser session
		// driver.quit();
	}

	public void testing() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lingaraju\\Desktop\\Sree\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		// Typing search keyword
		driver.findElement(By.name("q")).sendKeys("facebook");
		// Locating search button and click on it
		WebElement ele = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		ele.click();
	}

	public void googleSearch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lingaraju\\Desktop\\Sree\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		// Typing search keyword
		driver.findElement(By.name("q")).sendKeys("facebook");
		// Locating search button and click on it
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}

	public static void Samplerequest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lingaraju\\Desktop\\Sree\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
//		WebElement button = driver.findElement(By.xpath("//*[@id=\"main\"]/button"));
//		button.click();
		Thread.sleep(2000);
		WebElement forgotpassword = driver.findElement(By.linkText("Forgotten password?"));
		forgotpassword.click();
		WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/div[3]/div/div/div[1]"));
		loginbutton.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("Sreevachan1708@gmail.com");
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("Welcome@112233");

		WebElement button = driver.findElement(By.id("loginbutton"));
		button.click();
	}
	
	public static void Samplerequest_1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lingaraju\\Desktop\\Sree\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("sreevachan.j.m@gmail.com");
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("Jagaluru@17141988");

		WebElement button = driver.findElement(By.name("login"));
		button.click();
		
		WebElement getData = driver.findElement(By.linkText("Friend requests"));
		getData.click();
	
	}
	
	public static void W3schools() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lingaraju\\Desktop\\Sree\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/java/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement dropdownclick = driver.findElement(By.id("navbtn_tutorials"));
		dropdownclick.click();
		
		WebElement crossmark = driver.findElement(By.xpath("//*[@id='nav_tutorials']/div/span"));
		crossmark.click();
		
	}
}