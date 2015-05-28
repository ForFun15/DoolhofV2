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

    private JPanel level;
    private JPanel startPage;
    private JButton start;
    ImageIcon image1;
    ImageIcon image2;

    public Main() {
        image1 = new ImageIcon(getClass().getResource("/resources/Slide1.png"));
        image2 = new ImageIcon(getClass().getResource("/resources/Start.png"));
    }

    private void btnStartMouseClicked(MouseEvent evt) {
        startPage.setVisible(false);
        level = new Level();
        add(level);
    }

    public void init() {

        setTitle("Dolhoof Game");
        setSize(900, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);

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

        JLabel imgPage = new JLabel(image1);
        startPage = new JPanel();
        startPage.setBackground(Color.BLACK);
        startPage.add(imgPage);
        startPage.setLocation(0, 0);
        startPage.add(start);

        add(startPage);
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
//    public class AL extends KeyAdapter {
//
//        public void keyPressed(KeyEvent e) {
//            int keyCode = e.getKeyCode();
//            if (keyCode == e.VK_LEFT) {
//                //grens bepalen
//                if (x <= 0) {
//                    x = 0;
//                } else {
//                    x -= 10;
//                }
//            }
//            if (keyCode == e.VK_RIGHT) {
//                if (x >= 230) {
//                    x = 230;
//
//                } else {
//                    x += 10;
//                }
//            }
//            if (keyCode == e.VK_UP) {
//                if (y <= 25) {
//                    y = 25;
//
//                } else {
//                    y -= 10;
//                }
//            }
//            if (keyCode == e.VK_DOWN) {
//                if (y >= 230) {
//                    y = 230;
//
//                } else {
//                    y += 10;
//                }
//            }
//        }
//
//        public void KeyReleased(KeyEvent e) {
//        }
//    }
//    public void paint(Graphics g) {
//        dbImage = createImage(getWidth(), getHeight());
//        dbg = dbImage.getGraphics();
//        paintComponent(dbg);
//        g.drawImage(dbImage, 0, 0, this);
//    }
//
//    public void paintComponent(Graphics g) {
//        g.fillOval(x, y, 15, 15);
//        repaint();
//
//    }
}
