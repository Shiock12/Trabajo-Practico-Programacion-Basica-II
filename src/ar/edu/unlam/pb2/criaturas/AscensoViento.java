package ar.edu.unlam.pb2.criaturas;

public class AscensoViento extends Transformaciones {

    public AscensoViento(Criatura criatura) {
        super(criatura);
    }

    @Override
    public AfinidadElemental getAfinidadPrincipal() {
        return AfinidadElemental.AIRE;
    }
}
