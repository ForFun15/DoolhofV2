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

    public Vakje() {
    }

    protected void paintComponent(Graphics g) {
         super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
       
    }

//    public void printBuren() {
//        for (int i = 0; i < buren.length; i++) {
//            if (buren[i] != null) {
//                System.out.println(buren[i].toString());
//            }
//        }
//    }

    
    
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
     public Vakje getWest() {
        return buren[1];
    }
}
