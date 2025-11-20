package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;
import org.junit.Test;

public class CriaturaDomesticadaTest {

    @Test
    public void laDomesticadaNoQuedaInestableNiConLlamaInterna() throws Exception {
        MaestroElemental maestro = new MaestroElemental("Pepe", 10, AfinidadElemental.FUEGO);
        Criatura base = new CriaturaDomesticada("Luna", 50, AfinidadElemental.AGUA);

        // le aplico la transformación que la pondría inestable si no fuera domesticada
        Criatura transformada = new LlamaInterna(base);

        // aunque LlamaInterna intente ponerla INESTABLE,
        // la domesticada debería seguir tranquila
        assertEquals(EstadoEmocional.TRANQUILA, transformada.getEstadoEmocional());
    }
    @Test
    public void siElMaestroNoTieneMaestriaNoPuedeEntrenarALaDomesticada() {
        MaestroElemental maestro = new MaestroElemental("MaestroNuevo", 3, AfinidadElemental.FUEGO);
        Criatura domesticada = new CriaturaDomesticada("GatoMagico", 40, AfinidadElemental.FUEGO);

        try {
            domesticada.entrenar(maestro, 10);
            fail("Esperaba FaltaMaestriaExcepcion pero no se lanzó nada");
        } catch (FaltaMaestriaExcepcion e) {
            // OK
        }
    }
}
