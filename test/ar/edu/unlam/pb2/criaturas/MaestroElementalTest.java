package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;
import org.junit.Test;

public class MaestroElementalTest {

    @Test
    public void maestroPuedeAgregarYBuscarCriaturaPorNombre() {
        MaestroElemental maestro = new MaestroElemental("Gandalf", 20, AfinidadElemental.FUEGO);
        Criatura criatura = new CriaturaDomesticada("Pepito", 50, AfinidadElemental.AGUA);

        maestro.agregarCriatura(criatura);

        Criatura encontrada = maestro.buscarCriaturaPorNombre("Pepito");

        assertNotNull(encontrada);
        assertEquals("Pepito", encontrada.getNombre());
    }

    @Test
    public void maestroEntrenaUnaCriaturaDomesticadaYSubeLaEnergia() throws Exception {
        MaestroElemental maestro = new MaestroElemental("Maestro", 10, AfinidadElemental.AGUA);
        Criatura criatura = new CriaturaDomesticada("Luna", 40, AfinidadElemental.AGUA);

        maestro.agregarCriatura(criatura);

        // intensidad menor o igual a la maestria
        maestro.entrenarCriatura("Luna", 5);

        assertEquals(Integer.valueOf(45), criatura.getEnergia());
    }

    @Test
    public void siElMaestroNoTieneMaestriaSuficienteAlEntrenarSeLanzaLaExcepcion() {
        MaestroElemental maestro = new MaestroElemental("Principiante", 3, AfinidadElemental.FUEGO);
        Criatura criatura = new CriaturaDomesticada("Gato", 30, AfinidadElemental.FUEGO);

        maestro.agregarCriatura(criatura);

        try {
            // intensidad mas alta que la maestria -> la criatura deberia tirar FaltaMaestriaExcepcion
            maestro.entrenarCriatura("Gato", 10);
            fail("Esperaba FaltaMaestriaExcepcion pero no se lanzó nada");
        } catch (FaltaMaestriaExcepcion e) {
        }
    }
}