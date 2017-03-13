package person;

import java.rmi.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class ValidatingPersonDB implements PersonDB{
	private PersonDB delegate;
	
	public ValidatingPersonDB(PersonDB delegate){
		this.delegate = delegate;
	}
	
	public void addPerson(Person person){
		Person oldPerson = delegate.getPerson(person.getId());
		if(oldPerson != null) throw new IllegalArgumentException("User " + person.getId() +" already exists!");
		delegate.addPerson(person);
	}
	
	public void updatePerson(Person person)
	{
		
	}
	
	public Person getPerson(int id)
	{
		Person oldPerson = new Person(0);
		return oldPerson;
	}
	
	public void deletePerson(int id)
	{
		
	}
}
