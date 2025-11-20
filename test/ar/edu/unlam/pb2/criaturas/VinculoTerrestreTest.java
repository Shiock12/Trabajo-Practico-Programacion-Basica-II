package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;
import org.junit.Test;

public class VinculoTerrestreTest {

    @Test
    public void conVinculoTerrestreNuncaBajaDeCincuenta() {
        Criatura base = new CriaturaDomesticada("Gaia", 40, AfinidadElemental.TIERRA);
        Criatura protegida = new VinculoTerrestre(base);

        // fuerzo un valor bajo
        protegida.setEnergia(10);

        assertTrue(protegida.getEnergia() >= 50);
    }
}
