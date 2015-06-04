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
public class SpelItem extends JComponent {

    protected Image image;
    protected boolean isPickable = false;
    protected Speler speler = null;
    

    public SpelItem() {
    }

    public void voerActie() {
        
    }
    
      public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }
}
