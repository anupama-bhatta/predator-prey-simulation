package MainPackage;

/**
 * Name: Anupama Bhatta
 * Date: 03/20/2019
 * Description: A Java application with a simple 2D predator-prey simulation.
 */

public class World {
     
    public static int worldSize;        
    private Organism[][] grid; // Array of organisms for each cell

    public World(int worldSize)
    {
        this.worldSize = worldSize;
        // Initialize world to empty spaces
	int i,j;

	grid = new Organism[worldSize][worldSize];
            for (i=0; i<worldSize; i++)
            {
		for (j=0; j<worldSize; j++)
		grid[i][j]=null;
            }
    }

    public int getSize()
    {
        return worldSize;
    }

    public Organism getAt(int x, int y)
    {
             if (isInWorld(x,y))
                    return grid[x][y];

            return null;
    }

    public Organism getAt(Coordinates coor)
    {
             if (isInWorld(coor))
                    return grid[coor.getX()][coor.getY()];

            return null;
    }

    public void setAt(Coordinates coor, Organism org)
    {
         if (isInWorld(coor))
        {
            if (org!=null)
                org.setCoor(coor);

            grid[coor.getX()][coor.getX()] = org;
        }
    }

    public void setAt(int x, int y, Organism org)
    {
       if (isInWorld(x,y))
        {
            if (org!=null)
                org.setCoor(new Coordinates(x, y));
            
            grid[x][y] = org;
        }
    }

    public void setAt(Organism org)
    {
        int x = org.getX();
        int y = org.getY();

        if (isInWorld(x,y))
            grid[x][y] = org;

    }
	
    /**
    * SimulateOneStep
    * This is the main routine that simulates one turn in the world.
    * First, a flag for each organism is used to indicate if it has moved.
    * This is because we iterate through the grid starting from the top
    * looking for an organism to move . If one moves down, we don't want
    * to move it again when we reach it.
    * First move flies, then ants, and if they are still alive then
    * we breed them.
    */
    
    public void SimulateOneStep()
    {
        {
        int i, j;
            // reset
            for (i=0; i<World.worldSize; i++)
            {
                for (j=0; j<World.worldSize; j++)
                {
                       if (grid [i][j] != null){
                            grid[i][j].setMoved(false);
                            grid[i][j].incrementCounters();
                       }
                }
            }
            
            // move flies
            for (i=0; i<World.worldSize; i++)
            {
                for (j=0; j<World.worldSize; j++)
                {
                    if (grid[i][j] != null && grid[i][j] instanceof Fly )
                    {
                        grid [i][j].move();
                    }
                }
            }
            
            // move spiders
            for (i=0; i<World.worldSize; i++)
            {
                for (j=0; j<World.worldSize; j++)
                {
                    if (grid[i][j] != null && grid[i][j] instanceof Spider )
                    {
                        grid [i][j].move();
                    }
                }
            }
            
            // starve organisms
            for (i=0; i<World.worldSize; i++)
            {
                for (j=0; j<World.worldSize; j++)
                {
                    if (grid[i][j] != null )
                    {
                        grid [i][j].starve();
                    }
                }
            }
            
            // breed organisms
            for (i=0; i<World.worldSize; i++)
            {
                for (j=0; j<World.worldSize; j++)
                {
                    if (grid[i][j] != null)
                    {
                        grid [i][j].breed();
                    }
                }
            }
        }     
    }
        
        
    public void setRandomOrganisms(Configs.ORGANISM organism, int orgCount)
    {
        int i = orgCount;
        while (i > 0 )
        {
            int x = (int) (Math.random() * getSize());
            int y = (int) (Math.random() * getSize());

            if (getAt(x,y)==null) // only when the cell is vacant
            {
                Organism org = null;
                
                if (organism == Configs.ORGANISM.FLY)
                   org = new Fly (this, x,y);
                else
                   org = new Spider (this, x,y);

                setAt(x,y,org);
                i--; //decrement organism counter by one 
            } 
        }
        
    }
        
    public boolean isInWorld(int x, int y)
    {
        if (x<0 || y<0)
            return false;
        
       if ( x<worldSize && y<worldSize)
           return true;
       else 
           return false;
    }
        
     public boolean isInWorld(Coordinates coor)
    {
        if (coor.getX()<0 || coor.getY()<0)
            return false;
        
       if ( coor.getX()<worldSize && coor.getY()<worldSize)
           return true;
       else 
           return false;
    }       
} 

