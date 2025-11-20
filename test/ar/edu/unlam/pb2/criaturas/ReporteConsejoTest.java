package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class ReporteConsejoTest {

    @Test
    public void testListarTodasLasCriaturas() {
        MaestroElemental m1 = new MaestroElemental("Aang", 20, AfinidadElemental.AIRE);
        MaestroElemental m2 = new MaestroElemental("Katara", 25, AfinidadElemental.AGUA);

        Criatura c1 = new CriaturaDomesticada("Bisonte", 120, AfinidadElemental.AIRE);
        Criatura c2 = new CriaturaSalvaje("Lobo", 90, AfinidadElemental.AGUA);

        m1.agregarCriatura(c1);
        m2.agregarCriatura(c2);

        ReporteConsejo rc = new ReporteConsejo();

        List<Criatura> todas = rc.listarTodasLasCriaturas(List.of(m1, m2));

        assertEquals(2, todas.size());
    }

    @Test
    public void testBuscarCriaturaConMasEnergia() {
        MaestroElemental m = new MaestroElemental("Toph", 30, AfinidadElemental.TIERRA);

        Criatura c1 = new CriaturaDomesticada("Tigre", 80, AfinidadElemental.TIERRA);
        Criatura c2 = new CriaturaDomesticada("Pajarito", 120, AfinidadElemental.AIRE);

        m.agregarCriatura(c1);
        m.agregarCriatura(c2);

        ReporteConsejo rc = new ReporteConsejo();
        Criatura max = rc.buscarCriaturaConMasEnergia(List.of(m));

        assertEquals("Pajarito", max.getNombre());
    }

    @Test
    public void testCantidadPorAfinidad() {
        MaestroElemental m = new MaestroElemental("Aang", 20, AfinidadElemental.AIRE);

        m.agregarCriatura(new CriaturaDomesticada("Bisonte", 100, AfinidadElemental.AIRE));
        m.agregarCriatura(new CriaturaSalvaje("Zorro", 110, AfinidadElemental.FUEGO));

        ReporteConsejo rc = new ReporteConsejo();

        Map<AfinidadElemental, Integer> mapa =
                rc.cantidadPorAfinidad(List.of(m));

        assertEquals(Integer.valueOf(1), mapa.get(AfinidadElemental.AIRE));
        assertEquals(Integer.valueOf(1), mapa.get(AfinidadElemental.FUEGO));
    }
}
