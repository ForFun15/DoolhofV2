/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import javax.swing.*;



/**
 *
 * @author Karen
 */
public class Teller extends JPanel {
    
    private int teller;
    private javax.swing.Timer timer;
    private JButton stopknop, startknop;
    
    public Teller(){
        teller = 60;// tel seconden
        timer = new javax.swing.Timer(1000,new TimerHandler());
        timer.start();
//        
//        startknop= new JButton("Start");
//        stopknop= new JButton("Stop");
//        KnopHandler kh = new KnopHandler();
//        startknop.addActionListener(kh);
//        stopknop.addActionListener(kh);
        setBackground(Color.BLACK);
//        
//        add(startknop);
//        add(stopknop);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.setFont(new Font("SansSerif", Font.BOLD, 14));
        g.drawString("Timer: "+teller, 100, 30);
    }
    
    class TimerHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            teller--;
            repaint();
        }
    }
    
    class KnopHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource()== startknop){
                timer.start();
            }
            if(e.getSource()== stopknop){
                timer.stop();
            }
                
            
        }
    }
}
