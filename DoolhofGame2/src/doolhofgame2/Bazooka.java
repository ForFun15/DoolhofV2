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
public class Bazooka extends SpelItem {

    private Speler speler = null;

    public Bazooka() {
        image = new ImageIcon(getClass().getResource("/resources/imgBaz.png")).getImage();
        isPickable = true;
    }

    @Override
    public void voerActie() {
        super.voerActie();
        actie();

    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    public void actie() {
        int dir = speler.getDir();
        if (dir == 0) {
            if (!speler.getPad().getNorth().isWalkable) {
                Pad pad = new Pad();
                speler.getPad().setNorth(pad);
            }
        }
        if (dir == 1) {
            if (!speler.getPad().getEast().isWalkable) {
                Pad pad = new Pad();
                speler.getPad().setEast(pad);
            }
        }
        if (dir == 2) {
            if (!speler.getPad().getSouth().isWalkable) {
                Pad pad = new Pad();
                speler.getPad().setSouth(pad);
            }
        }
        if (dir == 3) {
            if (!speler.getPad().getWest().isWalkable) {
                Pad pad = new Pad();
                speler.getPad().setWest(pad);
            }
        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
