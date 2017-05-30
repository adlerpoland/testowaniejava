package JBehaveDemo;


import static org.junit.Assert.*;
import org.jbehave.core.annotations.*;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactorySteps{
	
	private WebDriverProvider driver;
	private Wait<WebDriver> wait;
	
	private WebElement login;
	private WebElement password;
	private WebElement submit;
	
	public PageFactorySteps(WebDriverProvider driver){
		super();
		this.driver = driver;
	}
	
	@Given("Mamy strone i przegladarke chrome")
	public void givenSiteChrome(){
		 driver.get().get("https://protected-ocean-44249.herokuapp.com/users/sign_in");
		 wait = new WebDriverWait(driver.get(), 10);
	}
	
	@When("Wprowadzamy poprawne dane i wysylamy")
	public void whenGoodData(){
		login = driver.get().findElement(By.name("user[email]"));
		password = driver.get().findElement(By.id("user_password"));
		submit = driver.get().findElement(By.name("commit"));
		
		login.sendKeys("user@user.pl");
		password.sendKeys("useruser");
		submit.submit();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
	}
	
	@Then("Jestesmy zalogowani na konto")
	public void thenLoggedIn(){
		WebElement navbar = driver.get().findElement(By.xpath("//*[contains(text(), 'user@user.pl')]"));
		assertTrue(navbar.getText().contains("user@user.pl")); 
		driver.get().manage().deleteAllCookies();
	}
	
	/////////////////////////////////////////////
	
	@When("Wprowadzamy inne poprawne dane i wysylamy")
	public void whenOtherGoodData(){
		login = driver.get().findElement(By.name("user[email]"));
		password = driver.get().findElement(By.id("user_password"));
		submit = driver.get().findElement(By.name("commit"));
		
		login.sendKeys("user10@user.pl");
		password.sendKeys("useruser");
		submit.submit();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
	}
	
	@Then("Jestesmy zalogowani na inne konto")
	public void thenOtherLoggedIn(){
		WebElement navbar = driver.get().findElement(By.xpath("//*[contains(text(), 'user10@user.pl')]"));
		assertTrue(navbar.getText().contains("user10@user.pl")); 
		driver.get().manage().deleteAllCookies();
	}
	
	/////////////////////////////////////////////
	@When("Wprowadzamy zle dane i wysylamy")
	public void whenWrongData(){
		login = driver.get().findElement(By.name("user[email]"));
		password = driver.get().findElement(By.id("user_password"));
		submit = driver.get().findElement(By.name("commit"));
		
		login.sendKeys("user@user.pl1");
		password.sendKeys("useruser");
		submit.submit();
	}
		
	@Then("Jestesmy niezalogowani")
	public void thenNotLoggedIn(){
		boolean except = false;
		try{
			WebElement navbar = driver.get().findElement(By.xpath("//*[contains(text(), 'user@user.pl1')]"));
		}
		catch(NoSuchElementException e)
		{
			except = true;
		}
		assertTrue(except); 
		driver.get().manage().deleteAllCookies();
	}
}