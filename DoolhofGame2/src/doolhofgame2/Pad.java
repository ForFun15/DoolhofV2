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
        this.speler = speler;
        image = speler.getImage();

    }

    public Pad(SpelItem spelitem) {
        this.spelitem = spelitem;
        image = spelitem.image;

    }

    public Speler getSpeler() {
        return speler;
    }

    public SpelItem getSpelitem() {
        return spelitem;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
//
        if (speler != null) {
            speler.repaint();
        } else if (spelitem != null) {
            spelitem.repaint();
        }


    }
}
