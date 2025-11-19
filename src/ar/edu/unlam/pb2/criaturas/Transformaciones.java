package ar.edu.unlam.pb2.criaturas;

public abstract class Transformaciones implements Criatura {
	
	protected final Criatura base;
	
	public  Transformaciones (Criatura base) {
		this.base = base;
	}
	
	 // Delegar métodos de Criatura a "base" cuando implementen la lógica

}
