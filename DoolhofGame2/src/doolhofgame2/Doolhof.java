/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Color;
import java.awt.Graphics;
import java.io.*;
import java.util.*;
import javax.swing.JComponent;

/**
 *
 * @author Karen
 */
public class Doolhof extends JComponent  {

    private final int X = 26;
    private final int Y = 20;
    private int[][] matrix;
   


    
    public Doolhof(int levelNr) {

        this.setLayout(null);
        this.setBackground(Color.BLACK);
        //
        //        File archivo = new File("doolhof3.txt");
        //        try{
        //            PrintWriter escribo = new PrintWriter(new BufferedWriter(new FileWriter(archivo)));
        //            for (int i = 0; i < 26; i++) {
        //               escribo.println("1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1");
        //            }
        //            escribo.close();
        //        }catch(IOException ex){
        //            System.out.println("error "+ex);
        //        }
        File file = zoekMatrix(levelNr);
        fillMatrix(file);
        //setSpelItems();
    }
    

    private File zoekMatrix(int levelNr) {

        File file = null;

        switch (levelNr) {
            case 1:
                file = new File("doolhof1.txt");
                break;
            case 2:
                file = new File("doolhof2.txt");
                break;
            case 3:
                file = new File("doolhof3.txt");
                break;
            default:
                System.out.println("Fout bij File in doolhof.java");
                break;
        }
        return file;
    }

    private void fillMatrix(File file) {
        FileReader arch;
        StringTokenizer st;
        BufferedReader buff = null;
        matrix = new int[X][Y];
        Random rand = new Random();
        int spitems = 3;

        try {
            arch = new FileReader(file); // Bestand lezen
            buff = new BufferedReader(arch); // Buffer lezen

            String linea = buff.readLine().trim();
            st = new StringTokenizer(linea);

            // vul matrix

            for (int i = 0; i < X; ++i) {
                for (int j = 0; j < Y; ++j) {
                    int num = Integer.parseInt(st.nextToken());
                    matrix[i][j] = num;
                }
                if (i < X - 1) {
                    linea = buff.readLine();
                    st = new StringTokenizer(linea);
                }
            }
            do {
                int dx = rand.nextInt(X/3);
                int dy = rand.nextInt(Y);
                if (matrix[dx][dy] == 0) {
                    matrix[dx][dy] = spitems;
                    spitems++;
                }
            } while (spitems < 6);
            buff.close();
            arch.close();
        } catch (IOException ioe) {
            System.out.println("matrix vullen is fout gegaan" + ioe);

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        tekenDoolhof(g);
        plaatsSpelItems(g);

    }

    private void tekenDoolhof(Graphics g) {

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (matrix[i][j] == 1) {
                    Vakje m = new Muur();
                    g.drawImage(m.image, i * m.getWidth(), j * m.getHeight(), this);
                } else {
                    if (matrix[i][j] == 0) {
                        Vakje p = new Pad();
                        g.drawImage(p.image, i * p.getWidth(), j * p.getHeight(), this);
                    }

                }
            }
        }
    }

    private void plaatsSpelItems(Graphics g) {

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (matrix[i][j] == 2) {
                    SpelItem vriend = new Vriend();
                    g.drawImage(vriend.image, i * vriend.getWidth(), j * vriend.getHeight(), this);
                } else {
                    if (matrix[i][j] == 3) {
                        SpelItem vs = new ValsSpeler();
                        g.drawImage(vs.image, i * vs.getWidth(), j * vs.getHeight(), this);
                    } else {
                        if (matrix[i][j] == 4) {
                            SpelItem bazooka = new Bazooka();
                            g.drawImage(bazooka.image, i * bazooka.getWidth(), j * bazooka.getHeight(), this);
                        } else if (matrix[i][j] == 5) {
                            SpelItem helper = new Helper();
                            g.drawImage(helper.image, i * helper.getWidth(), j * helper.getHeight(), this);
                        }
                    }

                }
            }
        }
    }
}