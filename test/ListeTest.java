import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListeTest {
    Liste data;

    @BeforeEach
    void setUp() {
        data = new Liste();
        data.ajouter(0);
        data.ajouter(10);
        data.ajouter(20);
        data.ajouter(30);
        data.ajouter(40);
        data.ajouter(50);
    }

    @org.junit.jupiter.api.Test
    void getElementAt() {
        assertEquals(0, data.getElementAt(0));
        assertEquals(30, data.getElementAt(3));
        assertEquals(50, data.getElementAt(5));
    }

    @org.junit.jupiter.api.Test
    void getNbElements() {
        assertEquals(6, data.getNbElements());
        Liste vide = new Liste();
        assertEquals(0, vide.getNbElements());
    }

    @org.junit.jupiter.api.Test
    void estVide() {
        assertEquals(false, data.estVide());
        Liste vide = new Liste();
        assertEquals(true, vide.estVide());
    }

    @org.junit.jupiter.api.Test
    void ajouter() {
        data.ajouter(90);
        data.ajouter(91);
        data.ajouter(92);
        assertEquals(90, data.getElementAt(6));
        assertEquals(91, data.getElementAt(7));
        assertEquals(92, data.getElementAt(8));
        assertEquals(9, data.getNbElements());
    }

    @org.junit.jupiter.api.Test
    void testAjouter() {
        data.ajouter(-10, 0);
        data.ajouter(35, 4);
        data.ajouter(60, 8);
        assertEquals(-10, data.getElementAt(0));
        assertEquals(35, data.getElementAt(4));
        assertEquals(60, data.getElementAt(8));
        assertEquals(9, data.getNbElements());
    }

    @org.junit.jupiter.api.Test
    void testAjouter1() {
    }

    @org.junit.jupiter.api.Test
    void trouver() {
    }

    @org.junit.jupiter.api.Test
    void trouverTout() {
    }

    @org.junit.jupiter.api.Test
    void effacerAt() {
    }

    @org.junit.jupiter.api.Test
    void effacerTout() {
    }

    @org.junit.jupiter.api.Test
    void testEffacerTout() {
    }
}