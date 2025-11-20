package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;
import org.junit.Test;

public class InteraccionesTest {

    @Test
    public void cuandoTienenLaMismaAfinidadSubenDiezCadaUna() throws Exception {
        // dos criaturas tranquilas de AGUA
        Criatura criaturaUno = new CriaturaDomesticada("Luna", 50, AfinidadElemental.AGUA);
        Criatura criaturaDos = new CriaturaDomesticada("Sol", 60, AfinidadElemental.AGUA);

        Interacciones interacciones = new Interacciones();
        interacciones.hacerInteractuar(criaturaUno, criaturaDos);

        // deberían sumar 10 cada una
        assertEquals(Integer.valueOf(60), criaturaUno.getEnergia());
        assertEquals(Integer.valueOf(70), criaturaDos.getEnergia());
    }

    @Test
    public void aguaConFuegoSePonenInestables() throws Exception {
        // uso salvajes para que se puedan desestabilizar
        Criatura agua = new CriaturaSalvaje("Aguita", 80, AfinidadElemental.AGUA);
        Criatura fuego = new CriaturaSalvaje("Fueguito", 90, AfinidadElemental.FUEGO);

        Interacciones interacciones = new Interacciones();
        interacciones.hacerInteractuar(agua, fuego);

        assertEquals(EstadoEmocional.INESTABLE, agua.getEstadoEmocional());
        assertEquals(EstadoEmocional.INESTABLE, fuego.getEstadoEmocional());
    }

    @Test
    public void aireYTierraTambienQuedanInestables() throws Exception {
        Criatura aire = new CriaturaSalvaje("Nube", 40, AfinidadElemental.AIRE);
        Criatura tierra = new CriaturaSalvaje("Roca", 55, AfinidadElemental.TIERRA);

        Interacciones interacciones = new Interacciones();
        interacciones.hacerInteractuar(aire, tierra);

        assertEquals(EstadoEmocional.INESTABLE, aire.getEstadoEmocional());
        assertEquals(EstadoEmocional.INESTABLE, tierra.getEstadoEmocional());
    }

    @Test
    public void siHayUnaAncestralTieneLaVentajaEnLaInteraccion() throws Exception {
        // la ancestral arranca con buena energia
        Criatura ancestral = new CriaturaAncestral("Anciana", 120, AfinidadElemental.AGUA);
        // la otra es una criatura normal cualquiera
        Criatura otra = new CriaturaDomesticada("Peon", 40, AfinidadElemental.FUEGO);

        Interacciones interacciones = new Interacciones();
        interacciones.hacerInteractuar(ancestral, otra);

        // la ancestral gana 20
        assertEquals(Integer.valueOf(140), ancestral.getEnergia());
        // la otra pierde 15, pero no menos de 0
        assertEquals(Integer.valueOf(25), otra.getEnergia());
    }

    @Test
    public void siNoSonIgualesNiOpuestasNiAncestralesNoPasaNada() throws Exception {
        // AGUA y TIERRA no son iguales ni opuestas, y ninguna es ancestral
        Criatura uno = new CriaturaDomesticada("Uno", 70, AfinidadElemental.AGUA);
        Criatura dos = new CriaturaDomesticada("Dos", 80, AfinidadElemental.TIERRA);

        Interacciones interacciones = new Interacciones();
        interacciones.hacerInteractuar(uno, dos);

        // todo debería quedar igual
        assertEquals(Integer.valueOf(70), uno.getEnergia());
        assertEquals(Integer.valueOf(80), dos.getEnergia());
        assertEquals(EstadoEmocional.TRANQUILA, uno.getEstadoEmocional());
        assertEquals(EstadoEmocional.TRANQUILA, dos.getEstadoEmocional());
    }
}
