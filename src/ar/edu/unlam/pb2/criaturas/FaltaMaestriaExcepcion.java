package ar.edu.unlam.pb2.criaturas;

public class FaltaMaestriaExcepcion extends Exception {
	
	//cuando el maestro no tiene nivel suficiente
	public FaltaMaestriaExcepcion (String mensaje) {
		super(mensaje);
	}

}
