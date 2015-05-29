/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Karen
 */
public class Speler extends JFrame implements ActionListener{

    public int positieX, positieY, dx, dy;
    private Image image, imgR, imgL, imgU, imgD;
    private Key key;

    public Speler() {
        addKeyListener(key);
        this.positieX = 0;
        this.positieY = 0;
        image = new ImageIcon(getClass().getResource("/resources/imgR.png")).getImage();

    }
    
    
    protected void paintComponent(Graphics g){
        //super.paintComponent(g);
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

//    public int getPositieX() {
//        return positieX;
//    }
//
//    public int getPositieY() {
//        return positieY;
//    }
//    
//    public int setPositieX()
//    {
//        return positieX;
//    }
//    public int setPositieY()
//    {
//        return positieY;
//    }
    
    

//    public void keyPressed(KeyEvent e) {
//        int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_LEFT) {
//            dx = -1;
//        }
//        if (key == KeyEvent.VK_RIGHT) {
//            dx = 1;
//        }
//        if (key == KeyEvent.VK_UP) {
//            dy = -1;
//        }
//        if (key == KeyEvent.VK_DOWN) {
//            dy = 1;
//        }
//    }
//
//    public void keyReleased(KeyEvent e) {
//        int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_LEFT) {
//            dx = 0;
//        }
//        if (key == KeyEvent.VK_RIGHT) {
//            dx = 0;
//        }
//        if (key == KeyEvent.VK_UP) {
//            dy = 0;
//        }
//        if (key == KeyEvent.VK_DOWN) {
//            dy = 0;
//        }
//    }

    private void loadImages() {


        imgR = new ImageIcon(getClass().getResource("resources/imgR.png")).getImage();
        imgL = new ImageIcon(getClass().getResource("resources/imgL.png")).getImage();
        imgU = new ImageIcon(getClass().getResource("resources/imgU.png")).getImage();
        imgD = new ImageIcon(getClass().getResource("resources/imgD.png")).getImage();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
