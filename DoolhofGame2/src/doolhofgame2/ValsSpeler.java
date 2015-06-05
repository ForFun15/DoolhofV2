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
public class ValsSpeler extends SpelItem {

    private Level level;

    public ValsSpeler() {
        image = new ImageIcon(getClass().getResource("/resources/estrella.gif")).getImage();

    }

    public ValsSpeler(Level level) {
        this.level = level;
        image = new ImageIcon(getClass().getResource("/resources/estrella.gif")).getImage();

    }

    @Override
    public void voerActie() {
        super.voerActie();
        actie();
    }

    private void actie() {
        level.timer.setTeller(20);
        level.timer.repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }
}
