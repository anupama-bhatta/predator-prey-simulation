
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Name: Anupama Bhatta
 * Date: 03/12/2019
 * Description: A Java application that has a simulation form which displays the grid 
 * with the default number of prey and predator critters.
 */

public class Cell extends JLabel {
    // Visual representation of an Organism on the form 
    
    private int row;
    private int col;
    private int size;
    private Organism organism;
    private int id;
    private boolean isOccupied;

    public Cell(int x, int y, Organism organism) { 
    // Constructor that initializes Cell by assigning the indexes and organism and displaying the correct picture
    
        this.row = x;
        this.col = y;
        this.organism = organism;
        this.size = 50;
        if (organism instanceof Fly)
        {
            this.setBackgroundImage(Configs.imageDir + "fly.png");
        }
        else if(organism instanceof Spider)
        {
            this.setBackgroundImage(Configs.imageDir + "spiderweb.png");
        }
        
    }
    
    private void setBackgroundImage(String imagePath) {       
        int iSize = (int) ((double)size/1.5);        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(iSize, iSize, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImage);
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setIcon(imageIcon);
    } 

    // Getters and setters for all attributes 
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Organism getOrganism() {
        return organism;
    }

    public void setOrganism(Organism organism) {
        this.organism = organism;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
    
    // End of getters and setters
      
}
