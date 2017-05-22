package pageObjectDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactorySearch {
  
  //Nie uzywamy FindByElement !!!
	
	public WebDriver driver;
  
  	@FindBy(name = "search")
	private WebElement search;
  
  public PageFactorySearch(WebDriver driver){
	  this.driver = driver;
  }
  
  public void loadPage(String url)
  {
	  driver.get(url);
  }
  public void search(String input) throws Exception{
	  search.sendKeys(input);
	  search.submit();
	  Thread.sleep(3000);
  }
  
  public boolean assertResult(String res) throws Exception{
	  try 
	  {
		  WebElement element = driver.findElement(By.xpath("//*[contains(text(), '"+res+"')]"));
		  Boolean result = element.getText().contains(res);
		  System.out.println(element.getText());
		  return(result);
	  }
	  catch (NoSuchElementException e)
	  {
		  return(false);
	  }
	}
  
  
}
