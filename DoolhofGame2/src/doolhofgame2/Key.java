/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Eigenaar
 */
public class Key implements KeyListener{
private Speler speler;
  

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT) {
                //grens bepalen
                if (speler.positieX <= 0) {
                    speler.positieX = 0;
                } else {
                    speler.positieX -= 10;
                }
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                if (speler.positieX >= 230) {
                    speler.positieX = 230;

                } else {
                    speler.positieX += 10;
                }
            }
            if (keyCode == KeyEvent.VK_UP) {
                if (speler.positieY <= 25) {
                    speler.positieY = 25;

                } else {
                    speler.positieY -= 10;
                }
            }
            if (keyCode == KeyEvent.VK_DOWN) {
                if (speler.positieY >= 230) {
                    speler.positieY = 230;

                } else {
                    speler.positieY += 10;
                }
            }
        }

        
    @Override
    public void keyTyped(KeyEvent ke) {
       
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
    
}
