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

    @Override
    public void voerActie() {
        super.voerActie();
        
    }
    
    

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
