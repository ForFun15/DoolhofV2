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

    public Bazooka() {
        image = new ImageIcon(getClass().getResource("/resources/imgBaz.png")).getImage();
        isPickable = true;

    }

    public void setPad(Pad pad) {
        this.pad = pad;
    }

    public Pad getPad() {
        return pad;
    }

    @Override
    public void setSpeler(Speler speler) {
        super.setSpeler(speler);
    }

    
    public void voerActie(int dir) {
       
        if (dir == 0) {
            if (!speler.getPad().getNorth().isWalkable) {
                speler.getPad().getNorth().setIsWalkable(true); 
                               
            }
        }
        if (dir == 1) {
            
            if (!speler.getPad().getEast().isWalkable) {
                Pad nPad = new Pad();
                speler.getPad().setEast(nPad);
                nPad.repaint();
                System.out.println("Muur");
            }
        }
        if (dir == 2) {
            if (!speler.getPad().getSouth().isWalkable) {
                Pad nPad = new Pad();
                speler.getPad().setSouth(nPad);
            }
        }
        if (dir == 3) {
            if (!speler.getPad().getWest().isWalkable) {
                Pad nPad = new Pad();
                speler.getPad().setWest(nPad);
            }
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
