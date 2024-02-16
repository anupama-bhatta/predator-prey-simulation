package MainPackage;

import java.util.ArrayList;

/**
 * Name: Anupama Bhatta
 * Date: 03/20/2019
 * Description: A Java application with a simple 2D predator-prey simulation.
 */

class Spider extends Organism
{
	private boolean hasEaten;

    public Spider(World world, int x, int y)
    {
        super(Configs.spiderBreedTicks, Configs.spiderStarveTicks, Configs.spiderMoveTicks, Configs.spiderMoveRangeInCells, world,x,y);
        checkConstraints();
    }
   

    public Spider(int breedTicks, int starveTicks, int moveTicks, int moveRangeInCells, World world, int x, int y, boolean hasEaten)
    {
        super(Configs.spiderBreedTicks, Configs.spiderStarveTicks, Configs.spiderMoveTicks, Configs.spiderMoveRangeInCells, world,x,y);
        this.hasEaten = hasEaten;
        checkConstraints();
    }
   
        
    public boolean isHasEaten() {
        return hasEaten;
    }

    	
    /***
    * Method to check the constraints of the model to make sure it makes sense.
        * @return 
        */ 
    private boolean checkConstraints()
    {
        boolean bReturn = true;
        //must be able to breed before starve
        if (starveTicks <= breedTicks)
        {
            bReturn = false;
            System.out.print(getClass().toString() + " Class: cannot breed before starving. counterBreedTicks("+counterBreedTicks+"; counterStarveTicks("+counterStarveTicks+")");
        }

        //must be able to move before starve
        if (starveTicks <= moveTicks)
        {
            bReturn = false;
            System.out.print(getClass().toString() + " Class: cannot move before starving. MOVE("+moveTicks+"; counterStarveTicks("+counterStarveTicks+")");
        }

        return bReturn;
    }


    public void eat()
    {
        this.hasEaten = true;
        this.counterStarveTicks = 0;
    }
    
    public void breed()
    {
	if (this.breedTicks > Configs.spiderBreedTicks)
            return;
        
        Coordinates cell = cellToMove(Configs.BREED_RANGE, Configs.BREEDMOVE.BREED);
            if (cell != null){
                Spider newSpider = new Spider(world, cell.getX(), cell.getY());
                world.setAt(newSpider);
            }
                this.breedTicks = 0;  
    }

    public void move()			
    {
        hasMoved = true;
                               
            if (this.moveTicks <= counterMoveTicks)
            {
                Coordinates cell = cellToMove(Configs.spiderMoveRangeInCells, Configs.BREEDMOVE.MOVE);
                    if (cell != null)
                    {
                        Organism org = world.getAt(cell.getX(), cell.getY());
                        world.setAt(cell.getX(),cell.getY(), org); 
                        world.setAt(this.getX(), this.getY(), null);
                    }
            }  
    }  

    public boolean starve()	
    {
        if (this.starveTicks >= Configs.spiderStarveTicks)
            return true;
        else
            return false;
    }

    @Override
    public Coordinates cellToMove(int iRange, Configs.BREEDMOVE nameBreedmove)
        {
        // handle horizontal line
        int horStartPosition;
        ArrayList<Coordinates> list = new ArrayList<Coordinates>();
        
        for (int i = 0; i <= iRange; i++)
        {
            horStartPosition = this.getX()-(iRange+i);
            if (this.getX() == horStartPosition)
                return null;
            
            if (!world.isInWorld(horStartPosition, this.getY()))
                continue;
            
            if ((world.getAt(horStartPosition, this.getY())instanceof Fly))
                continue;
           
            if ((world.getAt(horStartPosition, this.getY())instanceof Spider))
                continue;
            
            if (needCellToBreed)
            {
                if ((world.getAt(horStartPosition, this.getY()) != null))
                continue;
            }
            
            Coordinates cell = new Coordinates(horStartPosition, this.getY());
            list.add(cell);
            
        }
               
        // handle vertical line        
        int verStartPosition;
        for (int j=0; j <= iRange; j++)
        {
            verStartPosition = this.getY()-(iRange+j);
            if (this.getY() == verStartPosition)
                return null;
            
            if (!world.isInWorld(this.getX(), verStartPosition))
                continue;
            
            if ((world.getAt(this.getY(), verStartPosition)instanceof Fly))
                continue;
            
            if ((world.getAt(this.getY(), verStartPosition)instanceof Spider))
                continue;
             
            if (needCellToBreed)
            {
                if ((world.getAt(this.getY(), verStartPosition) != null))
                continue;
            }
            
            Coordinates cell = new Coordinates(this.getX(), verStartPosition);
            list.add(cell);
            
        }
        
        int iRandom = (int) (Math.random() * list.size());
        if (list.size() == 0)
            return null;
        else
            return list.get(iRandom);
                        
        }
    }
    



