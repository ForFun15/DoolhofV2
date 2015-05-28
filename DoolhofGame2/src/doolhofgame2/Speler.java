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
public class Speler extends JComponent{

    private int positieX, positieY, dx, dy;
    private Image image, imgR, imgL, imgU, imgD;

    public Speler() {

        this.positieX = 80;
        this.positieY = 80;
        image = new ImageIcon(getClass().getResource("/resources/imgR.png")).getImage();

    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, getX(), getY(), this);
    }

    public void move() {
        positieX += dx;
        positieY += dy;
        setLocation(positieX, positieY);
    }
    

    public Image getImage() {
        return image;
    }

    public int getPositieX() {
        return positieX;
    }

    public int getPositieY() {
        return positieY;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }
        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    private void loadImages() {


        imgR = new ImageIcon(getClass().getResource("resources/imgR.png")).getImage();
        imgL = new ImageIcon(getClass().getResource("resources/imgL.png")).getImage();
        imgU = new ImageIcon(getClass().getResource("resources/imgU.png")).getImage();
        imgD = new ImageIcon(getClass().getResource("resources/imgD.png")).getImage();
    }
}
