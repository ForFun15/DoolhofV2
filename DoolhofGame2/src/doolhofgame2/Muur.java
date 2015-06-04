/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Karen
 */
public class Muur extends Vakje {
    
    public Muur(int i) {
        image = switchImage(i);
        isWalkable = false;
    }
    
    @Override
    public void setIsWalkable(boolean isWalkable) {
        this.isWalkable = isWalkable;
        repaint();
        if (this.isWalkable == true) {
            setWalkableImage();            
            repaint();
        }
    }
    
   public void setSpeler(Speler speler) {
        this.speler = speler;
        if (speler != null) {
            image = speler.getImage();
        } else {
            image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
        }
    }
    
    public void setWalkableImage() {
        this.image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, posX, posY, this);
        if (speler != null) {
            speler.repaint();
        }
        
    }
    
    private Image switchImage(int i) {
        
        ArrayList<Image> listImage = new ArrayList<>();
        listImage.add(new ImageIcon(getClass().getResource("/resources/muur.png")).getImage());
        listImage.add(new ImageIcon(getClass().getResource("/resources/muur1.png")).getImage());
        listImage.add(new ImageIcon(getClass().getResource("/resources/muur2.png")).getImage());
        listImage.add(new ImageIcon(getClass().getResource("/resources/muur3.png")).getImage());
        
        return listImage.get(i);
    }
}
