package Console;

public class Case {
    private int nbBombe;
    private boolean estBombe;


    public Case() {
        nbBombe = 0;
    }

    public int getNbBombe() {
        return nbBombe;
    }

    public boolean isEstBombe() {
        return estBombe;
    }

    public void setEstBombe(boolean estBombe) {
        this.estBombe = estBombe;
    }

    public void ajouterBombe() {
        nbBombe++;
    }

    @Override
    public String toString() {
        if(estBombe){
            return "*";
        }
        if(nbBombe == 0){
            return "";
        }
        return nbBombe+"";
    }
}
