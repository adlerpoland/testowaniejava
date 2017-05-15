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

public class RegisterTest {
	private static WebDriver driver;
	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testRejestracjaClick(){
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.name("firstName")).sendKeys("Jan");
		driver.findElement(By.name("lastName")).sendKeys("Strzelba");
		driver.findElement(By.name("phone")).sendKeys("123456789");
		driver.findElement(By.name("userName")).sendKeys("jan4@strzelba.pl");
		
		driver.findElement(By.name("address1")).sendKeys("Dworcowa 1");
		driver.findElement(By.name("city")).sendKeys("Gdansk");
		driver.findElement(By.name("state")).sendKeys("Pomorskie");
		driver.findElement(By.name("postalCode")).sendKeys("80-800");
		
		Select element = new Select(driver.findElement(By.name("country")));
		element.selectByVisibleText("POLAND");
		
		driver.findElement(By.name("email")).sendKeys("Jantester12345");
		driver.findElement(By.name("password")).sendKeys("jantester");
		driver.findElement(By.name("confirmPassword")).sendKeys("jantester");	
		
		driver.findElement(By.name("register")).click();
		
		List<WebElement> plist = driver.findElements(By.tagName("font"));
		String text = "";
		int size = plist.size();
		for(int i=0;i<size;i++)
		{
			if(plist.get(i).getText().contains("Thank you for registering. You may now "))
			{
				text = plist.get(i).getText();
			}
		}
		
		assertEquals(text.contains("Thank you for registering. You may now "),true);
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}
}
