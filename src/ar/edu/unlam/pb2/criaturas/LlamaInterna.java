package ar.edu.unlam.pb2.criaturas;

public class LlamaInterna extends Transformaciones {

    public LlamaInterna(Criatura criatura) {
        super(criatura);

        if (criatura.getAfinidadPrincipal() == AfinidadElemental.FUEGO) {
            this.setEnergia(criatura.getEnergia() + 30);
        } else {
            this.setEstadoEmocional(EstadoEmocional.INESTABLE);
        }
    }
}
