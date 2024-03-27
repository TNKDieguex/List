public class Liste {
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
    private Noeud premier;
    private int nbElements;

    public Liste() {
        premier = null;
        nbElements = 0;
    }
    public String toString() {
        String str = "[";
        for (Noeud courant = premier; courant != null; courant = courant.prochain)
            str +=  courant + ", "; //si no hubiese un "toString usaría 'courrant.valeur'"
        return str + "]";
    }
    public int getNbElements() {
        return nbElements;
    }
    public boolean estVide() {
        return nbElements == 0;
    }
    public int getElementAt(int index) {
        return getNoeudAt(index).valeur;
    }
    private Noeud getNoeudAt(int index) {
        for (Noeud courant = premier; courant != null; courant = courant.prochain)
            if (index-- == 0)
                return courant;
        return null;
    }
    public void ajouter(int valeur) {
        Noeud dernier = null;
        for (Noeud courant = premier; courant != null; courant = courant.prochain)
            dernier = courant;

        if (dernier == null) {
            premier = new Noeud(valeur);
        }
        else {
            dernier.prochain = new Noeud(valeur);
        }
        nbElements++;
    }
    public void ajouter(int valeur, int index) {
        Noeud precedent = getNoeudAt(index - 1);
        Noeud nouveau = new Noeud(valeur);

        if (index == 0) {
            nouveau.prochain = premier;
            premier = nouveau;
        }
        else {
            nouveau.prochain = precedent.prochain;
            precedent.prochain = nouveau;
        }
        nbElements++;
    }

    public void ajouter(Liste autre) {
        for (int i = 0; i < autre.getNbElements(); i++)
            this.ajouter(autre.getElementAt(i));
    }


    public int trouver(int valeur) {
        int i = 0;
        for (Noeud courant = premier; courant != null; courant = courant.prochain){
            if (courant.valeur == valeur)
                return i;
            else
                i++;
        }
        return -1;
    }
    public boolean effacerAt(int index) {
        if (index < 0 || index > nbElements)
            return false;
        if(index == 0){
            premier = premier.prochain;
        }else {
            Noeud precedent = getNoeudAt(index - 1);
            precedent.prochain = precedent.prochain.prochain;
        }
        nbElements--;
        return true;
    }
/*
    public boolean trouverTout(Liste autre) {
        for (int i = 0 ; i < autre.getNbElements(); i++)
            if (this.trouver(autre.getElementAt(i)) == -1)
                return false;
        return true;
    }


    public boolean effacerTout(Liste autre) {
        boolean result = false;
        for (int i = 0; i < autre.getNbElements(); i++) {
            int valeurAEffacer = autre.getElementAt(i);
            int indexAEffacer = trouver(valeurAEffacer);
            if (indexAEffacer != -1) {
                this.effacerAt(indexAEffacer);
                result = true;
            }
        }
        return result;
    }
*/
    public void effacerTout() {
        premier = null;
        nbElements = 0;
    }


}
