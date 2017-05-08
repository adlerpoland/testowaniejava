package webdemo.seleniumDemo;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkTest {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		//Od wersji selenium 3.0 samo FirefoxDriver nie wystarcza
		//Należy dodać sterownik geckodriver
		//Do pobrania tutaj: https://github.com/mozilla/geckodriver/releases
		//System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testFindByLink(){
		driver.get("https://mojblog.wordpress.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement element = driver.findElement(By.linkText("Kontakt"));
		
		assertEquals(element.getAttribute("href"), "https://mojblog.wordpress.com/kontakt/");
	}
	
	@Test
	public void testFindByPartialLink(){
		driver.get("https://mojblog.wordpress.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement element = driver.findElement(By.partialLinkText("O co tu"));
		
		assertEquals(element.getAttribute("href"), "https://mojblog.wordpress.com/o-co-chodzi/");
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}
}
