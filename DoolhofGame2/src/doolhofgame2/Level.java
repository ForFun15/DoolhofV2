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



//        speler = doolhof.getSpeler();


//        timer = new Teller(10);
//        timer.setBounds(600, 10, 100, 30);
//        add(timer);

        
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
        //matrix = doolhof.getMatrix();
        doolhof.setLocation(60, 50);
        //doolhof.repaint();
        add(doolhof);
        //addVakjes();
//        Vakje component = (Vakje) getComponent(0);
//        component.printBuren();
    }
    
    private void btnStartMouseClicked(MouseEvent evt) {
        timer.stopTimer();
        this.repaint();
        start();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        for (int i = 0; i < X; i++) {
//            for (int j = 0; j < Y; j++) {
//                g.drawImage(matrix[i][j].image, 60 + i * matrix[i][j].image.getHeight(this), 50 + j * matrix[i][j].image.getWidth(this), null);
//
//                add(matrix[i][j]);
//            }
////        }
//        for (Vakje[] rij : matrix) {
//            for (Vakje vk : rij) {
//               vk.repaint();
//            }
//        }
        doolhof.repaint();
    }

//    private void addVakjes() {
//
//        for (int i = 0; i < X; i++) {
//            for (int j = 0; j < Y; j++) {
//                matrix[i][j].setBounds(60 + i * 30, 50 + j * 30, 30, 30);
//                
//                add(matrix[i][j]);
//            }
//        }
//    }
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
}
