package ships;
import ships.Map;

public class Ship 
{
	//Ship Name
	private String name = "concordia";
	//Ship Position
	private int[] xy = {0,0};
	//Ship Direction
	private char dir = 'W';
	
	//Position history
	private int[][] historyxy = new int[225][2];
	private int currentMove = 0;
	
	public Ship() {
		for(int i=0;i<225;i++)
		{
			this.historyxy[i][0] = -1;
			this.historyxy[i][1] = -1;
		}
	}
	
	public Ship(String n)
	{
		this.name = n;
		for(int i=0;i<225;i++)
		{
			this.historyxy[i][0] = -1;
			this.historyxy[i][1] = -1;
		}
	}
	
    public void setPosition(Map map,int[] xxyy)
    {	
    	int[] mapsize = map.getMapSize();
    	
    	int x = xxyy[0];
    	int y = xxyy[1]%(mapsize[1]+1);
    	if(x<0)
    		x=mapsize[0];
    	else if(x>mapsize[0])
    		x = x%(mapsize[0]+1);
    	if(y<0)
    		y=mapsize[1];
    	else if(y>mapsize[1])
    		y=y%(mapsize[1]+1);
    	
		this.xy[0] = x;
		this.xy[1] = y;
		
		this.historyxy[currentMove][0] = x;
		this.historyxy[currentMove][1] = y;
		currentMove++;
		
		System.out.println("RUCH NA POLE ["+x+","+y+"]");
	}
    
    public int getCurrentMove()
    {
    	return currentMove;
    }
    
    public String getName()
    {
    	return name;
    }
	
	public int[] getPosition()
	{
		System.out.println("getPosition() ["+xy[0]+","+xy[1]+"]");
		return xy;
	}
	
	public int[] getHistoryPosition(int move)
	{
		return historyxy[move-1];
	}
	
	public int[][] getHistory()
	{
		return historyxy;
	}
	
	public void setDirection(char direction)
	{
		this.dir = direction;
	}
	
	public char getDirection()
	{
		return dir;
	}
	
	public boolean move(Map map,String str)
	{
		int n = str.length();
		for(int i=0;i<n;i++)
		{
			char c = str.charAt(i);
			int[] xxyy = getPosition();
			char direction = getDirection();
			char newdirection = '?';
			
			switch(c){
				case 'n':
					if(direction=='N')
						xxyy[1]++;
					else if(direction=='S')
						xxyy[1]--;
					else if(direction=='E')
						xxyy[0]++;
					else if(direction=='W')
						xxyy[0]--;				
					break;
				case 'w':
					if(direction=='N')
						xxyy[1]--;
					else if(direction=='S')
						xxyy[1]++;
					else if(direction=='E')
						xxyy[0]--;
					else if(direction=='W')
						xxyy[0]++;				
					break;
				case 'l':
					String orient = "NWSEN";
					newdirection = orient.charAt(orient.indexOf(direction)+1);
					break;
				case 'p':
					orient = "NESWN";
					newdirection = orient.charAt(orient.indexOf(direction)+1);
					break;
				default: 
					return false;
			}
			if(map.hiddenIslands == false && map.isIsland(xxyy) && newdirection == '?')
			{
				System.out.println("Statek napotkal wyspe na pozycji ["+xxyy[0]+","+xxyy[1]+"]");
				return false;
			}
			else if(newdirection == '?')
			{
				setPosition(map,xxyy);	
			}
			else
			{
				System.out.println("OBRÓT STATKU NA KIERUNEK ["+newdirection+"]");
				setDirection(newdirection);
			}
		}
		return true;
	}	
}
