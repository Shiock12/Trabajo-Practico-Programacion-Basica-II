package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;
import org.junit.Test;

public class CriaturaAncestralTest {

    @Test
    public void laAncestralNuncaQuedaConMenosDeCien() {
        Criatura ancestral = new CriaturaAncestral("Zara", 120, AfinidadElemental.FUEGO);

        ancestral.setEnergia(50); // intento bajarla a lo bestia

        assertTrue(ancestral.getEnergia() >= 100);
    }
}
