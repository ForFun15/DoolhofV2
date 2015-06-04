/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;
import javax.swing.JPanel;

/**
 *
 * @author Karen
 */
public class Doolhof extends JPanel {

    private final int X = 26;
    private final int Y = 20;
    private Vakje[][] matrix;
    private ArrayList<File> files;
    private Speler speler = null;

    public Doolhof(int level) {
//(int nextLevel, int currentLevel)
        setSize(780, 600);
        setLayout(null);
        //File file = zoekMatrix(levelNr);
        File file = getFile(level);

        fillMatrix(file);

        addBuren();

        addVakjes();

    }

//    private File zoekMatrix(int levelNr) {
    private File getFile(int level){
     //   File file = null;
        files = new ArrayList<>();


        files.add(new File("doolhof1.txt"));
        files.add(new File("doolhof2.txt"));
        files.add(new File("doolhof3.txt"));
        Collections.shuffle(files);
        File file = files.get(level-1);
        return(file);
//
//        switch (level) {
//            case 1:
//                file = new File("doolhof2.txt");
//                break;
//            case 2:
//                file = new File("doolhof2.txt");
//                break;
//            case 3:
//                file = new File("doolhof1.txt");
//                break;
//            default:
//                System.out.println("Fout bij File in doolhof.java");
//                break;
//        }
//        return file;
    }

    private void fillMatrix(File file) {//int levelNr
        FileReader arch;
        StringTokenizer st;
        BufferedReader buff = null;
        matrix = new Vakje[X][Y];
        Random rand = new Random();
        int imgMuur = rand.nextInt(3) + 0;

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
                        Muur muur = new Muur(imgMuur);
                        matrix[i][j] = muur;
                    } else if (num == 0) {
                        Pad pad = new Pad();
                        matrix[i][j] = pad;
                    } else if (num == 2) {
                        speler = new Speler();
                        Pad pSpeler = new Pad();
                        speler.setPad(pSpeler);
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

    private void addVakjes() {

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                matrix[i][j].setPosX(i * 30);
                matrix[i][j].setPosY(j * 30);
                matrix[i][j].setBounds(matrix[i][j].getPosX(), matrix[i][j].getPosY(), 30, 30);
                add(matrix[i][j]);
            }
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

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            speler.move(3);
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            speler.move(1);
        }
        if (keyCode == KeyEvent.VK_UP) {
            speler.move(0);
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            speler.move(2);
            
        }
    }
}