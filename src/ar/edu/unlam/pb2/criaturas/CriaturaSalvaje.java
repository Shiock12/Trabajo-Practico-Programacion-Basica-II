package ar.edu.unlam.pb2.criaturas;

public class CriaturaSalvaje extends CriaturaBase {

    public CriaturaSalvaje(String nombre, Integer energiaInicial, AfinidadElemental afinidad) {
        super(nombre, energiaInicial, afinidad);
    }

    @Override
    public void entrenar(MaestroElemental maestro, Integer intensidad) throws FaltaMaestriaExcepcion {

        // 1. Verificar maestría
        if (maestro.getNivelMaestria() < intensidad) {
            throw new FaltaMaestriaExcepcion("El maestro no tiene suficiente maestría.");
        }

        // 2. Incremento impredecible: entre intensidad y 2×intensidad
        int aumento = intensidad + (int)(Math.random() * intensidad);

        this.setEnergia(this.getEnergia() + aumento);

        // 3. Si supera 200 → UNCHECKED
        if (this.getEnergia() > 200) {
            throw new EnergiaDesbordadaExcepcion("La criatura salvaje se descontroló y superó 200 de energía.");
        }

        // 4. Las salvajes pueden quedar inestables
        this.estado = EstadoEmocional.INESTABLE;
    }
}
