package ar.edu.unlam.pb2.criaturas;

import java.util.ArrayList;
import java.util.List;

// Servicio que sabe cómo hacer interactuar dos criaturas usando un conjunto de reglas
public class Interacciones {

    private List<ReglaInteraccion> reglas = new ArrayList<>();

    public Interacciones() {
        // Orden de prioridad:
        // 1) ancestral
        // 2) misma afinidad
        // 3) afinidades opuestas
        reglas.add(new reglaInteraccionAncestral());
        reglas.add(new ReglaInteraccionAfinidadCompartida());
        reglas.add(new ReglaInteraccionAfinidadOpuesta());
    }

    public void hacerInteractuar(Criatura a, Criatura b) {
        for (ReglaInteraccion regla : reglas) {
            boolean seAplico = regla.aplicar(a, b);
            if (seAplico) {
                return; // si una regla se aplicó, cortamos
            }
        }
    }
}
