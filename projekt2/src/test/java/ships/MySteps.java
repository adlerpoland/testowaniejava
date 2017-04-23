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
	
	@Given("Inicjujemy mape oraz statek z kierunkiem N w pozycji srodkowej")
	public void givenInicjujemyMapeOrazStatekZKierunkiemNWPozycjiSrodkowej(){
		map = new Map();
		ship = new Ship();
		ship.setDirection('N');
		int xy[] = {8,8};
		ship.setPosition(map, xy);
	}
	
	@When("Ustawimy pozycje statku na x=5,y=5")
	public void whenUstawimyPozycjeStatkuNaX5y5(){
		int xy[] = {5,5};
		ship.setPosition(map,xy);
	}
	@Then("Statek bedzie w pozycji x=5,y=5")
	public void thenStatekBedzieWPozycjiX5y5(){
		int xy[] = {5,5};
		assertArrayEquals(xy,ship.getPosition());
	}
	
	@When("Ustawiamy kierunek statku na E")
	public void whenUstawiamyKierunekStatkuNaE(){
		ship.setDirection('E');
	}
	
	@Then("Statek bedzie obrocony w kierunku E")
	public void thenStatekBedzieObroconyWKierunkuE(){
		assertEquals('E',ship.getDirection());
	}
	
	@When("Poplyniemy statkiem do przodu")
	public void whenPoplyniemyStatkiemDoPrzodu(){
		ship.move(map, "n");
	}
	
	@Then("Statek bedzie w pozycji x=0,y=1")
	public void thenStatekBedzieWPozycjiX0y1(){
		int xy[] = {0,1};
		assertArrayEquals(xy,ship.getPosition());
	}
	
	@When("Poplyniemy statkiem do tylu")
	public void whenPoplyniemyStatkiemDoTylu(){
		ship.move(map, "w");
	}
	
	@Then("Statek bedzie w pozycji x=8,y=7")
	public void thenStatekBedzieWPozycjiX8y7(){
		int xy[] = {8,7};
		assertArrayEquals(xy,ship.getPosition());
	}
	@When("Poplyniemy statkiem do przodu skrecimy w prawo i poplyniemy")
	public void whenPoplyniemyStatkiemDoPrzoduSkrecimyWPrawoIPoplyniemy(){
		ship.move(map, "npn");
	}
	
	@Then("Statek bedzie w pozycji x=1,y=1")
	public void thenStatekBedzieWPozycjiX1y1(){
		int xy[] = {1,1};
		assertArrayEquals(xy,ship.getPosition());
	}
}