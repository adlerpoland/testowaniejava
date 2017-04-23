package ships;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ShipsMongoMockitoTest {
	
	@InjectMocks
	ShipsMongo ships;
	Map map = new Map();
	
	@Mock
	ShipCollection shipcollection;
	
	@Test
	public void mockingWorksAsExpected(){
		Ship joe = new Ship("joe");
		doReturn(joe).when(shipcollection).findByName("Joe");
		assertThat(shipcollection.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void bobIsOnStartPosition(){
		Ship joe = new Ship("bob");
		doReturn(joe).when(shipcollection).findByName("Joe");
		int xy[] = {0,0};
		assertThat(shipcollection.findByName("Joe").getPosition()).isEqualTo(xy);
	}
	
	@Test
	public void moveAlexTwice(){
		Ship alex = new Ship("alex");
		//map.initIslands();
		doReturn(alex).when(shipcollection).findByName("alex");
		
		int xy[] = {0,1};
		alex.setPosition(map, xy);
		int move = alex.getCurrentMove();
		xy[1] = 2;
		alex.setPosition(map, xy);
		xy[1] = 1;
		
		assertThat(shipcollection.findByName("alex").getHistoryPosition(move)).isEqualTo(xy);
	}
}
