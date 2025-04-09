import Console.Grille;
import interfaceD.GrilleVue;

public class Main {
    public static void main(String[] args) {
        Grille grille = new Grille(10);
        GrilleVue grilleVue = new GrilleVue(grille);
    }
}