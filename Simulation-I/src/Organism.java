
/**
 * Name: Anupama Bhatta
 * Date: 03/12/2019
 * Description: A Java application that has a simulation form which displays the grid 
 * with the default number of prey and predator critters.
 */

public abstract class Organism {
    // Parent class that cannot be instantiated - UMBRELLA CLASS
    
    int breedTicks; 
    int starveTicks; 
    int moveTicks;
    int moveRangeInCells;
    int counterMoveTicks;
    int counterBreedTicks;
    int counterStarveTicks;
    World world;  
    WorldCell worldCell;

    void incrementTicks()
    {
        
    }
    
    // Abstract Methods
    
    abstract void breed();
 
    abstract void move();
    
    abstract boolean starve();
    
    abstract WorldCell cellToMove();
    
    // End of abstract methods
    
    public void setWorldCell(WorldCell worldCell) { // Setter for worldCell
        this.worldCell = worldCell;
    }

    // Getters and setters for all attributes
    
    public int getBreedTicks() {
        return breedTicks;
    }

    public void setBreedTicks(int breedTicks) {
        this.breedTicks = breedTicks;
    }

    public int getStarveTicks() {
        return starveTicks;
    }

    public void setStarveTicks(int starveTicks) {
        this.starveTicks = starveTicks;
    }

    public int getMoveTicks() {
        return moveTicks;
    }

    public void setMoveTicks(int moveTicks) {
        this.moveTicks = moveTicks;
    }

    public int getMoveRangeInCells() {
        return moveRangeInCells;
    }

    public void setMoveRangeInCells(int moveRangeInCells) {
        this.moveRangeInCells = moveRangeInCells;
    }

    public int getCounterMoveTicks() {
        return counterMoveTicks;
    }

    public void setCounterMoveTicks(int counterMoveTicks) {
        this.counterMoveTicks = counterMoveTicks;
    }

    public int getCounterBreedTicks() {
        return counterBreedTicks;
    }

    public void setCounterBreedTicks(int counterBreedTicks) {
        this.counterBreedTicks = counterBreedTicks;
    }

    public int getCounterStarveTicks() {
        return counterStarveTicks;
    }

    public void setCounterStarveTicks(int counterStarveTicks) {
        this.counterStarveTicks = counterStarveTicks;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    
    // End of getters and setters
    
}
