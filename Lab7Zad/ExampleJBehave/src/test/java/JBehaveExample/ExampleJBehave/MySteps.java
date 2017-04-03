package JBehaveExample.ExampleJBehave;

import org.jbehave.core.annotations.*;
import static org.junit.Assert.*;
public class MySteps{
	
	private Calculator test;
	
	@Then("mamy wynik -9")
	public void thenMamyWynik9(){
		assertEquals(-9,test.multiply(test.getLeft(), test.getRight()));
	}
	@When("Mnozymy liczby -3 i 3")
	public void whenMnozymyLiczby3I3(){
		test.setLeft(-3);
		test.setRight(3);
	}
	@Given("Tworzymy nowy kalkulator")
	public void givenTworzymyNowyKalkulator(){
		test = new Calculator();
	}
}