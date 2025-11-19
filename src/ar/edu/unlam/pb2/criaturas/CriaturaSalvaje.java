package ar.edu.unlam.pb2.criaturas;

public class CriaturaSalvaje extends CriaturaBase {
	
	public CriaturaSalvaje (String nombre, Integer energiaInicial, AfinidadElemental afinidad) {
		super(nombre,energiaInicial,afinidad);
	}
	
	public void entrenar(MaestroElemental maestro, Integer intensidad) throws FaltaMaestriaExcepcion {
        // - Verificar maestría del maestro (si es baja, tirar FaltaDeMaestriaException)
        // - Aumentar energía de forma "impredecible" (por ejemplo, más que intensidad)
        // - Si la energía se pasa de 200, tirar EnergiaDesbordadaException (unchecked)
    }
}
