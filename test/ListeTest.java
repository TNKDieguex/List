import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest {
    Liste data;

    @BeforeEach
    void setUp() {
        data = new Liste();
        data.ajouter(1);
        data.ajouter(2);
        data.ajouter(3);
        data.ajouter(4);
        data.ajouter(5);
    }

    @Test
    void getNbElements() {
        assertEquals(5, data.getNbElements());

        Liste vide = new Liste();
        assertEquals(0, vide.getNbElements());
    }

    @Test
    void estVide() {
        assertFalse(data.estVide());

        Liste vide = new Liste();
        assertTrue(vide.estVide());
    }

    @Test
    void getElementAt() {
        assertEquals(1, data.getElementAt(0));
        assertEquals(3, data.getElementAt(2));
        assertEquals(5, data.getElementAt(4));
    }

    @Test
    void ajouter() {
        data.ajouter(95);
        data.ajouter(96);
        data.ajouter(97);
        assertEquals(8, data.getNbElements());
        assertEquals(95, data.getElementAt(5));
        assertEquals(96, data.getElementAt(6));
        assertEquals(97, data.getElementAt(7));
    }

    @Test
    void inserer() {
        assertTrue(data.ajouter(90, 0));
        assertTrue(data.ajouter(94, 4));
        assertTrue(data.ajouter(97, 7));
        assertEquals(8, data.getNbElements());
        assertEquals(90, data.getElementAt(0));
        assertEquals(94, data.getElementAt(4));
        assertEquals(97, data.getElementAt(7));
    }

    @Test
    void insererPositionsInvalides() {
        // Ces ajouts devraient être refusés
        assertFalse(data.ajouter(91, -9));
        assertFalse(data.ajouter(99, 9));
        assertEquals(5, data.getNbElements());
    }

    @Test
    void ajouterPlusieurs() {
        Liste autre = new Liste();
        autre.ajouter(95);
        autre.ajouter(96);
        autre.ajouter(97);
        data.ajouter(autre);

        assertEquals(8, data.getNbElements());
        assertEquals(95, data.getElementAt(5));
        assertEquals(96, data.getElementAt(6));
        assertEquals(97, data.getElementAt(7));
    }

    @Test
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