package JBehaveExample.ExampleJBehave;
import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.*;
public class ParametrSteps{
	
	private Calculator test;
	
	@Then("Wynik dodawania $a")
	public void thenWynikDodawania(int a){
		assertEquals(a,test.add(test.getLeft(), test.getRight()));
	}
	@Then("Wynik mnozenia $a")
	@Alias("Mnozenie przez $a")
	public void thenWynikMnozenia(int a){
		assertEquals(a,test.multiply(test.getLeft(), test.getRight()));
	}
	@When("Mnoze liczby $a i $b")
	@Alias("Teraz mnoze liczbe $a i liczbe $b")
	public void whenMnozeLiczby(int a, int b){
		test.setLeft(a);
		test.setRight(b);
	}
	@When("Dodamy liczby $a i $b")
	public void whenDodamyLiczby(int a,int b){
		test.setLeft(a);
		test.setRight(b);
	}
	@Given("Mamy kalkulator")
	public void givenMamyKalkulator(){
		test = new Calculator();
	}
}