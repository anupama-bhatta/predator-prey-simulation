
/**
 * Name: Anupama Bhatta
 * Date: 03/12/2019
 * Description: A Java application that has a simulation form which displays the grid 
 * with the default number of prey and predator critters.
 */

public class Spider extends Organism { 
    // Inherits from Organism class
    
    private boolean hasEaten;

    public Spider(World world, WorldCell dimension) {
        this.world = world;
        this.worldCell = dimension;       
    }
    
    void incrementTicks()
    {
        
    }
    
    void breed()
    {
        
    }
    
    void move()
    {
        
    }
    
    boolean starve() 
    {
      return true;  
    }
    
    WorldCell cellToMove()
    {
        return worldCell;
    }
    
    // Getters and setters for attributes in parent class

    public boolean isHasEaten() {
        return hasEaten;
    }

    public void setHasEaten(boolean hasEaten) {
        this.hasEaten = hasEaten;
    }

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

    public WorldCell getWorldCell() {
        return worldCell;
    }

    public void setWorldCell(WorldCell worldCell) {
        this.worldCell = worldCell;
    }
    
    // End of getters and setters
}
