package person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class ValidatingPersonDBTest 
{
	
	@Test(expected=IllegalArgumentException.class)
	public void testNoDuplicatePersons() {
	  Person samplePerson = new Person(1);
	  PersonDB delegate = mock(PersonDB.class);
	  when(delegate.getPerson(any(Person.class))).thenReturn(samplePerson);
	  PersonDB db = new ValidatingPersonDB(delegate);
	  db.addPerson(samplePerson);
	}

	/*
	public void testAddingPerson() {
	  Person samplePerson = new Person(1);
	  PersonDB delegate = mock(PersonDB.class);
	  PersonDB db = new ValidatingPersonDB(delegate);
	  db.addPerson(samplePerson);
	  verify(delegate).getPerson(samplePerson);
	  verify(delegate).addPerson(samplePerson);
	}*/
    
}
