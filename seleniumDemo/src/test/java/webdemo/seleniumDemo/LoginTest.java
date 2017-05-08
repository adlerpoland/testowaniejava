package webdemo.seleniumDemo;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
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
	
	/*@Test
	public void testRejestracjaClick(){
		driver.get("https://joemonster.org/rejestracja");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.id("user_register_username")).sendKeys("jantester4");
		driver.findElement(By.id("user_register_email")).sendKeys("tester5@o2.pl");
		driver.findElement(By.id("user_register_gender_male_0")).click();
		Select dropdown = new Select(driver.findElement(By.id("user_register_birthday_year")));
		dropdown.selectByVisibleText("1990");
		driver.findElement(By.id("user_register_accept_rules")).click();
		
		driver.findElement(By.id("user_register_submit")).click();
		wait.until(ExpectedConditions.urlMatches("https://joemonster.org/logowanie"));
		
		WebElement element = driver.findElement(By.className("systemMessage"));
		WebElement h2 = element.findElement(By.cssSelector("fieldset")).findElement(By.cssSelector("h2"));
		String text = h2.getText().replaceAll("\t", "");
		
		assertEquals(text,"Gratulacje, właśnie się zarejestrowałeś! Sprawdź pocztę email, zaraz otrzymasz (lub już dostałeś) dane potrzebne do zalogowania się.");
		
		}*/
	
	@Test
	public void testLogowanieClick(){
		driver.get("http://sigma.ug.edu.pl/~padler/prog/index.php");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.id("tabLogin")).click();
		
		driver.findElement(By.name("login")).sendKeys("selenium");
		driver.findElement(By.name("haslo")).sendKeys("selenium123");
		
		driver.findElement(By.id("loginForm")).submit();
		
		wait.until(ExpectedConditions.titleIs("Programowanie"));
		
		assertEquals(driver.findElement(By.className("username")).getText(),"selenium");
	}
	
	@Test
	public void testFailPasswordFailClick(){
		driver.get("http://sigma.ug.edu.pl/~padler/prog/index.php");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.id("tabLogin")).click();
		
		driver.findElement(By.name("login")).sendKeys("selenium");
		driver.findElement(By.name("haslo")).sendKeys("zlehaslo");
		
		driver.findElement(By.id("loginForm")).submit();
		
		wait.until(ExpectedConditions.titleIs("Programowanie"));
		
		assertEquals(driver.findElement(By.tagName("span")).getText(),"Nieprawidłowy login lub hasło!");
	}
	
	@Test
	public void testFailLoginFailClick(){
		driver.get("http://sigma.ug.edu.pl/~padler/prog/index.php");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.id("tabLogin")).click();
		
		driver.findElement(By.name("login")).sendKeys("zlylogin");
		driver.findElement(By.name("haslo")).sendKeys("selenium123");
		
		driver.findElement(By.id("loginForm")).submit();
		
		wait.until(ExpectedConditions.titleIs("Programowanie"));
		
		assertEquals(driver.findElement(By.tagName("span")).getText(),"Nieprawidłowy login lub hasło!");
	}
	
	
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}
}
