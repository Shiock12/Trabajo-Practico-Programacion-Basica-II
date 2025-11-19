package ar.edu.unlam.pb2.criaturas;

public class BendicionRio extends Transformaciones {

    public BendicionRio(Criatura criatura) {
        super(criatura);
        
        Integer energiaDoble = criatura.getEnergia() * 2;

        if (energiaDoble > 180) {
            energiaDoble = 180;
        }

        this.setEnergia(energiaDoble);
    }
}
