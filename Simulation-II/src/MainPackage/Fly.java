package MainPackage;

import java.util.ArrayList;

/**
 * Name: Anupama Bhatta
 * Date: 03/20/2019
 * Description: A Java application with a simple 2D predator-prey simulation.
 */

class Fly extends Organism
{
    public Fly(World world, int x, int y)
    {
         super(Configs.flyBreedTicks, Configs.flyStarveTicks, Configs.flyMoveTicks, Configs.flyMoveRangeInCells, world,x,y);
    }

    public void breed()			
    {
	if (this.breedTicks >= Configs.flyBreedTicks)
            return;
        
        Coordinates cell = cellToMove(Configs.BREED_RANGE, Configs.BREEDMOVE.BREED);
            if (cell != null){
                Fly newFly = new Fly(world, cell.getX(), cell.getY());
                world.setAt(newFly);
        }
            this.breedTicks = 0;
	}
        
    public void move()			
    {
        if (this.getHasMoved() == true)
            return;
             
        if (this.moveTicks <= counterMoveTicks)
        {

            Coordinates cell = cellToMove(Configs.flyMoveRangeInCells, Configs.BREEDMOVE.MOVE);
            
            Coordinates previousCell = this.getCoor();
          
                if (cell != null){
                    Organism org = world.getAt(cell.getX(), cell.getY());
                        if (org instanceof Spider){
                            Spider spider = ((Spider) org);
                            spider.eat();
                            }
                            else{
                                world.setAt(cell.getX(),cell.getY(), this); // move the fly to a new cell
                            }
                            world.setAt(previousCell.getX(), previousCell.getY(), null); // kill the fly
                        }
        }  
    }
        
    public boolean starve()
    {
        return true;
    }
        
    @Override
    public Coordinates cellToMove(int iRange, Configs.BREEDMOVE nameBreedmove) {
        {
        // handle horizontal line
        int horStartPosition;
        
        ArrayList<Coordinates> list = new ArrayList<Coordinates>();
        for (int i=0; i <= iRange; i++)
        {
            horStartPosition = this.getX()-(iRange+i);
            if (needCellToBreed)
            {
                if ((world.getAt(horStartPosition, this.getY()) != null))
                continue;
            }
            
            if (this.getX() == horStartPosition)
                return null;
            
            if (!world.isInWorld(horStartPosition, this.getY()))
                continue;
            
            if ((world.getAt(horStartPosition, this.getY())instanceof Fly))
                continue;
                
            Coordinates cell = new Coordinates(horStartPosition, this.getY());
            list.add(cell);
            
        }
               
        // handle vertical line        
        int verStartPosition;
        for (int j=0; j <= iRange; j++)
        {
            verStartPosition = this.getY()-(iRange+j);
            if (needCellToBreed)
            {
                if ((world.getAt(this.getY(), verStartPosition) != null))
                continue;
            }
            
            if (this.getY() == verStartPosition)
                return null;
            
            if (!world.isInWorld(this.getX(), verStartPosition))
                continue;
            
            if ((world.getAt(this.getY(), verStartPosition)instanceof Fly))
                continue;
            
                
            Coordinates cell = new Coordinates(this.getX(), verStartPosition);
            list.add(cell);
            
        }
        
        // generating a random number
        int iRandom = (int) (Math.random() * list.size());
        if (list.size() == 0)
            return null;
        else
            return list.get(iRandom);
                        
        }
    }
}
