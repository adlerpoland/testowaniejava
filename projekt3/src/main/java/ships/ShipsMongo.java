package ships;

import java.rmi.UnknownHostException;
import java.util.Collections;
import java.util.List;

import ships.ShipCollection;

public class ShipsMongo {
	private ShipCollection ships;
	
	public ShipsMongo(){
		  try {
			ships = new ShipCollection();
		  } catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void addShip(int[] xy){
		Ship s = ships.findByPosition(xy);
		if (s == null){
			s = new Ship();
		}
		//s.setPosition(xy);
		ships.save(s);
	}
}
