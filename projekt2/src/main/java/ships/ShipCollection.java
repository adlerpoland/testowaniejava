package ships;

import java.rmi.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class ShipCollection {
	private MongoCollection ships;
	
	public ShipCollection() throws UnknownHostException{
	    @SuppressWarnings({ "deprecation", "resource" })
		DB db = new MongoClient().getDB("shipsdb");
		ships = new Jongo(db).getCollection("ships");
	  }
	  
	  public Ship findByPosition(int[] xy){
		  return ships.findOne("{_id: #", xy).as(Ship.class);
	  }
	  
	  public void save(Ship s){
		  ships.save(s);
	  }
}
