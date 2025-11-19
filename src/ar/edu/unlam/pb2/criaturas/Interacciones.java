package ar.edu.unlam.pb2.criaturas;

// Después acá metemos las reglas de interacción entre dos criaturas
public class Interacciones {

    public void hacerInteractuar(Criatura a, Criatura b) {
        // - Afinidad compartida -> ambas ganan energía
        // - Afinidades opuestas -> ambas inestables
        // - Si una es ancestral, domina (gana más energía, la otra pierde)
    }
}
