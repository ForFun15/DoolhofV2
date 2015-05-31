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
public class Vriend extends SpelItem{
    public Vriend(){
    image = new ImageIcon(getClass().getResource("/resources/imgVriend.png")).getImage();
   
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
