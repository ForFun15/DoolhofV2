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
public class Level extends JPanel implements KeyListener {

    private Boolean endLevel;
    private Boolean gameOver;
    private Doolhof doolhof;
    private int levelNr = 1;
    private Teller timer;
    private JLabel label;
    private JButton opnieuw;
    


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

            @Override
            public void mouseClicked(MouseEvent evt) {
                btnStartMouseClicked(evt);
            }
        });
        opnieuw.setBounds(700, 10, 80, 30);
        add(opnieuw);

        doolhof = new Doolhof(levelNr);
//        int nextLevel, int currentLevel
        doolhof.setLocation(60, 50);
        doolhof.setFocusable(true);
        doolhof.requestFocusInWindow();


        add(doolhof);

    }

    private void btnStartMouseClicked(MouseEvent evt) {
        timer.stopTimer();
        this.removeAll();
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

 

    @Override
    public void keyPressed(KeyEvent e) {
        doolhof.keyPressed(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
