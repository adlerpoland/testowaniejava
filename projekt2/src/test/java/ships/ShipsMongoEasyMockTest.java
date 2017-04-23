package ships;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;
import static org.mockito.Mockito.doReturn;


@RunWith(EasyMockRunner.class)
public class ShipsMongoEasyMockTest {

	@TestSubject
	ShipsMongo ships = new ShipsMongo();
	Map map = new Map();
	
	//A nice mock expects recorded calls in any order and returning null for other calls
	@Mock(type = MockType.NICE)
	ShipCollection shipcollection;
	
	@Test
	public void mockingWorskAsExpected(){
		Ship joe = new Ship("Joe");
		expect(shipcollection.findByName("Joe")).andReturn(joe);
		replay(shipcollection);
		
		assertThat(shipcollection.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void bobIsOnStartPosition(){
		Ship bob = new Ship("bob");
		expect(shipcollection.findByName("bob")).andReturn(bob);
		replay(shipcollection);
		int xy[] = {0,0};
		assertThat(shipcollection.findByName("bob").getPosition()).isEqualTo(xy);
	}
	
	@Test
	public void moveJamesInToIsland(){
		Ship james = new Ship("james");
		expect(shipcollection.findByName("james")).andReturn(james);
		
		int xy[] = {1,9};
		james.setPosition(map, xy);
		
		xy[1] = 10;
		james.setDirection('e');
		james.move(map, "n");
		
		//Island on 2,9 ship shouldn't move
		
		int[] island = {2,9};
		replay(shipcollection);
		int[][] output = shipcollection.findByName("james").getHistory();
		
		assertThat(output).doesNotContain(island);
	}
	
	
}
