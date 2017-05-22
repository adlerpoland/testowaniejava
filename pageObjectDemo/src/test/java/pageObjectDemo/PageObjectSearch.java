package pageObjectDemo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectSearch {

    private static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testsilesia() throws Exception {
		PageFactorySearch page = PageFactory.initElements(driver, PageFactorySearch.class);
		page.loadPage("https://narzedzia-silesia.pl/");
		page.search("farba");
		assertTrue(page.assertResult("Farba lateksowa DULUX KOLORY ŚWIATA 2,5L"));
	}
	
	@Test
	public void testkrowka() throws Exception {
		PageFactorySearch page = PageFactory.initElements(driver, PageFactorySearch.class);
		page.loadPage("https://krowkamarkety.com.pl");
		page.search("kocioł");
		assertTrue(page.assertResult("Kocioł Aqua Classic 12kW z rusztem wodnym"));
	}
	
	@Test
	public void testbysewo() throws Exception {
		PageFactorySearch page = PageFactory.initElements(driver, PageFactorySearch.class);
		page.loadPage("http://sklep-bysewo.pl/");
		page.search("farba");
		assertTrue(page.assertResult("GOLDMURIT FARBA PERFECT LATEX DO WNĘTRZ BAZA 1 BIAŁA "));
	}
	
	@Test
	public void testnarzedzia() throws Exception {
		PageFactorySearch page = PageFactory.initElements(driver, PageFactorySearch.class);
		page.loadPage("http://www.narzedzia.pl/");
		page.search("farba");
		assertTrue(page.assertResult("Otwieracz puszek z farbą Topex 20B671"));
	}
	
	@Test
	public void testsilesiaFail() throws Exception {
		PageFactorySearch page = PageFactory.initElements(driver, PageFactorySearch.class);
		page.loadPage("https://narzedzia-silesia.pl/");
		page.search("kocioł");
		assertTrue(page.assertResult("Nie znaleziono produktów spełniających podane kryteria."));
	}
	
	@Test
	public void testkrowkaFail() throws Exception {
		PageFactorySearch page = PageFactory.initElements(driver, PageFactorySearch.class);
		page.loadPage("https://krowkamarkety.com.pl");
		page.search("kociołek");
		assertTrue(page.assertResult("Nie znaleziono produktów spełniających podane kryteria."));
	}
	
	@Test
	public void testbysewoFail() throws Exception {
		PageFactorySearch page = PageFactory.initElements(driver, PageFactorySearch.class);
		page.loadPage("http://sklep-bysewo.pl/");
		page.search("kocioł");
		assertTrue(page.assertResult("Nie znaleziono produktów spełniających podane kryteria."));
	}
	
	@Test
	public void testnarzedziaFail() throws Exception {
		PageFactorySearch page = PageFactory.initElements(driver, PageFactorySearch.class);
		page.loadPage("http://www.narzedzia.pl/");
		page.search("kociołlallaa");
		assertTrue(page.assertResult(" nie odnaleziono żadnego dostępnego produktu."));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

}
