 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author Karen
 */
public class Main extends JFrame {
    
    private Level level;
    private JPanel startPage;
    private JButton start;
    ImageIcon image1;
    ImageIcon image2;
    
    public Main() {
        image1 = new ImageIcon(getClass().getResource("/resources/Slide1.png"));
        image2 = new ImageIcon(getClass().getResource("/resources/Start.png"));
        setTitle("Dolhoof Game");
        setSize(900, 700);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        
        
    }
    
    private void btnStartMouseClicked(MouseEvent evt) {
        
//        startPage.setVisible(false);
//        startPage.setFocusable(false);
//        level = new Level();
//        level.addKeyListener(level);
//        level.setFocusable(true);
//        level.requestFocus(true);
//        add(level);
//        repaint();
//        
    }
    
    public void init() {
        
        start = new JButton();
        start.setIcon(image2);
        start.setLocation(450, 605);
        start.setBorderPainted(false);
        start.setBackground(Color.BLACK);
        start.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnStartMouseClicked(evt);
            }
        });

        level = new Level();
        level.addKeyListener(level);
        level.setFocusable(true);
        level.requestFocus(true);
        add(level);
        
//        JLabel imgPage = new JLabel(image1);
//        startPage = new JPanel();
//        startPage.setBackground(Color.BLACK);
//        startPage.add(imgPage);
//        startPage.setLocation(0, 0);
//        startPage.add(start);
//        add(startPage);
        
        
        setVisible(true);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main principaal = new Main();
        principaal.init();
        
        
    }
}
