package JBehaveExample.ExampleJBehave;

import org.jbehave.core.annotations.*;
import static org.junit.Assert.*;
public class CalculatorStepsRunner2{
	
	private Calculator test;
	
	@Given("Mam utworzony nowy kalkulator")
	public void givenMamUtworzonyNowyKalkulator(){
		test = new Calculator();
	}
	@Then("po dodaniu dostane 0")
	public void thenPoDodaniuDostane0(){
		 assertEquals(0,test.add(test.getLeft(), test.getRight()));
	}
	@When("dodam liczby -3 i 3")
	public void whenDodamLiczby3I3(){
		 test.setLeft(-3);
		 test.setRight(3);
	}
}