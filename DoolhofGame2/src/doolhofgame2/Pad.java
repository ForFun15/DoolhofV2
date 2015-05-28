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
public class Pad extends Vakje {

    public Speler speler;
    public SpelItem spelitem;

    public Pad() {
        image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
        
    }
    public Pad(Speler speler) {
        image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
        this.speler = speler;
    }
    public Pad(SpelItem spelitem) {
        image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
        this.spelitem = spelitem;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, getX(), getY(), this);
        
    }
}
