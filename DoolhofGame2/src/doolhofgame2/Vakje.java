/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author Karen
 */
public class Vakje extends JComponent {

    protected Image image;
    public Vakje[] buren = new Vakje[4];
    //north 0, east 1, south 2, west 3
    protected int posX, posY;
    protected boolean isWalkable = false;
    protected int levelVk;

    public Vakje() {
    }
    public Vakje(int levelVk){
        this.levelVk = levelVk;
  
        
    }

    public void switchImage(){
        
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Vakje getNorth() {
        return buren[0];
    }

    public Vakje getEast() {
        return buren[1];
    }

    public Vakje getSouth() {
        return buren[2];
    }

    public Vakje getWest() {
        return buren[3];
    }
}
