package ar.edu.unlam.pb2.criaturas;

public class AscensoDelViento extends Transformaciones {

    public AscensoDelViento(Criatura base) {
        super(base);
    }

    // - Afinidad principal pasa a ser AIRE
    // - Sin perder afinidades previas (si después manejan varias afinidades)
}
