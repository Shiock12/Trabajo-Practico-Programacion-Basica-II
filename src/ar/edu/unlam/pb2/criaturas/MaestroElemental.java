package ar.edu.unlam.pb2.criaturas;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MaestroElemental {

    private String nombre;
    private Integer nivelMaestria; // 1 a 50
    private AfinidadElemental afinidadPrincipal;

    // Criaturas del maestro, usando el nombre como clave
    private Map<String, Criatura> criaturas = new HashMap<>();

    public MaestroElemental(String nombre, Integer nivelMaestria, AfinidadElemental afinidadPrincipal) {
        this.nombre = nombre;
        this.nivelMaestria = nivelMaestria;
        this.afinidadPrincipal = afinidadPrincipal;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNivelMaestria() {
        return nivelMaestria;
    }

    public AfinidadElemental getAfinidadPrincipal() {
        return afinidadPrincipal;
    }

    // --- manejo de criaturas --- //

    public void agregarCriatura(Criatura criatura) {
        if (criatura == null) {
            return;
        }
        criaturas.put(criatura.getNombre(), criatura);
    }

    public Criatura buscarCriaturaPorNombre(String nombreCriatura) {
        return criaturas.get(nombreCriatura);
    }

    public Collection<Criatura> getCriaturas() {
        return criaturas.values();
    }

    // --- Parte I: entrenar y pacificar --- //

    public void entrenarCriatura(String nombreCriatura, Integer intensidad) throws FaltaMaestriaExcepcion {
        Criatura c = buscarCriaturaPorNombre(nombreCriatura);
        if (c == null) {
            return; // o se podría tirar alguna excepción si quieren
        }
        c.entrenar(this, intensidad); // polimórfico: depende del tipo de criatura
    }

    public void pacificarCriatura(String nombreCriatura) {
        Criatura c = buscarCriaturaPorNombre(nombreCriatura);
        if (c == null) {
            return;
        }
        c.pacificar();
    }
}
