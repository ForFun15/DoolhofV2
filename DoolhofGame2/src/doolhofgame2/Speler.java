/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Karen
 */
public class Speler extends JComponent {

    private int positieX, positieY, dx, dy;
    private Image image, imgR, imgL, imgU, imgD;
    private Pad pad;
    private Bazooka bazooka;
//    private Key key;

    public Speler() {
//        addKeyListener(key);
        image = new ImageIcon(getClass().getResource("/resources/imgR.png")).getImage();

    }

//    public Speler(Pad pad) {
//        setPad(pad);
//    }
    public void setPad(Pad pad) {
        this.pad = pad;
        pad.setSpeler(this);
    }

//
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }

    public void move(int d) {

        if (canMove(d)) {
            Pad buur = (Pad) getBuur(d);
            if (buur.getSpelitem() != null) {
                if (buur.getSpelitem().isPickable) {
                    this.bazooka = (Bazooka) buur.getSpelitem();
                } else {
                    buur.getSpelitem().voerActie();
                }
            }
            swapPad(pad, buur);
        }

    }

    public boolean canMove(int d) {
        boolean result = false;
        Vakje buur = getBuur(d);
        if (buur.isWalkable) {
            result = true;
        }

        return result;
    }

    private Vakje getBuur(int d) {
        Vakje buur = pad.getEast();
        if (d == 0) {
            buur = pad.getNorth();
        } else if (d == 1) {
            buur = pad.getEast();
        } else if (d == 2) {
            buur = pad.getSouth();
        } else if (d == 3) {
            buur = pad.getWest();
        }
        return buur;
    }

    public Image getImage() {
        return image;
    }

    public int getPositieX() {
        return positieX;
    }

    public void setPositieX(int positieX) {
        this.positieX = positieX;
    }

    public int getPositieY() {
        return positieY;
    }

    public void setPositieY(int positieY) {
        this.positieY = positieY;
    }

    private void loadImages() {


        imgR = new ImageIcon(getClass().getResource("resources/imgR.png")).getImage();
        imgL = new ImageIcon(getClass().getResource("resources/imgL.png")).getImage();
        imgU = new ImageIcon(getClass().getResource("resources/imgU.png")).getImage();
        imgD = new ImageIcon(getClass().getResource("resources/imgD.png")).getImage();
    }

    private void swapPad(Pad from, Pad to) {
        setPad(to);
        from.setSpeler(null);
        from.repaint();
        to.repaint();
    }
}
