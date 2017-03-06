package ships;

public class Ship 
{
	//Ship Position
	private int[] xy = {0,0};
	//Ship Direction
	private char dir = 'N';
	
	//Map Size and Islands
	private int[][] mapislands = new int[20][20];
	
	mapislands[3][3] = 1;
	mapislands[7][5] = 1;
	mapislands[13][3] = 1;
	mapislands[15][15] = 1;
	mapislands[14][15] = 1;
	
	
    public void setPosition(int[] xxyy)
    {
		xy = xxyy;
	}
	
	public int[] getPosition()
	{
		return xy;
	}
	
	public void setDirection(char direction)
	{
		dir = direction;
	}
	
	public char getDirection()
	{
		return dir;
	}
	
	public int[] getMapSize()
	{
		int[] mapsize = {mapislands.length,mapislands[0].length}
		return mapsize;
	}
	
	public boolean move(String str)
	{
		//nnnlnnpnnw
		int n = str.length()
		for(int i=0,i<n,i++)
		{
			char c = str.charAt(i);
			int xxyy = getPosition();
			char direction = getDirection();
			
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
						direction = 'W';
					else if(direction=='S')
						direction = 'E';
					else if(direction=='E')
						direction = 'N';
					else if(direction=='W')
						direction = 'S';		
					break
				case 'p':
					if(direction=='N')
						direction = 'E';
					else if(direction=='S')
						direction = 'W';
					else if(direction=='E')
						direction = 'S';
					else if(direction=='W')
						direction = 'N';		
					break
				default: 
					return false;
					break;
			}
			setDirection(direction);
			if(isIsland(xxyy))
			{
				System.out.println("Statek napotkal wyspe na pozycji ["+xxyy[0]+","+xxyy[1]+"]");
				return false;
			}
			else
			{
				System.out.println("RUCH NA POLE ["+xxyy[0]+","+xxyy[1]+"]");
				setPosition(xxyy);	
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
