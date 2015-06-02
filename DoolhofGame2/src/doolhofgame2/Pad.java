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

    private SpelItem spelitem = null;
    private Speler speler;

    public Pad() {
        image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
        isWalkable = true;
    }

    public Pad(SpelItem spelitem) {
        this.spelitem = spelitem;
        isWalkable = true;
        if (spelitem != null) {
            image = spelitem.image;
        } else {
            image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
        }
    }

    public void setSpelitem(SpelItem spelitem) {
        this.spelitem = spelitem;
        if (spelitem != null) {
            image = spelitem.image;
        } else {
            image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
        }
    }

    public SpelItem getSpelitem() {
        return spelitem;
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
        if (speler != null) {
            image = speler.getImage();
        } else {
            image = new ImageIcon(getClass().getResource("/resources/pad.png")).getImage();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, posX, posY, this);
        if (speler != null) {
            speler.repaint();
        }
        if (spelitem != null) {
            spelitem.repaint();
        }
    }
}
