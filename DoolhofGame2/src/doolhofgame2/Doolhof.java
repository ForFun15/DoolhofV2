/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.io.*;
import java.util.*;

/**
 *
 * @author Karen
 */
public class Doolhof {

    private int X;
    private int Y;
    private Vakje[][] matrix;
    private Speler speler = null;

    public Doolhof(int levelNr, int x, int y) {

        this.X = x;
        this.Y = y;
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
        addBuren();



    }

    public Vakje[][] getMatrix() {
        return matrix;
    }

    public Speler getSpeler() {
        return speler;
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
                        speler = new Speler();
                        Pad pSpeler = new Pad(speler);
                        matrix[i][j] = pSpeler;
                        System.out.println(i + " " + j);
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

    private void addBuren() {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                // bepaal buren
                if (i == 0) {
                    matrix[i][j].buren[3] = null; //west buur
                    matrix[i][j].buren[1] = matrix[i + 1][j]; // east buur
                } else {
                    if (i < X - 1) {
                        matrix[i][j].buren[3] = matrix[i - 1][j]; //west buur
                        matrix[i][j].buren[1] = matrix[i + 1][j]; // east buur
                    } else if (i == X - 1) {
                        matrix[i][j].buren[3] = matrix[i - 1][j]; //west buur
                        matrix[i][j].buren[1] = null; // east buur
                    }
                }
                if (j == 0) {
                    matrix[i][j].buren[0] = null; //north buur
                    matrix[i][j].buren[2] = matrix[i][j + 1]; // south buur
                } else {
                    if (j < Y - 1) {
                        matrix[i][j].buren[0] = matrix[i][j - 1]; //north buur
                        matrix[i][j].buren[2] = matrix[i][j + 1]; // south buur
                    } else if (j == Y - 1) {
                        matrix[i][j].buren[0] = matrix[i][j - 1]; //north buur
                        matrix[i][j].buren[2] = null; // south buur
                    }
                }
            }
        }
    }
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        for (int i = 0; i < X; i++) {
//            for (int j = 0; j < Y; j++) {
////                matrix[i][j].repaint();
//                g.drawImage(matrix[i][j].image, i * 30, j * 30, this);
//
//
//            }
//        }
//
//    }
//    
}