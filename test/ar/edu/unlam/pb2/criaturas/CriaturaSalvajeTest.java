package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;
import org.junit.Test;

public class CriaturaSalvajeTest {

    @Test
    public void alEntrenarUnaSalvajeConMaestroSuficienteCambiaLaEnergiaYPuedeQuedarInestable() throws Exception {
        MaestroElemental maestro = new MaestroElemental("Entrenador", 20, AfinidadElemental.FUEGO);
        Criatura salvaje = new CriaturaSalvaje("Lobo", 50, AfinidadElemental.FUEGO);

        salvaje.entrenar(maestro, 5);

        assertTrue(salvaje.getEnergia() >= 50);
        assertEquals(EstadoEmocional.INESTABLE, salvaje.getEstadoEmocional());
    }

    @Test
    public void siElMaestroNoTieneMaestriaNoPuedeEntrenarALaSalvaje() {
        MaestroElemental maestro = new MaestroElemental("EntrenadorNuevo", 2, AfinidadElemental.AGUA);
        Criatura salvaje = new CriaturaSalvaje("Tigre", 60, AfinidadElemental.AGUA);

        try {
            salvaje.entrenar(maestro, 10); // intensidad mas grande que su maestria
            fail("Esperaba FaltaMaestriaExcepcion pero no se lanzó nada");
        } catch (FaltaMaestriaExcepcion e) {
            // todo bien, era lo esperado
        }
    }
}