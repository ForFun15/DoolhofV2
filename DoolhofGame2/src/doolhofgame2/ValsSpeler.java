/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Karen
 */
public class ValsSpeler extends SpelItem {
    
    public ValsSpeler(){
    image = new ImageIcon(getClass().getResource("/resources/estrella.gif")).getImage();
  
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, getX(), getY(), this);
    }
}
