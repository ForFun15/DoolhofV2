/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author Karen
 */
public class Vakje extends JComponent {

    public Image image;
    public Vakje[] buren = new Vakje[4];
    //north 0, east 1, south 2, west 3

    public Vakje() {
    }

   

//    public void printBuren() {
//        for (int i = 0; i < buren.length; i++) {
//            if (buren[i] != null) {
//                System.out.println(buren[i].toString());
//            }
//        }
//    }
}
