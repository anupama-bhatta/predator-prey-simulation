package MainPackage;


import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Name: Anupama Bhatta
 * Date: 03/20/2019
 * Description: A Java application with a simple 2D predator-prey simulation.
 */

public class Cell extends JLabel {
   private Coordinates coor;
   
    private int id;
    
    private boolean isOccupied;
    
    private Organism organism;
    
    private final int size;
    
    public Cell(int iSize, int row, int col, Organism org)
    {
        coor = new Coordinates(row, col);
       
        this.size = iSize;
        
        setSize(size, size);
        
        if (org  instanceof Fly)
        { 
            setBackgroundImage(Configs.getFlyImagePath()); 
        }
        else if (org  instanceof Spider)
            setBackgroundImage(Configs.getSpiderImagePath());
        else
        {
           // setText(coor.getX() + ":" + coor.getY() );
           // setFont(new java.awt.Font("Tahoma", 1, 9));             
        }
        
         setBorder(BorderFactory.createEtchedBorder());  
        
        
    }
    
    public void setBackgroundImage(String imagePath)
    {
        int iSize = (int)((double)size/1.5);
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath)); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(iSize, iSize,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setIcon(imageIcon);
    }
    
    public Organism getOrganism()
    {
        return organism;
    }
  
    public int getRow() {
        return coor.getX();
    }

    public void setRow(int row) {
        coor.setX(row);
    }

    public int getCol() {
        return coor.getY();
    }

    public void setCol(int col) {
        coor.setY(col);
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

    public void setOrganism(Organism critter)
    {
        organism = critter;
    }
    
    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
        if (isOccupied==false)
            setIcon(null);
    }
}
