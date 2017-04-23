package ships;

public class Map {
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
	
	public boolean isIsland(int[] xxyy)
	{
		if(mapislands[xxyy[0]][xxyy[1]]==1)
			return true;
		else
			return false;
	}
}
