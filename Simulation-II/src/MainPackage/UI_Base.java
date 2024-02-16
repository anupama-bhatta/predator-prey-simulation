package MainPackage;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Name: Anupama Bhatta
 * Date: 03/20/2019
 * Description: A Java application with a simple 2D predator-prey simulation.
 */

public class UI_Base extends javax.swing.JFrame {

    public static enum  FormSize {SMALL, MEDIUM}; 
    private JLabel lblBGImage = new JLabel();
    private int calculatedFormHeight;
    private int calculatedFormWidth;
    
   

     public UI_Base(String sBG)
    {
       initComponents();
       
     
       
       setFrameSizeDimentions(); // set the size of the form by calculating the size of user's screen.
       
      
       
       setBackgroundImageScale(sBG, calculatedFormWidth, calculatedFormHeight);
       
       
       setDefaults();
       
       // formWidth = getWidth();
        //formHeight = getHeight();
      
    }
   
   

    
 
    
      
    private void setDefaults()
    {
         // setUndecorated(true);
 
          setResizable(false);
          setPosition(calculatedFormWidth, calculatedFormHeight);
          
          setAlwaysOnTop(true);
          setBorder();
    }
   
    public void setBorder()
    {
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#182943")));
    }
   
    
    private void setFrameSizeDimentions(){
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //get the user screen size
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
    
        if (screenHeight > screenWidth)
            screenHeight = screenWidth; //just in the case screen height is greater than screen width then make height equeal to width
                                        // this makes sure the smallest dimension is used as the base as we want a square form.

        //determine the size of the world grid, which then will determine the size of the form
        int worldDimension = (int)Math.min(screenHeight - Configs.HEADER_HEGIHT, screenWidth - Configs.CONTROLS_WIDTH);
        worldDimension = worldDimension - 150; //allow 100 pixels for border, other frame paddings, and other user operating system things show on the screen
   

        calculatedFormHeight = worldDimension + Configs.HEADER_HEGIHT; 
        calculatedFormWidth = worldDimension + Configs.CONTROLS_WIDTH;
        
       
        
    }

     
    private void setPosition(int formWidth, int formHeight)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - formWidth) / 2);
        int y = (int) ((dimension.getHeight() - formHeight) / 2);
        setLocation(x, y);
    }
    
    public void setBackgroundImageScale(String imagePath, int iWidth, int iHeight)
    {
        ImageIcon imageIcon =  new javax.swing.ImageIcon(getClass().getResource(imagePath)); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(iWidth, iHeight,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        
      
        lblBGImage.setIcon(imageIcon);
        lblBGImage.setSize(iWidth, iHeight);
         lblBGImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        getRootPane().setContentPane(lblBGImage);
        
       
    }
    public void removeMenu()
    {
        menuFile.remove(itemExit);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barFileMenu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        itemExit = new javax.swing.JMenuItem();

        menuFile.setText("File");

        itemExit.setText("Exit");
        itemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExitActionPerformed(evt);
            }
        });
        menuFile.add(itemExit);

        barFileMenu.add(menuFile);

        setJMenuBar(barFileMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2162, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1182, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemExitActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barFileMenu;
    private javax.swing.JMenuItem itemExit;
    private javax.swing.JMenu menuFile;
    // End of variables declaration//GEN-END:variables
}
