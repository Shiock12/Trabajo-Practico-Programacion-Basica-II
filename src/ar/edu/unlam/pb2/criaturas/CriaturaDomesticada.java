package ar.edu.unlam.pb2.criaturas;

public class CriaturaDomesticada extends CriaturaBase {

    public CriaturaDomesticada(String nombre, Integer energiaInicial, AfinidadElemental afinidad) {
        super(nombre, energiaInicial, afinidad);
    }

    @Override
    public void entrenar(MaestroElemental maestro, Integer intensidad) throws FaltaMaestriaExcepcion {

        // Verifica que el maestro tiene suficiente maestría
        if (maestro.getNivelMaestria() < intensidad) {
            throw new FaltaMaestriaExcepcion("El maestro no tiene suficiente maestría.");
        }

        // Incremento de energía estable
        this.setEnergia(this.getEnergia() + intensidad);

        // Una criatura domesticada nunca se vuelve inestable
        this.estado = EstadoEmocional.TRANQUILA;
    }
}
