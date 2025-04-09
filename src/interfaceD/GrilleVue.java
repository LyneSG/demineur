package interfaceD;

import Console.Grille;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GrilleVue extends JFrame {
    private Grille grille;
    private CaseBouton[][] grilleBouton;
    private int taille;

    private JLabel lblBombe, lblDifficulte;
    private JSpinner spinNbBombe ,spinDifficulte;
    private JPanel panelG, panelGrille;
    private JButton btCommencer;
    private GridBagLayout gridbag;
    private GridBagConstraints gbc;

    public GrilleVue(Grille grille) {
        this.grille = grille;
        this.taille = grille.getPlateau().length;
        this.grilleBouton = new CaseBouton[taille][taille];

        this.setTitle("Démineur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelG = new JPanel();
        gridbag = new GridBagLayout();
        panelG.setLayout(gridbag);
        gbc = new GridBagConstraints();

        initComponents();
        initGrille();

        this.setVisible(true);
        this.setContentPane(panelG);
        this.pack();
    }

    private void initComponents() {
        lblBombe = new JLabel("Choisissez le nombre bombe");
        lblDifficulte = new JLabel("Choisissez la difficulte");
        spinNbBombe = new JSpinner(new SpinnerNumberModel(10, 1, 50, 1));
        spinDifficulte = new JSpinner(new SpinnerNumberModel(3, 1, 5, 1));
        btCommencer = new JButton("Commencer");

        gbc.insets = new Insets(10, 10, 0, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelG.add(lblBombe, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelG.add(spinNbBombe, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelG.add(lblDifficulte, gbc);
        gbc.gridx = 1;
        panelG.add(spinDifficulte, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        panelG.add(btCommencer, gbc);
    }

    private void initGrille(){
        panelGrille = new JPanel();
        GridBagLayout gbl_panelGrille = new GridBagLayout();
        panelGrille.setLayout(gbl_panelGrille);
        GridBagConstraints gcPGrille = new GridBagConstraints();

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grilleBouton[i][j] = new CaseBouton(grille.getCase(i,j), grille.getCase(i, j).getNbBombe());
                gcPGrille.gridy = i;
                gcPGrille.gridx = j;
                panelGrille.add(grilleBouton[i][j], gcPGrille);
            }
        }

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panelG.add(panelGrille, gbc);
    }
}
