package ships;
import static org.junit.Assert.*;

import org.jbehave.core.annotations.*;
public class MySteps{
	private Map map;
	private Ship ship;
	
	@Given("Inicjujemy mape oraz statek z kierunkiem N w pozycji startowej")
	public void givenInicjujemyMapeOrazStatekZKierunkiemNWPozycjiStartowej(){
		map = new Map();
		ship = new Ship();
		ship.setDirection('N');
	}
	
	@When("Ustawimy pozycje statku na x=5,y=5")
	public void whenUstawimyPozycjeStatkuNaX5y5(){
		int xy[] = {5,5};
		ship.setPosition(map,xy);
	}
	@Then("Statek bedzie w pozycji x=5,y=5")
	public void thenStatekBedzieWPozycjiX5y5(){
		int xy[] = {5,5};
		assertArrayEquals(ship.getPosition(),xy);
	}
	
	@When("Ustawiamy kierunek statku na E")
	public void whenUstawiamyKierunekStatkuNaE(){
		ship.setDirection('E');
	}
	
	@Then("Statek bedzie obrocony w kierunku E")
	public void thenStatekBedzieObroconyWKierunkuE(){
		assertEquals(ship.getDirection(),'E');
	}
	
	@When("Poplyniemy statkiem do przodu")
	public void whenPoplyniemyStatkiemDoPrzodu(){
		ship.move(map, "n");
	}
	
	@Then("Statek bedzie w pozycji x=0,y=1")
	public void thenStatekBedzieWPozycjiX0y1(){
		int xy[] = {0,1};
		assertArrayEquals(ship.getPosition(),xy);
	}
	
	@When("Poplyniemy statkiem do przodu skrecimy w lewo i poplyniemy")
	public void whenPoplyniemyStatkiemDoPrzoduSkrecimyWLewoIPoplyniemy(){
		ship.move(map, "nln");
	}
	
	@Then("Statek bedzie w pozycji x=1,y=15")
	public void thenStatekBedzieWPozycjiX1y15(){
		int xy[] = {0,15};
		assertArrayEquals(ship.getPosition(),xy);
	}
	@When("Poplyniemy statkiem do przodu skrecimy w prawo i poplyniemy")
	public void whenPoplyniemyStatkiemDoPrzoduSkrecimyWPrawoIPoplyniemy(){
		ship.move(map, "npn");
	}
	
	@Then("Statek bedzie w pozycji x=1,y=1")
	public void thenStatekBedzieWPozycjiX1y1(){
		int xy[] = {1,1};
		assertArrayEquals(ship.getPosition(),xy);
	}
}