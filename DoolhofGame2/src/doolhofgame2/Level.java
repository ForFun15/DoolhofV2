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
//    private Speler speler;
    private int levelNr = 1;
    
    private JButton opnieuw;
    private JPanel paneelLevel;
    private JLabel label;

    public Level() {

        setLayout(null);
        setBackground(Color.BLACK);
        setSize(900, 700);
        setFocusable(true);
//        addKeyListener(new Toetsenbord());
        start();

    }

    private void start() {

        paneelLevel = new Teller();
        paneelLevel.setBounds(450, 0, 200, 50);
        add(paneelLevel);
        
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
        opnieuw.setBounds(700,10, 80, 30);
        add(opnieuw);
        
        doolhof = new Doolhof(levelNr);
//        speler = new Speler();
        doolhof.setBounds(60, 50, 850, 650);
        doolhof.repaint();
//        add(speler);
        add(doolhof);
    }

    private void btnStartMouseClicked(MouseEvent evt) {
//       this.setVisible(true);
    }
    
//    public void paint(Graphics g) {
//        super.paint(g);
//        g.drawImage(speler.getImage(), speler.getPositieX(), speler.getPositieY(), null);
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        speler.move();
//        repaint();
//    }

//    private class Toetsenbord extends KeyAdapter {
//
//        public void keyReleased(KeyEvent e) {
//            speler.keyReleased(e);
//        }
//
//        public void keyPressed(KeyEvent e) {
//            speler.keyPressed(e);
//        }
//    }

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
