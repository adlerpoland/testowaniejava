package webdemo.seleniumDemo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchTest {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		//Od wersji selenium 3.0 samo FirefoxDriver nie wystarcza
		//Należy dodać sterownik geckodriver
		//Do pobrania tutaj: https://github.com/mozilla/geckodriver/releases
		//System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		//System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		System.setProperty("webdriver.opera.driver", "resources/operadriver");
		
		DesiredCapabilities c = DesiredCapabilities.opera();
		c.setCapability("opera.binary", "/usr/bin/opera");
		driver = new OperaDriver(c);
		
		//driver = new OperaDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testClick(){
		driver.get("https://google.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.id("lst-ib")).sendKeys("Fiat 125p");
		WebElement element = driver.findElement(By.className("r")); 
		element.findElement(By.cssSelector("a")).click();
		wait.until(ExpectedConditions.titleIs("Fiat 125p - Allegro.pl"));
		assertEquals(driver.getTitle(), "Fiat 125p - Allegro.pl");
	}
	
	@Test
	public void testKeys(){
		driver.get("https://google.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.id("lst-ib")).sendKeys("Fiat 125p");
		WebElement element = driver.findElement(By.className("r")); 
		element.findElement(By.tagName("a")).sendKeys(Keys.CONTROL, Keys.RETURN);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));

		wait.until(ExpectedConditions.titleIs("Fiat 125p - Allegro.pl"));
		assertEquals(driver.getTitle(), "Fiat 125p - Allegro.pl");
	}
	
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}
	
	
}
