/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Karen
 */
public class Level extends JPanel implements ActionListener {

    private Boolean endLevel;
    private Boolean gameOver;
    private Doolhof doolhof;
    private Speler speler;
    private int levelNr = 1;

    public Level() {

        setLayout(null);
        setBackground(Color.BLACK);
        setSize(900, 700);
        setFocusable(true);
        addKeyListener(new Toetsenbord());
        start();

    }

    private void start() {

        JPanel paneelLevel = new Teller();
        paneelLevel.setBounds(0, 0, 450, 50);
        add(paneelLevel);
        JLabel label = new JLabel("Level" + levelNr);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setForeground(Color.BLUE);
        label.setBounds(500, 0, 100, 50);
        doolhof = new Doolhof(levelNr);
        speler = new Speler();
        doolhof.setBounds(60, 50, 850, 650);
        add(speler);
        add(doolhof);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(speler.getImage(), speler.getPositieX(), speler.getPositieY(), null);
    }

    public void actionPerformed(ActionEvent e) {
        speler.move();
        repaint();
    }

    private class Toetsenbord extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            speler.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            speler.keyPressed(e);
        }
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
