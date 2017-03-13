package person;
import java.rmi.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class PersonCollection {
  
  private MongoCollection Person;
  
  public PersonCollection() throws UnknownHostException{
    @SuppressWarnings({ "deprecation", "resource" })
	DB db = new MongoClient().getDB("People");
	Person = new Jongo(db).getCollection("Person");
  }
  
  public Person findByName(String name){
	  return Person.findOne("{_id: #", name).as(Person.class);
  }
  
  public void save(Person p){
	  Person.save(p);
  }
  
}
