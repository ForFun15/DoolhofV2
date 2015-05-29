/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.*;
import java.util.*;
import javax.swing.JComponent;

/**
 *
 * @author Karen
 */
public class Doolhof extends JComponent {

    private final int X = 26;
    private final int Y = 20;
    private Vakje[][] matrix;


    public Doolhof(int levelNr) {

        setLayout(null);
        setBackground(Color.BLACK);
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
        matrix = new Vakje[X][Y];


        try {
            arch = new FileReader(file); // Bestand lezen
            buff = new BufferedReader(arch); // Buffer lezen

            String linea = buff.readLine().trim();
            st = new StringTokenizer(linea);

            // vul matrix

            for (int i = 0; i < X; ++i) {
                for (int j = 0; j < Y; ++j) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        Muur muur = new Muur();
                        matrix[i][j] = muur;
                    } else if (num == 0) {
                        Pad pad = new Pad();
                        matrix[i][j] = pad;
                    } else if (num == 2) {
                        Speler speler = new Speler();
                        Pad pSpeler = new Pad(speler);                        
                        matrix[i][j] = pSpeler;                        
                    } else if (num == 3) {
                        Pad pVriend = new Pad(new Vriend());
                        matrix[i][j] = pVriend;
                    } else if (num == 4) {
                        Pad pBazooka = new Pad(new Bazooka());
                        matrix[i][j] = pBazooka;
                    } else if (num == 5) {
                        Pad pVspeler = new Pad(new ValsSpeler());
                        matrix[i][j] = pVspeler;
                    } else if (num == 6) {
                        Pad pHelper = new Pad(new Helper());
                        matrix[i][j] = pHelper;
                    }

                }
                if (i < X - 1) {
                    linea = buff.readLine();
                    st = new StringTokenizer(linea);
                }
            }

            buff.close();
            arch.close();
        } catch (IOException ioe) {
            System.out.println("matrix vullen is fout gegaan" + ioe);

        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                g.drawImage(matrix[i][j].image, i * 30, j * 30, this);
               
            }
        }

    }
}