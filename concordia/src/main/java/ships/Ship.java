package ships.ships;

public class Ship 
{
	//Ship Position
	private int[] xy = {0,0};
	//Ship Direction
	private char dir = 'S';
	
	//Map Size and Islands
	
	private int[][] mapislands = new int[15][15];
	
	boolean hiddenIslands = false;
	
	public void initIslands()
	{
		mapislands[5][7] = 1;
		mapislands[5][3] = 1;
	}
	
    public void setPosition(int[] xxyy)
    {
    	int[] mapsize = getMapSize();
    	
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
		
		//System.out.println(x);
		//System.out.println(y);
	}
	
	public int[] getPosition()
	{
		System.out.println("getPosition() ["+xy[0]+","+xy[1]+"]");
		return xy;
	}
	
	public void setDirection(char direction)
	{
		//System.out.println("setDirection() ["+direction+"]");
		this.dir = direction;
	}
	
	public char getDirection()
	{
		//System.out.println("getDirection() ["+dir+"]");
		return dir;
	}
	
	public int[] getMapSize()
	{
		//System.out.println("getMapSize() ["+mapislands.length+","+mapislands[0].length+"]");
		int[] mapsize = {mapislands.length-1,mapislands[0].length-1};
		return mapsize;
	}
	
	public void showIslands()
	{
		System.out.println("showIslands() [VISIBLE]");
		hiddenIslands = false;
	}
	
	public void hideIslands()
	{
		System.out.println("hideIslands() [HIDDEN]");
		hiddenIslands = true;
	}
	
	public boolean move(String str)
	{
		System.out.println("move() ["+str+"]");
		//nnnlnnpnnw
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
					if(direction=='N')
						newdirection = 'W';
					else if(direction=='S')
						newdirection = 'E';
					else if(direction=='E')
						newdirection = 'N';
					else if(direction=='W')
						newdirection = 'S';		
					break;
				case 'p':
					if(direction=='N')
						newdirection = 'E';
					else if(direction=='S')
						newdirection = 'W';
					else if(direction=='E')
						newdirection = 'S';
					else if(direction=='W')
						newdirection = 'N';		
					break;
				default: 
					return false;
			}
			if(hiddenIslands == false && isIsland(xxyy) && newdirection == '?')
			{
				System.out.println("Statek napotkal wyspe na pozycji ["+xxyy[0]+","+xxyy[1]+"]");
				return false;
			}
			else if(newdirection == '?')
			{
				System.out.println("RUCH NA POLE ["+xxyy[0]+","+xxyy[1]+"]");
				setPosition(xxyy);	
			}
			else
			{
				System.out.println("OBRÓT STATKU NA KIERUNEK ["+newdirection+"]");
				setDirection(newdirection);
			}
		}
		return true;
	}
	
	public boolean isIsland(int[] xxyy)
	{
		if(mapislands[xxyy[0]][xxyy[1]]==1)
			return true;
		else
			return false;
	}
	
}
