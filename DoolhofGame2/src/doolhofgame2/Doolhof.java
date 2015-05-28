/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
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

        this.setLayout(new FlowLayout());
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
                        Vakje muur = new Muur();
                        matrix[i][j] = muur;
                    } else if (num == 0) {
                        Vakje pad = new Pad();
                        matrix[i][j] = pad;
                    } else if (num == 2) {
                        Vakje pSpeler = new Pad(new Speler());
                        matrix[i][j] = pSpeler;
                    } else if (num == 3) {
                        Vakje pVriend = new Pad(new Vriend());
                        matrix[i][j] = pVriend;
                    } else if (num == 4) {
                        Vakje pBazooka = new Pad(new Bazooka());
                        matrix[i][j] = pBazooka;
                    } else if (num == 5) {
                        Vakje pVspeler = new Pad(new ValsSpeler());
                        matrix[i][j] = pVspeler;
                    } else if (num == 6) {
                        Vakje pHelper = new Pad(new Helper());
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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vakje[] vak : matrix) {
            for (Vakje item : vak) {
                item.repaint();
            }
        }

    }
//    private void tekenDoolhof(Graphics g) {
//
//        for (int i = 0; i < X; i++) {
//            for (int j = 0; j < Y; j++) {
//                if (matrix[i][j] == 1) {
//                    Vakje m = new Muur();
//                    g.drawImage(m.image, i * m.getWidth(), j * m.getHeight(), this);
//                } else {
//                    if (matrix[i][j] == 0) {
//                        Vakje p = new Pad();
//                        g.drawImage(p.image, i * p.getWidth(), j * p.getHeight(), this);
//                    }
//
//                }
//            }
//        }
//    }
//    private void plaatsSpelItems(Graphics g) {
//
//        for (int i = 0; i < X; i++) {
//            for (int j = 0; j < Y; j++) {
//                if (matrix[i][j] == 2) {
//                    SpelItem vriend = new Vriend();
//                    g.drawImage(vriend.image, i * vriend.getWidth(), j * vriend.getHeight(), this);
//                } else {
//                    if (matrix[i][j] == 3) {
//                        SpelItem vs = new ValsSpeler();
//                        g.drawImage(vs.image, i * vs.getWidth(), j * vs.getHeight(), this);
//                    } else {
//                        if (matrix[i][j] == 4) {
//                            SpelItem bazooka = new Bazooka();
//                            g.drawImage(bazooka.image, i * bazooka.getWidth(), j * bazooka.getHeight(), this);
//                        } else if (matrix[i][j] == 5) {
//                            SpelItem helper = new Helper();
//                            g.drawImage(helper.image, i * helper.getWidth(), j * helper.getHeight(), this);
//                        }
//                    }
//
//                }
//            }
//        }
//    }
}