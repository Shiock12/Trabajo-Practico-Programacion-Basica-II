package ar.edu.unlam.pb2.criaturas;

public class LlamaInterna  extends Transformaciones{
	
	public LlamaInterna (Criatura base) {
		super(base);
	}

	// - Si afinidad es FUEGO -> +30 energía
    // - Si no, la criatura se vuelve INESTABLE
}
