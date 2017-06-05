package pageObjectDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactoryLogin {
  
  //Nie uzywamy FindByElement !!!
	
	public WebDriver driver;
	private final Wait<WebDriver> wait;
  
  	@FindBy(name = "user[email]")
	private WebElement login;
	
	@FindBy(id = "user_password")
	private WebElement password;
	
	@FindBy(name = "commit")
	private WebElement submit;
  
  public PageFactoryLogin(WebDriver driver){
	  this.driver = driver;
	  driver.get("https://protected-ocean-44249.herokuapp.com/users/sign_in");
	  wait = new WebDriverWait(driver,10);
  }
  
  public void login(String log, String pass) throws Exception{
	  login.sendKeys(log);
	  password.sendKeys(pass);
	  submit.submit();
  }
  
  public void waitForImg()
  {
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
  }
  
  public boolean assertLogin(String log) throws Exception{
	  try 
	  {
		  WebElement element = driver.findElement(By.xpath("//*[contains(text(), '"+log+"')]"));
		  Boolean result = element.getText().contains(log);
		  System.out.println(element.getText());
		  return(result);
	  }
	  catch (NoSuchElementException e)
	  {
		  return(false);
	  }
	}
  
  
}
