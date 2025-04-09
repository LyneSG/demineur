package interfaceD;

import Console.Case;

import javax.swing.*;
import java.awt.*;

public class CaseBouton extends JButton {
    private int taille = 30;
    private Case kase;

    public CaseBouton(Case kase, String nombre) {
        this.setPreferredSize(new Dimension(taille, taille));
        this.kase = kase;
    }

    public Case getKase() {
        return kase;
    }

    public void setKase(Case kase) {
        this.kase = kase;
    }
}
