package JBehaveExample.ExampleJBehave;
import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.*;
public class ParametrSteps{
	
	private Calculator test;
	
	@Then("Wynik dodawania $a")
	@Alias("Wynik dodawania <multiply>")
	public void thenWynikDodawania(int a){
		assertEquals(a,test.add(test.getLeft(), test.getRight()));
	}
	@Then("Wynik mnozenia $a")
	@Alias("Wynik mnozenia <a>")
	public void thenWynikMnozenia(int a){
		assertEquals(a,test.multiply(test.getLeft(), test.getRight()));
	}
	@When("Mnoze liczby $a i $b")
	@Alias("Mnoze liczby <x> i <y>")
	public void whenMnozeLiczby(int a, int b){
		test.setLeft(a);
		test.setRight(b);
	}
	@When("Dodamy liczby $a i $b")
	@Alias("Dodamy liczby <x> i <y>")
	public void whenDodamyLiczby(int a,int b){
		test.setLeft(a);
		test.setRight(b);
	}
	@Given("Mamy kalkulator")
	public void givenMamyKalkulator(){
		test = new Calculator();
	}	
	
	@Given("a value x by $a")
	public void givenValuex(int a){
		test = new Calculator();
		test.setLeft(a);
	}
	
	@Given("a value y by $a")
	public void givenValuey(int a){
		test.setRight(a);
	}
	
	@Then("sum of value x and y {is|becomes} $a")
	//@Then("sum of value x and y is $a")
	//@Alias("sum of value x and y becomes $a")
	public void thenSumOfValueXandY(int a){
		assertEquals(a,test.add(test.getLeft(), test.getRight()));
	}
	
	@AfterScenario(uponOutcome=AfterScenario.Outcome.FAILURE)
	public void fail()
	{
		System.out.println("BLAD TESTU");
	}
	
	@AfterScenario(uponOutcome=AfterScenario.Outcome.SUCCESS)
	public void success()
	{
		System.out.println("SUKCES TESTU");
	}
	
	
}