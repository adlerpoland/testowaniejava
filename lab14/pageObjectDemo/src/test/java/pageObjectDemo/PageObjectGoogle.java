package pageObjectDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectGoogle {
	
	public WebDriver driver;
	private final Wait<WebDriver> wait;
	
	boolean isElementPresent(By by)
	{
		try {
	        driver.findElement(by);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}

	public PageObjectGoogle(WebDriver driver){
		this.driver = driver;
		driver.get("http://www.google.co.in");
		wait = new WebDriverWait(driver,10);
	}
	
	public void search() throws Exception{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		if(isElementPresent(By.name("q")))
		{
			driver.findElement(By.name("q")).sendKeys("Mateusz Miotk");
			driver.findElement(By.name("q")).submit();
			System.out.println("Wyszukiwanie Google - SUKCES");
			Thread.sleep(1000);
		}
		else
			System.out.println("ELEMENT NIE ZNALEZIONY");
	}
	
	public void searchFail() throws Exception{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		if(isElementPresent(By.name("asdasd")))
		{
			driver.findElement(By.name("q")).sendKeys("Mateusz Miotk");
			driver.findElement(By.name("q")).submit();
			System.out.println("Wyszukiwanie Google - SUKCES");
			Thread.sleep(1000);
		}
		else
			System.out.println("ELEMENT NIE ZNALEZIONY");
	}
	
	public boolean assertTitle() throws Exception{
		Boolean result = driver.getTitle().contains("Mateusz Miotk");
		System.out.println(driver.getTitle());
		return(result);
	}
	
}
