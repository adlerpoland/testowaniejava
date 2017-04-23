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
	  
	  public Ship findByName(String name){
		  //return ships.findOne("{name: #", name).as(Ship.class);
		  return ships.findOne("{_id: #", name).as(Ship.class);
	  }
	  
	  public void save(Ship s){
		  ships.save(s);
	  }
}
