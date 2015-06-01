/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Karen
 */
public class Level extends JPanel {
    
    private Boolean endLevel;
    private Boolean gameOver;
    private Doolhof doolhof;
    private int levelNr = 1;
    private Teller timer;
    private JLabel label;
    private JButton opnieuw;
    private final int X = 26;
    private final int Y = 20;
    private Vakje[][] matrix;
//    private Speler speler;

    public Level() {
        
        setLayout(null);
        setBackground(Color.BLACK);
        setSize(900, 700);
        
        start();
        
        
    }
    
    private void start() {

        timer = new Teller(10);
        timer.setBounds(600, 10, 100, 30);
        add(timer);

        
        label = new JLabel("Level " + levelNr);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        label.setBounds(100, 0, 100, 50);
        label.setForeground(Color.GREEN);
        add(label);
        
        opnieuw = new JButton("Restart");
        opnieuw.setForeground(Color.GREEN);
        opnieuw.setBackground(Color.BLACK);
        opnieuw.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent evt) {
                btnStartMouseClicked(evt);
            }
        });
        opnieuw.setBounds(700, 10, 80, 30);
        add(opnieuw);
        
        doolhof = new Doolhof(levelNr, X, Y);
        doolhof.requestFocus();
        doolhof.setFocusable(true);
        doolhof.requestFocusInWindow();
        doolhof.setLocation(60, 50);
      
        add(doolhof);

    }
    
    private void btnStartMouseClicked(MouseEvent evt) {
        timer.stopTimer();
        this.repaint();
        start();
    }
    
     public Boolean getEndLevel() {
        return endLevel;
    }
    
    public void setEndLevel(Boolean endLevel) {
        this.endLevel = endLevel;
    }
    
    public Boolean getGameOver() {
        return gameOver;
    }
    
    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    public int getLevelNr() {
        return levelNr;
    }
    
    public void setLevelNr(int levelNr) {
        this.levelNr = levelNr;
    }
}
