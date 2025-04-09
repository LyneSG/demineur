package Console;

import java.util.Random;

public class Grille {
    private int taille, nbBombe;
    private Case[][] plateau;

    public Grille(int taille) {
        this.taille = taille;
        this.nbBombe = taille*3;
        this.plateau = new Case[nbBombe/2][nbBombe/2];
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                plateau[i][j] = new Case();
            }
        }

        int bombeplacees = 0;
        while (bombeplacees <= nbBombe) {
            Random r = new Random();
            int x = r.nextInt(plateau.length);
            int y = r.nextInt(plateau[x].length);
            if(!getCase(x, y).isEstBombe()) {
                plateau[x][y].setEstBombe(true);
                bombeplacees++;
            }
        }
        comptageBombe();
    }

    public Case getCase(int x, int y) {
        return plateau[x][y];
    }

    public Case[][] getPlateau() {
        return plateau;
    }

    public void comptageBombe() {
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                if(plateau[i][j].isEstBombe()){
                    if(i-1 >= 0 && j-1 >= 0){
                        plateau[i-1][j-1].ajouterBombe();
                    }
                    if(i-1 >= 0){
                        plateau[i-1][j].ajouterBombe();
                    }
                    if(i-1 >= 0 && j+1 < plateau[i].length){
                        plateau[i-1][j+1].ajouterBombe();
                    }
                    if(j+1 < plateau.length){
                        plateau[i][j+1].ajouterBombe();
                    }
                    if(i+1 < plateau[i].length && j+1 < plateau[i].length){
                        plateau[i+1][j+1].ajouterBombe();
                    }
                    if(i+1 < plateau[i].length){
                        plateau[i+1][j].ajouterBombe();
                    }
                    if(i+1 < plateau[i].length && j-1 >= 0){
                        plateau[i+1][j-1].ajouterBombe();
                    }
                    if(j-1 >= 0){
                        plateau[i][j-1].ajouterBombe();
                    }
                }
            }
        }
    }

    public void afficher() {
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                System.out.print(plateau[i][j].toString());
            }
            System.out.println("|");
            for (int j = 0; j < plateau[i].length; j++) {
                System.out.print("----");
            }
            System.out.println("-");
        }
    }
}
