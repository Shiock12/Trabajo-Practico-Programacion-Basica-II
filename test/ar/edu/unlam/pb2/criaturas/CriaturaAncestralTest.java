package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;
import org.junit.Test;

public class CriaturaAncestralTest {

    @Test
    public void siCreoUnaAncestralConMenosDeCienLaEnergiaArrancaEnCien() {
        Criatura ancestral = new CriaturaAncestral("Abuela", 40, AfinidadElemental.TIERRA);

        assertTrue(ancestral.getEnergia() >= 100);
    }

    @Test
    public void laAncestralNuncaQuedaConMenosDeCienAunqueLePongaUnValorBajo() {
        Criatura ancestral = new CriaturaAncestral("Anciana", 150, AfinidadElemental.AIRE);

        ancestral.setEnergia(50); // intento bajarla fuerte

        assertTrue(ancestral.getEnergia() >= 100);
    }
}
