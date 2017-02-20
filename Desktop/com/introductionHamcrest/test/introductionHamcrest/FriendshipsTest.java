package introductionHamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class FriendshipsTest {

	private Friendships array; 
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		array = new Friendships();
	}

	@Test
	public void test() {
		array.makeFriends("Adam", "Robert");
		List<String> friends = array.getFriendsList("Adam");
		assertThat(friends,contains("Robert"));
	}

}
