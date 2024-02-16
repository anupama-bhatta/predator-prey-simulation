package MainPackage;

/**
 * Name: Anupama Bhatta
 * Date: 03/20/2019
 * Description: A Java application with a simple 2D predator-prey simulation.
 */

/**
* Definition for the Organism base class.
* Each organism has a reference back to
* the World object so it can move itself
* about in the world.
*/
abstract class Organism
{
	protected Coordinates coor;		// Position in the world
        
	protected boolean hasMoved;	// Bool to indicate if hasMoved this turn
        protected boolean needCellToBreed;
        
	protected int breedTicks;	// Number of ticks it takes before breeding
	protected int starveTicks;	// Number of ticks before starving
	protected int moveTicks;	// Number of ticks before moving
        
        protected int moveRangeInCells; //how many cells an organism can move per tick
           
        protected int counterMoveTicks;         // Number of ticks since last move
        protected int counterBreedTicks;	// Number of ticks since breeding
	protected int counterStarveTicks;	// Number of ticks since last feeding
        protected int id;
        private static int objectCounter;
     
        protected World world;	// Reference to the world object so we can update its grid when we move around in the world
       
	public Organism(int breedTicks, int starveTicks, int moveTicks, int moveRangeInCells)
	{
		world = null;
		hasMoved = false;
                
                this.moveTicks = moveTicks;
		this.breedTicks = breedTicks;
                this.starveTicks = starveTicks;
                this.moveRangeInCells = moveRangeInCells;
                
		coor = new Coordinates(0,0);
                id = objectCounter;
                objectCounter++;
	}

        
	public Organism(int breedTicks, int starveTicks, int moveTicks, int moveRangeInCells, World world, int x, int y)
	{
		this(breedTicks, starveTicks, moveTicks, moveRangeInCells);
                
                coor = new Coordinates(x, y);		
		
		this.world = world;                
	}

        
        /*       
           public void resetCounterMoveTicks() {
               this.counterMoveTicks = 0;
           }

           public void resetCounterBreedTicks() {
               this.counterBreedTicks = counterBreedTicks;
           }
       */
        public void resetCounterStarveTicks() {
        this.counterBreedTicks = counterBreedTicks;
        }
  
        public boolean getHasMoved(){
            return hasMoved;
        }

        public void setMoved(boolean moved){
            hasMoved = moved;
        }

        public Coordinates getCoor(){
            return coor;
        }

        public void setCoor(Coordinates coor) {
            this.coor = coor;
        }

        
        public int getX(){
            return coor.getX();
        }

        public int getY(){
            return coor.getY();
        }
    
        public void incrementCounters()
        {
            counterBreedTicks++;
            counterStarveTicks++;
            counterMoveTicks++;    
        }
       
    
	/**
	* Determines whether or not this organism should breed
	*/
	public abstract void breed();

	/**
	* Determines how this organism should move
	*/
	public abstract void move();
        /**
	* Determines if this organism starves
	*/
	public abstract boolean starve();

        public abstract Coordinates cellToMove(int range, Configs.BREEDMOVE nameBreedmove );
	
} 
