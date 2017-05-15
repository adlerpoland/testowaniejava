package webdemo.seleniumDemo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
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
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testOpenAllLinks(){
		driver.get("https://photo-gallery-123.herokuapp.com/photos");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		List<WebElement> listElements = driver.findElements(By.tagName("a"));
		for(int i=0; i<listElements.size(); i++){
			listElements.get(i).click();
			driver.navigate().back();
		}
	}
	
	@Test
	public void testOpenAllGoogleLinks(){
		driver.get("https://www.google.pl");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		List<WebElement> listElements = driver.findElements(By.tagName("a"));
		System.out.println(listElements.size());
		for(int i=0; i<listElements.size(); i++){
			try {
				List<WebElement> newlist = driver.findElements(By.tagName("a"));
				if(newlist.get(i).getAttribute("href").contains("google"))
				{
					System.out.println(i + ": " + newlist.get(i).getAttribute("href"));
					driver.navigate().to(newlist.get(i).getAttribute("href"));
					driver.navigate().back();
				}
				else
					continue;
			} catch (Exception e) {
				System.out.println(i +": error");
		    }
		}
	}
	
	@Test
	public void testDisplayInputs(){
		driver.get("http://joemonster.org/rejestracja");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		List<WebElement> listElements = driver.findElements(By.tagName("input"));
		System.out.println(listElements.size());
		for(int i=0; i<listElements.size(); i++){
			if(listElements.get(i).getAttribute("type").equals("text"))
				System.out.println(listElements.get(i).getAttribute("name"));
		}
	}
	
	@Test
	public void testCountSelectInput(){
		driver.get("http://joemonster.org/rejestracja");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement element = driver.findElement(By.id("user_register_birthday_month"));

		List<WebElement> values = element.findElements(By.tagName("option"));
		System.out.print("Select size: "+values.size());
	}
	
	
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}
	
	
}
