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
public class Vriend extends SpelItem {

    //private Level level = new Level();

    

    public Vriend() {
        image = new ImageIcon(getClass().getResource("/resources/imgVriend.png")).getImage();

    }

    @Override
    public void voerActie() {
        super.voerActie();
        actie();

    }

    private void actie() {
        
//        if (level.getLevelNr() < 4) {
//            level.setEndLevel(true);
//            level.nextLevel();
//        } else {
//            level.setEndLevel(true);
//        }

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }
}
