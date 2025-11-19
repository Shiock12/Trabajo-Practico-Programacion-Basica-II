package ar.edu.unlam.pb2.criaturas;

public class CriaturaAncestral extends CriaturaBase {
	
	public CriaturaAncestral(String nombre, Integer energiaInicial, AfinidadElemental afinidad) {
        super(nombre, energiaInicial, afinidad);
        if (this.energia < 100) {
            this.energia = 100;
        }
    }
	
	 public void setEnergia(Integer energia) {
         // - Garantizar que nunca quede con energía menor a 100
         super.setEnergia(energia);
     }
	 
	 public void entrenar(MaestroElemental maestro, Integer intensidad) throws FaltaMaestriaExcepcion {
	        // - Verificar maestría alta del maestro (por ejemplo >= 30)
	        // - Si el entrenamiento es "extremo" (intensidad alta), cambiar estado o energía
	        // - Si no, aumentar energía de forma controlada
	    }

}
