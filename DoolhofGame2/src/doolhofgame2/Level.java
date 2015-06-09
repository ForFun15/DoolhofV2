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
public class Level extends JPanel implements KeyListener {

    private Boolean endLevel;
    private Boolean gameOver;
    private Doolhof doolhof;
    private int levelNr;
    protected Teller timer;
    private JLabel label, imgPage;
    private JButton opnieuw, startknop;
    private ImageIcon image1;
    private boolean keyIsenabled;

    public Level() {

        setLayout(null);
        setBackground(Color.BLACK);
        setSize(900, 700);
        image1 = new ImageIcon(getClass().getResource("/resources/Slide1.png"));
        levelNr = 1;
        keyIsenabled = false;
        start();

    }

    private void start() {

        timer = new Teller(0);
        timer.setBounds(600, 10, 100, 30);
        timer.setVisible(false);
        add(timer);

        startknop = new JButton("Start");
        startknop.setForeground(Color.GREEN);
        startknop.setBackground(Color.BLACK);
        startknop.setBounds(600, 10, 80, 30);
        Level.KnopHandler kh = new Level.KnopHandler();
        startknop.addActionListener(kh);
        add(startknop);



        opnieuw = new JButton("Restart");
        opnieuw.setForeground(Color.GREEN);
        opnieuw.setBackground(Color.BLACK);
        opnieuw.addActionListener(kh);
        opnieuw.setBounds(700, 10, 80, 30);
        opnieuw.setVisible(false);
        add(opnieuw);

        label = new JLabel("Level " + levelNr);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        label.setBounds(100, 0, 100, 50);
        label.setForeground(Color.GREEN);
        label.setVisible(false);
        add(label);

        doolhof = new Doolhof(this);
        doolhof.setLocation(60, 50);
        doolhof.setFocusable(true);
        doolhof.requestFocusInWindow();
        doolhof.setVisible(false);
        add(doolhof);

        imgPage = new JLabel(image1);
        imgPage.setBounds(0, 50, 900, 650);
        imgPage.setVisible(true);
        add(imgPage);

        keyIsenabled = true;

    }

    private void restart() {

        timer = new Teller(30);
        timer.setBounds(600, 10, 100, 30);
        timer.setVisible(true);
        add(timer);

        opnieuw = new JButton("Restart");
        opnieuw.setForeground(Color.GREEN);
        opnieuw.setBackground(Color.BLACK);
        Level.KnopHandler kh = new Level.KnopHandler();
        opnieuw.addActionListener(kh);
        opnieuw.setBounds(700, 10, 80, 30);
        add(opnieuw);

        label = new JLabel("Level " + levelNr);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        label.setBounds(100, 0, 100, 50);
        label.setForeground(Color.GREEN);
        add(label);

        doolhof = new Doolhof(this);
        doolhof.setLocation(60, 50);
        doolhof.setFocusable(true);
        doolhof.requestFocusInWindow();
        add(doolhof);

    }

    public void nextLevel() {
        if (endLevel) {
            this.levelNr = levelNr + 1;
            if (levelNr < 4) {
                this.removeAll();
                this.repaint();
                keyIsenabled = false;
                nieuwLevel();
            }else{
                this.removeAll();
                this.repaint();
                setGameOver(true);               
                            
            }
        }
    }

    private void nieuwLevel() {

        timer = new Teller(0);
        timer.setBounds(600, 10, 100, 30);
        timer.setVisible(false);
        add(timer);

        startknop = new JButton("Start");
        startknop.setForeground(Color.GREEN);
        startknop.setBackground(Color.BLACK);
        startknop.setBounds(600, 10, 80, 30);
        KnopHandler kh = new KnopHandler();
        startknop.addActionListener(kh);
        add(startknop);

        opnieuw = new JButton("Restart");
        opnieuw.setForeground(Color.GREEN);
        opnieuw.setBackground(Color.BLACK);
        opnieuw.addActionListener(kh);
        opnieuw.setBounds(700, 10, 80, 30);
        opnieuw.setVisible(false);
        add(opnieuw);

        label = new JLabel("Level " + levelNr);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        label.setBounds(100, 0, 100, 50);
        label.setForeground(Color.GREEN);
        add(label);

        doolhof = new Doolhof(this);

        doolhof.setLocation(60, 50);
        add(doolhof);
    }

    public void setEndLevel(Boolean endLevel) {
        this.endLevel = endLevel;
    }

    public int getLevelNr() {
        return levelNr;
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
        
    }

    public Boolean getGameOver() {
        return gameOver;
    }
    
    

    class KnopHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startknop) {
                timer.setTeller(30);
                timer.setVisible(true);
                startknop.setVisible(false);
                label.setVisible(true);
                opnieuw.setVisible(true);
                doolhof.setVisible(true);
                timer.startTimer();
            }
            if ((e.getSource() == startknop) && (levelNr > 1)) {
                timer.setTeller(30);
                timer.setVisible(true);
                startknop.setVisible(false);
                label.setVisible(true);
                opnieuw.setVisible(true);
                keyIsenabled = true;
                timer.startTimer();

            }
            if (e.getSource() == opnieuw) {
                removeAll();
                repaint();
                restart();
                timer.startTimer();
            }

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (keyIsenabled == true) {
            doolhof.keyPressed(e);
        }
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
