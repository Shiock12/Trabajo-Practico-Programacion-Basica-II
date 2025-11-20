package ar.edu.unlam.pb2.criaturas;

public class VinculoTerrestre extends Transformaciones {

    public VinculoTerrestre(Criatura criatura) {
        super(criatura);

        if (criatura.getEnergia() < 50) {
            this.setEnergia(50);
        }
    }

    @Override
    public void setEnergia(Integer energia) {
        if (energia < 50) {
            energia = 50;
        }
        super.setEnergia(energia);
    }
}
