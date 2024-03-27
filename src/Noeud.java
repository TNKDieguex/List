public class Noeud {
    public int valeur;
    public Noeud prochain;
    public Noeud(int valeur){
        this.valeur = valeur;
        this.prochain = null;
    }

    public String toString(){
        return String.valueOf(valeur);
    }
}
