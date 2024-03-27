public class Liste {
    public class Noeud {
        public int valeur;
        public Noeud prochain, precedent;
        public Noeud(int valeur){
            this.valeur = valeur;
            this.precedent = null;
            this.prochain = null;
        }

        public String toString(){
            return String.valueOf(valeur);
        }
    }
    private Noeud premier, dernier;
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
        if(index >= 0) {
            for (Noeud courant = premier; courant != null; courant = courant.prochain)
                if (index-- == 0)
                    return courant;
        }else {
            for (Noeud courant = dernier; courant != null; courant = courant.precedent)
                if (++index == 0)
                    return courant;
        }
            return null;
    }
    public boolean ajouter(int valeur) {

        if (estVide()) {
            premier = new Noeud(valeur);
            dernier = premier;
        }
        else {
            Noeud nouveau = new Noeud(valeur);
            dernier.prochain = nouveau;
            dernier.precedent = dernier;
            dernier = dernier.prochain;
        }
        nbElements++;
        return true;
    }
    public boolean ajouter(int valeur, int index) {
        if(index < -nbElements || index > nbElements)
            return false;
        Noeud precedent = getNoeudAt(index - 1);
        Noeud nouveau = new Noeud(valeur);

        if (index == 0) {
            nouveau.prochain = premier;
            nouveau.precedent = null;
            premier = nouveau;
        } else if (index == nbElements || index == -1) {
            return ajouter(valeur);
        } else {
            nouveau.prochain = precedent.prochain;
            nouveau.precedent = precedent;
            precedent.prochain = nouveau;
            nouveau.prochain.precedent = nouveau;
        }
        nbElements++;
        return true;
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
