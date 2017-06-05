package pageObjectDemo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectLogin {

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
	public void testLoginTrue() throws Exception {
		PageFactoryLogin loginPage = PageFactory.initElements(driver, PageFactoryLogin.class);
		loginPage.login("user@user.pl", "useruser");
		loginPage.waitForImg();
		assertTrue(loginPage.assertLogin("user@user.pl"));
	}
	
	@Test
	public void testLoginFail() throws Exception {
		PageFactoryLogin loginPage = PageFactory.initElements(driver, PageFactoryLogin.class);
		loginPage.login("user@user.pl2", "useruser");
		assertFalse(loginPage.assertLogin("user@user.pl2"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

}
