package ar.edu.unlam.pb2.criaturas;

public class CriaturaDomesticada extends CriaturaBase {
	
	public CriaturaDomesticada(String nombre, Integer energiaInicial, AfinidadElemental afinidad) {
        super(nombre, energiaInicial, afinidad);
    }
	
	public void entrenar(MaestroElemental maestro, Integer intensidad) throws FaltaMaestriaExcepcion {
        // - Verificar maestría mínima del maestro (por ejemplo >= 5)
        // - Aumentar la energía de forma "normal" y respetar el tope 200
        // - Mantener siempre el estado emocional TRANQUILA
    }

    @Override
    public void setEstadoEmocional(EstadoEmocional estado) {
        // - Ignorar intentos de ponerla INESTABLE (nunca debería quedar así)
        super.setEstadoEmocional(estado);
    }

}
