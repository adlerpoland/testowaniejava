package pageObjectDemo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageCRUD {

    private static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		//driver = new FirefoxDriver();

		
		//TEST ZA POMOCA PHANTOM I HTMLUNIT
		//System.setProperty("phantomjs.binary.path", "resources/phantomjs");	
		//driver = new PhantomJSDriver();
			
		driver = new HtmlUnitDriver();
	}
	
	@Test
	public void testAddToCart() throws Exception {
		driver.get("https://matbud.pl/category/narzedzia-elektronarzedzia");
		
		WebElement element = driver.findElement(By.className("border_basket"));
		WebElement link = element.findElement(By.cssSelector("a"));
		WebElement button = link.findElement(By.cssSelector("img"));
		
		///basket/addReferer/product_id/5026
		String id = link.getAttribute("href");
		id = id.split("/")[6];
		
		System.out.print("ID przedmiotu: "+id+"\n");
		
		driver.get(link.getAttribute("href"));
				
		Thread.sleep(2000);
		
		WebElement basket = driver.findElement(By.id("basket_products_table"));
		
		WebElement tbody = basket.findElement(By.cssSelector("tbody"));
		
		assertTrue(tbody.findElement(By.id("tr_product_id_"+id)) != null);
	}
	
	@Test
	public void testAddToCartAndClear() throws Exception {
		driver.get("https://matbud.pl/category/narzedzia-elektronarzedzia");
		
		WebElement element = driver.findElement(By.className("border_basket"));
		WebElement link = element.findElement(By.cssSelector("a"));
		WebElement button = link.findElement(By.cssSelector("img"));
		
		///basket/addReferer/product_id/5026
		String id = link.getAttribute("href");
		id = id.split("/")[6];
		
		System.out.print("ID przedmiotu: "+id+"\n");
		
		driver.get(link.getAttribute("href"));
				
		Thread.sleep(2000);
		
		WebElement basket = driver.findElement(By.id("basket_products_table"));
		
		WebElement tbody = basket.findElement(By.cssSelector("tbody"));
		
		//WebElement trash = tbody.findElement(By.className("buttons right basket_action"));
		//WebElement trasha = trash.findElement(By.cssSelector("a"));
		
		//driver.get(trasha.getAttribute("href"));\
		
		driver.get("https://matbud.pl/basket/clear");
		
		WebElement title = driver.findElement(By.className("title"));
		
		assertEquals("TWÓJ KOSZYK JEST PUSTY",title.getText().toUpperCase());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

}
