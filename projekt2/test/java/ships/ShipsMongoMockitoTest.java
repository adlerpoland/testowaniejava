package ships;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

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
		Ship bob = new Ship("bob");
		doReturn(bob).when(shipcollection).findByName("bob");
		int xy[] = {0,0};
		assertThat(shipcollection.findByName("bob").getPosition()).isEqualTo(xy);
	}
	
	@Test
	public void moveAlexTwice(){
		Ship alex = new Ship("alex");
		doReturn(alex).when(shipcollection).findByName("alex");
		
		int xy[] = {0,1};
		alex.setPosition(map, xy);
		int move = alex.getCurrentMove();
		xy[1] = 2;
		alex.setPosition(map, xy);
		xy[1] = 1;
		
		assertThat(shipcollection.findByName("alex").getHistoryPosition(move)).isEqualTo(xy);
	}
	
	@Test
	public void moveJamesFewTimes(){
		Ship james = new Ship("james");
		doReturn(james).when(shipcollection).findByName("james");
		
		int xy[] = {0,1};
		james.setPosition(map, xy);
		
		xy[1] = 2;
		james.setPosition(map, xy);
		
		xy[0] = 1;
		xy[1] = 3;
		james.setPosition(map, xy);
		
		xy[0] = 2;
		xy[1] = 3;
		james.setPosition(map, xy);
		
		xy[0] = 2;
		xy[1] = 4;
		james.setPosition(map, xy);
		
		int[][] array = {{0,1},{0,2},{1,3},{2,3},{2,4}};	
		int[][] output = shipcollection.findByName("james").getHistory();
		
		assertThat(output).contains(array);
	}
	
	@Test
	public void moveJamesInToIsland(){
		Ship james = new Ship("james");
		doReturn(james).when(shipcollection).findByName("james");
		
		int xy[] = {1,9};
		james.setPosition(map, xy);
		
		xy[1] = 10;
		james.setDirection('e');
		james.move(map, "n");
		
		//Island on 2,9 ship shouldn't move
		
		int[] island = {2,9};
		int[][] output = shipcollection.findByName("james").getHistory();
		
		assertThat(output).doesNotContain(island);
	}
	
	@Test
	public void moveBobInCircle(){
		Ship bob = new Ship("bob");
		doReturn(bob).when(shipcollection).findByName("bob");
		
		int xy[] = {9,7};
		bob.setPosition(map, xy);
		bob.setDirection('e');
		bob.move(map, "npnpnpnpn");
		
		int[][] array = {{9,7},{9,8},{10,8},{10,7},{9,7}};
		int[][] output = shipcollection.findByName("bob").getHistory();
		
		assertThat(output).contains(array);
	}
	
	
	
	
	
	
	
}
