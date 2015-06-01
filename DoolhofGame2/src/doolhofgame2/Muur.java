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
public class Muur extends Vakje {

    public Muur() {
        image = new ImageIcon(getClass().getResource("/resources/muur.png")).getImage();

    }

  protected void paintComponent(Graphics g) {
        
        g.drawImage(image, posX, posY, this);
        super.paintComponent(g);
    }
}
