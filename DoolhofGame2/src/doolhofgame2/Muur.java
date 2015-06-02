/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;

/**
 *
 * @author Karen
 */
public class Muur extends Vakje {

    public Muur(int i) {
        image = switchImage(i);

    }

    protected void paintComponent(Graphics g) {

        g.drawImage(image, posX, posY, this);
        super.paintComponent(g);
    }

    private Image switchImage(int i) {

        ArrayList<Image> listImage = new ArrayList<>();
        listImage.add(new ImageIcon(getClass().getResource("/resources/muur.png")).getImage());
        listImage.add(new ImageIcon(getClass().getResource("/resources/muur1.png")).getImage());
        listImage.add(new ImageIcon(getClass().getResource("/resources/muur2.png")).getImage());
        listImage.add(new ImageIcon(getClass().getResource("/resources/muur3.png")).getImage());
        
        return listImage.get(i);
    }
}
