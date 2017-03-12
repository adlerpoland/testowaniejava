package ships;

public class Ship 
{
	//Ship Position
	private int[] xy = {0,0};
	//Ship Direction
	private char dir = 'W';
	
	//Map Size and Islands
	
	private int[][] mapislands = new int[15][15];
	
	boolean hiddenIslands = false;
	
	public void initIslands()
	{
		mapislands[11][0] = 1;
		mapislands[8][1] = 1;
		mapislands[9][1] = 1;
		mapislands[8][2] = 1;
		mapislands[7][5] = 1;
		mapislands[11][5] = 1;
		mapislands[3][6] = 1;
		mapislands[6][8] = 1;
		mapislands[2][9] = 1;
		mapislands[11][11] = 1;
		mapislands[5][13] = 1;
		mapislands[0][14] = 1;
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
		
		System.out.println("RUCH NA POLE ["+x+","+y+"]");
	}
	
	public int[] getPosition()
	{
		System.out.println("getPosition() ["+xy[0]+","+xy[1]+"]");
		return xy;
	}
	
	public void setDirection(char direction)
	{
		this.dir = direction;
	}
	
	public char getDirection()
	{
		return dir;
	}
	
	public int[] getMapSize()
	{
		int[] mapsize = {mapislands.length-1,mapislands[0].length-1};
		return mapsize;
	}
	
	public void showIslands()
	{
		hiddenIslands = false;
	}
	
	public void hideIslands()
	{
		hiddenIslands = true;
	}
	
	public boolean move(String str)
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
			if(hiddenIslands == false && isIsland(xxyy) && newdirection == '?')
			{
				System.out.println("Statek napotkal wyspe na pozycji ["+xxyy[0]+","+xxyy[1]+"]");
				return false;
			}
			else if(newdirection == '?')
			{
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
