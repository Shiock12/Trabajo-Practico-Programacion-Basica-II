package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;
import org.junit.Test;

public class TransformacionesTest {

    @Test
    public void bendicionDelRioDuplicaLaEnergiaPeroNoPasaDeCientoOchenta() {
        Criatura base = new CriaturaDomesticada("Pez", 90, AfinidadElemental.AGUA);

        Criatura bendecida = new BendicionRio(base);

        // 90 * 2 = 180, justo el tope
        assertEquals(Integer.valueOf(180), bendecida.getEnergia());
    }

    @Test
    public void bendicionDelRioNoSuperaCientoOchentaAunqueLaEnergiaSeaAlta() {
        Criatura base = new CriaturaDomesticada("PezGrande", 150, AfinidadElemental.AGUA);

        Criatura bendecida = new BendicionRio(base);

        // 150 * 2 = 300, pero el tope es 180
        assertEquals(Integer.valueOf(180), bendecida.getEnergia());
    }

    @Test
    public void llamaInternaEnCriaturaDeFuegoSumaTreintaDeEnergia() {
        Criatura base = new CriaturaSalvaje("Fenix", 100, AfinidadElemental.FUEGO);

        Criatura conLlama = new LlamaInterna(base);

        assertEquals(Integer.valueOf(130), conLlama.getEnergia());
    }

    @Test
    public void llamaInternaEnCriaturaQueNoEsDeFuegoLaVuelveInestableSiPuede() {
        // uso salvaje porque puede quedar inestable
        Criatura base = new CriaturaSalvaje("Pajaro", 80, AfinidadElemental.AIRE);

        Criatura conLlama = new LlamaInterna(base);

        assertEquals(EstadoEmocional.INESTABLE, conLlama.getEstadoEmocional());
    }

    @Test
    public void vinculoTerrestreSubeALoMenosAHastaCincuentaSiEstabaMuyBaja() {
        Criatura base = new CriaturaDomesticada("Topo", 20, AfinidadElemental.TIERRA);

        Criatura protegida = new VinculoTerrestre(base);

        assertTrue(protegida.getEnergia() >= 50);
    }

    @Test
    public void conVinculoTerrestreNuncaDeberiaQuedarConMenosDeCincuenta() {
        Criatura base = new VinculoTerrestre(
                new CriaturaDomesticada("TopoDos", 60, AfinidadElemental.TIERRA)
        );

        base.setEnergia(10); // intento bajarla

        assertTrue(base.getEnergia() >= 50);
    }

    @Test
    public void ascensoDelVientoHaceQueLaAfinidadSeVeaComoAire() {
        Criatura base = new CriaturaDomesticada("PajaroTierra", 70, AfinidadElemental.TIERRA);

        Criatura voladora = new AscensoViento(base);

        assertEquals(AfinidadElemental.AIRE, voladora.getAfinidadPrincipal());
    }
}
