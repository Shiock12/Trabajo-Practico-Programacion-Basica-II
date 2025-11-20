package ar.edu.unlam.pb2.criaturas;

public class CriaturaAncestral extends CriaturaBase {

    public CriaturaAncestral(String nombre, Integer energiaInicial, AfinidadElemental afinidad) {
        super(nombre, energiaInicial < 100 ? 100 : energiaInicial, afinidad);
    }

    @Override
    public void setEnergia(Integer energia) {
        // Nunca menos de 100, nunca más de 200
        if (energia < 100) {
            energia = 100;
        }
        if (energia > 200) {
            energia = 200;
        }
        this.energia = energia;
    }

    @Override
    public void entrenar(MaestroElemental maestro, Integer intensidad) throws FaltaMaestriaExcepcion {

        if (maestro.getNivelMaestria() < intensidad) {
            throw new FaltaMaestriaExcepcion("El maestro no tiene suficiente maestría.");
        }

        // Aumenta energía normalmente
        this.setEnergia(this.getEnergia() + intensidad);

        // Sensible a entrenamientos extremos → se vuelve inestable
        if (intensidad > maestro.getNivelMaestria() * 2) {
            this.estado = EstadoEmocional.INESTABLE;
        }
    }
}
