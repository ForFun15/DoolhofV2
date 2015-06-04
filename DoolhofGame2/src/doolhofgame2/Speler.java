/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Karen
 */
public class Speler extends JComponent {

    private int positieX, positieY;
    private Image image, imgR, imgL, imgU, imgD;
    private Pad pad;
    private int dir;// 0:up 1:right 2:down 3:left
    //private Bazooka bazooka = null;
    private SpelItem bazooka = null;

    public Speler() {

        image = new ImageIcon(getClass().getResource("/resources/imgR.png")).getImage();
        loadImages();
    }

//    public Speler(Pad pad) {
//        setPad(pad);
//    }
    public void setPad(Pad pad) {
        this.pad = pad;
        pad.setSpeler(this);
    }

    public Pad getPad() {
        return pad;
    }

    public void setBazooka(SpelItem bazooka) {
        this.bazooka = bazooka;
        bazooka.setSpeler(this);

    }

    public SpelItem getBazooka() {
        return bazooka;
    }

//
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }

    public void schietMuur() {
        if (bazooka != null) {
            bazooka.voerActie();
            setBazooka(null);
            //System.out.println("bazookka" + getBazooka());
        }
    }

    public void move(int d) {

        if (canMove(d)) {
            Pad buur = (Pad) getBuur(d);
            raakSpelItem(pad);
            swapPad(pad, buur);
        }

    }

    public boolean canMove(int d) {
        boolean result = false;
        Vakje buur = getBuur(d);

        if (buur == null) {
            result = false;
        } else {
            if (buur.isWalkable) {
                result = true;
            }
        }

        return result;
    }

    private void raakSpelItem(Pad pad) {

        if (pad.getSpelitem() != null) {
            if (pad.getSpelitem().isPickable == true) {
                setBazooka(pad.getSpelitem());
                pad.setSpelitem(null);
                //System.out.println("bazookka" + getBazooka());

            } else {

                pad.getSpelitem().voerActie();
                //System.out.println("get" + pad.getSpelitem());
                pad.setSpelitem(null);

            }
        }

    }

    private Vakje getBuur(int d) {
        Vakje buur = pad.getEast();
        if (d == 0) {
            buur = pad.getNorth();
            setDir(0);
        } else if (d == 1) {
            buur = pad.getEast();
            setDir(1);
        } else if (d == 2) {
            buur = pad.getSouth();
            setDir(2);
        } else if (d == 3) {
            buur = pad.getWest();
            setDir(3);
        }
        return buur;
    }

    private void loadImages() {

        imgR = new ImageIcon(getClass().getResource("/resources/imgR.png")).getImage();
        imgL = new ImageIcon(getClass().getResource("/resources/imgL.png")).getImage();
        imgU = new ImageIcon(getClass().getResource("/resources/imgU.png")).getImage();
        imgD = new ImageIcon(getClass().getResource("/resources/imgD.png")).getImage();
    }

    private void swapPad(Pad from, Pad to) {

        setPad(to);
        from.setSpeler(null);
        from.repaint();
        to.repaint();


    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
        if (dir == 1) {
            setImage(imgR);
        }
        if (dir == 3) {
            setImage(imgL);
        }
        if (dir == 0) {
            setImage(imgU);
        }
        if (dir == 2) {
            setImage(imgD);
        }

    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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
}
