package MockExamples.MockExamples;

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

// Ta linia jest wymagana
@RunWith(MockitoJUnitRunner.class)
public class FriendshipsMongoMockitoTest {
	
	//Nasza atrapa
	@InjectMocks
	FriendshipsMongo friendships;
	
	//Co zastepujemy
	@Mock
	FriendsCollection friends;
	
	
	@Test
	public void mockingWorskAsExpected(){
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		assertThat(friends.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void alexDoesNotHaveFriends(){
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends(){
		List<String> expected = Arrays.asList(new String[]{"Karol","Dawid","Maciej","Tomek","Adam"});
		//Spy przechwytuje wywołania z przekazywanymi pośrednio danymi w celu
		// późniejszego zbadania tych danych w teście - tutaj w przykładzie lista przyjaciół Joe
		Person joe = spy(new Person("Joe"));
		doReturn(joe).when(friends).findByName("Joe");
		doReturn(expected).when(joe).getFriends();
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol","Dawid","Maciej","Tomek","Adam");
	}
	
	@Test
	public void makeFriends(){
		Person karol = new Person("Karol");	
		doReturn(karol).when(friends).findByName("Karol");
		Person dawid = new Person("Dawid");
		doReturn(dawid).when(friends).findByName("Dawid");
		friendships.makeFriends("Karol","Dawid");
		
		assertThat(friendships.getFriendsList("Karol")).hasSize(1).containsOnly("Dawid");
	}
	
	@Test
	public void makeMoreFriends()
	{
		Person karol = new Person("Karol");	
		doReturn(karol).when(friends).findByName("Karol");
		Person maciej = new Person("Maciej");
		doReturn(maciej).when(friends).findByName("Maciej");
		Person tomek = new Person("Tomek");	
		doReturn(tomek).when(friends).findByName("Tomek");
		
		friendships.makeFriends("Karol","Maciej");
		friendships.makeFriends("Karol","Tomek");
		
		assertThat(friendships.getFriendsList("Karol")).hasSize(2).containsOnly("Maciej","Tomek");
	}
	
	


}
