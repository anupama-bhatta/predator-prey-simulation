
/**
 * Name: Anupama Bhatta
 * Date: 03/12/2019
 * Description: A Java application that has a simulation form which displays the grid 
 * with the default number of prey and predator critters.
 */

public class World {
    // Represents a collection of Organism in space 
    
    public static int worldSize;
    Organism[][] grid;
    
    public World(int worldSize) // Constructor that initializes the world - creates the array of empty cells
    {
        this.worldSize = worldSize;
        int i,j;
        
        grid = new Organism[worldSize][worldSize];
        for (i=0; i<worldSize; i++)
        {
            for (j=0; j<worldSize; j++)
            {
                grid[i][j] = null;
            }
        }
    }
    
    public Organism getAt(int x, int y) // Getter to get an Organism at specified index  
    {
        if ((x>=0) && (x<World.worldSize) && (y>=0) && (y<World.worldSize))
            return grid[x][y];
        
        return null;
    }
    
    public void setAt(int x, int y, Organism org) // Setter to place an Organism to a specified index 
    {
        if ((x>=0) && (x<World.worldSize) && (y>=0) && (y<World.worldSize))
        {
            if (org != null)
            {
                org.setWorldCell(new WorldCell(x, y));
            }
            
            grid[x][y] = org;
        }
    }
     
    public void setAt(Organism org)
    {
        
    }
    
    public void simulateOneStep()
    {
        
    }
    
    public void setRandomOrganisms(String type, int count) // Method that randomly puts specified number organisms to the grid
    {
        int i = count;
        while(i>0)
        {
            int x = (int) (Math.random()* worldSize);
            int y = (int) (Math.random()* worldSize);
            
            if (getAt(x,y) == null)
            {
               Organism org = null;
               
               if (type.equalsIgnoreCase("fly"))
                   org = new Fly (this, new WorldCell(x,y));
               
               else if (type.equalsIgnoreCase("spider"))
                   org = new Spider (this, new WorldCell(x,y));
               setAt(x,y,org);
               
               i--;
            }
            
        
        }
    }
    
    public boolean isInWorld(int x, int y)
    {
        return true;
    }
    
}
