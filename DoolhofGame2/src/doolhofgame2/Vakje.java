/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author Karen
 */
public class Vakje extends JComponent {

    public Image image;
    public Vakje[] buren;

    public Vakje() {
        buren = new Vakje[4];
    }

    @Override
    public int getHeight() {
        return 30;
    }

    @Override
    public int getWidth() {
        return 30;
    }
}
