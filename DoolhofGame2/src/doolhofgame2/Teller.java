/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Karen
 */
public class Teller extends JPanel {

    private int teller;
    private javax.swing.Timer timer;

    public Teller(int teller) {
        this.teller = teller;// tel seconden
        timer = new javax.swing.Timer(1000, new TimerHandler());
        timer.start();
        setBackground(Color.BLACK);
    }

    public void stopTimer() {
        timer.stop();
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.setFont(new Font("SansSerif", Font.BOLD, 14));
        g.drawString("Timer: " + teller, 10, 20);

    }

    class TimerHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (teller > 0) {
                teller--;
                repaint();
            } else {
                timer.stop();
            }

        }
    }
}
