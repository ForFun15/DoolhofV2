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
    private final int X = 26;
    private final int Y = 20;
    private Vakje[][] matrix;
    private Speler speler;

    public Level() {

        setLayout(null);
        setBackground(Color.BLACK);
        setSize(900, 700);

        start();


    }

    private void start() {

        doolhof = new Doolhof(levelNr, X, Y);
        matrix = doolhof.getMatrix();
        speler = doolhof.getSpeler();


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
        addVakjes();
//        Vakje component = (Vakje) getComponent(0);
//        component.printBuren();
    }

    private void btnStartMouseClicked(MouseEvent evt) {
        timer.stopTimer();
        this.repaint();
        start();
    }


    private void addVakjes() {

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                matrix[i][j].setBounds(60 + i * 30, 50 + j * 30, 30, 30);
//                if(matrix[i][j] instanceof Pad){
//                    matrix[i][j]
//                }
                add(matrix[i][j]);
            }
        }
    }

//    public void actionPerformed(ActionEvent e) {
//        speler.move();
//        repaint();
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

    @Override
    public void keyReleased(KeyEvent e) {
        //speler.keyReleased(e);
        System.out.println("keyTyped: " + e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // speler.keyPressed(e);
        System.out.println("keyTyped: " + e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped: " + e);
    }


}
