/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhofgame2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.ImageIcon;

/**
 *
 * @author Karen
 */
public class Helper extends SpelItem {

    private ArrayList<Vakje> popVakjes;

    public Helper() {
        image = new ImageIcon(getClass().getResource("/resources/imgHelp2.png")).getImage();
        popVakjes = new ArrayList<>();
    }

    
    @Override
    public void voerActie() {
        super.voerActie();
        Stack<Vakje> weg = new Stack<>();
        boolean backtracking = backtracking(this.pad, weg);
        
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    private void printStack(Stack<Vakje> weg) {

        Image imageWeg = new ImageIcon(getClass().getResource("/resources/pad2.png")).getImage();

        for (Iterator<Vakje> it = weg.iterator(); it.hasNext();) {
            Vakje vk = it.next();
            if (vk.getSpelitem() == null) {
                vk.setImage(imageWeg);
                vk.repaint();
            }
        }

    }

    private boolean backtracking(Vakje pHelper, Stack<Vakje> weg) {
        boolean gevonden = false;
        SpelItem spelitem = pHelper.getSpelitem();
        pHelper.isVisited = true;
        weg.add(pHelper);
        if (spelitem instanceof Vriend) {
            gevonden = true;
            printStack(weg);
            return gevonden;

        } else {

            if (pHelper.getNorth() != null) {
                if ((pHelper.getNorth().isWalkable) && (!pHelper.getNorth().isVisited)) {
                    gevonden = backtracking(pHelper.getNorth(), weg);
                    if (gevonden == false) {
                        Vakje pop = weg.pop();
                        popVakjes.add(pop);
                    }
                }
            }
            if (pHelper.getEast() != null) {
                if ((pHelper.getEast().isWalkable) && (!pHelper.getEast().isVisited)) {
                    gevonden = backtracking(pHelper.getEast(), weg);
                    if (gevonden == false) {
                        Vakje pop = weg.pop();
                        popVakjes.add(pop);
                    }
                }
            }
            if (pHelper.getSouth() != null) {
                if ((pHelper.getSouth().isWalkable) && (!pHelper.getSouth().isVisited)) {
                    gevonden = backtracking(pHelper.getSouth(), weg);
                    if (gevonden == false) {
                        Vakje pop = weg.pop();
                        popVakjes.add(pop);
                    }
                }
            }
            if (pHelper.getWest() != null) {
                if ((pHelper.getWest().isWalkable) && (!pHelper.getWest().isVisited)) {
                    gevonden = backtracking(pHelper.getWest(), weg);
                    if (gevonden == false) {
                        Vakje pop = weg.pop();
                        popVakjes.add(pop);
                    }
                }
            }
            return gevonden;
        }
    }

    public void setPad(Pad pad) {
        this.pad = pad;
    }

    public Pad getPad() {
        return pad;
    }
}
