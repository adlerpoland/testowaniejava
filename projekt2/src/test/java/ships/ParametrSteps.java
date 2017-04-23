package ships;
import static org.junit.Assert.assertArrayEquals;

import org.jbehave.core.annotations.*;
public class ParametrSteps{
	private Map map;
	private Ship ship;
	
	@Given("Inicjujemy obiekty")
	public void givenInicjujemyObiekty(){
		map = new Map();
		ship = new Ship();
		ship.setDirection('N');
	}
	
	@Alias("Umiescimy statek na x=$a,y=$b")
	@When("Ustawimy statek na x=$a,y=$b")
	public void whenUstawimyStatek(int a, int b){
		int xy[] = {a,b};
		ship.setPosition(map, xy);
	}
	@Alias("Statek jest na x=$a,y=$b")
	@Then("Statek bedzie w pozycji x=$a,y=$b")
	public void thenStatekBedzieWPozycji(int a,int b){
		int xy[] = {a,b};
		assertArrayEquals(xy,ship.getPosition());
	}
	
	@When("Poplyniemy statkiem")
	public void whenPoplyniemyStatkiem(){
		 ship.move(map, "n"); 
	}
}