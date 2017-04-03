package JBehaveExample.ExampleJBehave;

import org.jbehave.core.annotations.*;
import static org.junit.Assert.*;
public class SimpleSteps
{
	int cos = 0;
	@Given("Mamy cos")
	public void givenMamyCos(){
		cos = 0;
	}
	
	@When("the {tomato|apple|desk} cost $price")
	public void cos(int price){
		cos = price;
	}
	
	@Then("on sale cost $sprice")
	public void sale(int sprice){
		assertEquals(cos,sprice*2);
	}
}