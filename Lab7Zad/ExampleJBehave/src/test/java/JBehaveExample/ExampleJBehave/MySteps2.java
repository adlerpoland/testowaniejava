package JBehaveExample.ExampleJBehave;
import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.*;
public class MySteps2{
	
	private Calculator test;
	
	@Given("Inicjujemy kalkulator")
	public void givenInicjujemyKalkulator(){
		test = new Calculator();
	}
	@When("Odejmujemy liczbe 8 i 4")
	public void whenOdejmujemyLiczbe8i4(){
		test.setLeft(8);
		test.setRight(4);
	}
	@Then("Otrzymujemy wynik 4")
	public void thenOtrzymujemyWynik4(){
		assertEquals(4,test.substract(test.getLeft(), test.getRight()));
	}
	@When("Odejmujemy liczbe 10 i -5")
	public void whenOdejmujemyLiczbe10i5(){
		test.setLeft(10);
		test.setRight(-5);
	}
	@Then("Otrzymujemy wynik 15")
	public void thenOtrzymujemyWynik15(){
		assertEquals(15,test.substract(test.getLeft(), test.getRight()));
	}
}