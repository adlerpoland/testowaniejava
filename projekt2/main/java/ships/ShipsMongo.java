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
	
	public int[][] getHistoryByName(String name){
		  Ship p = ships.findByName(name);
		  if (p == null){
			  System.out.println("EMPTY");
			  int[][] in = {};
			  return in;
		  }
		  return p.getHistory();
	  }
	
	public boolean addShip(String name){
		Ship s = ships.findByName(name);
		if (s == null){
			s = new Ship(name);
		}
		ships.save(s);
		return true;
	}
}
