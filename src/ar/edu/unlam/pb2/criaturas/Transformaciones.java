package ar.edu.unlam.pb2.criaturas;

public abstract class Transformaciones implements Criatura {

    protected Criatura criatura; // La criatura decorada

    public Transformaciones(Criatura criatura) {
        this.criatura = criatura;
    }

    @Override
    public String getNombre() {
        return criatura.getNombre();
    }

    @Override
    public Integer getEnergia() {
        return criatura.getEnergia();
    }

    @Override
    public void setEnergia(Integer energia) {
        criatura.setEnergia(energia);
    }

    @Override
    public AfinidadElemental getAfinidadPrincipal() {
        return criatura.getAfinidadPrincipal();
    }

    @Override
    public EstadoEmocional getEstadoEmocional() {
        return criatura.getEstadoEmocional();
    }

    @Override
    public void setEstadoEmocional(EstadoEmocional estado) {
        criatura.setEstadoEmocional(estado);
    }

    @Override
    public void pacificar() {
        criatura.pacificar();
    }

    @Override
    public void entrenar(MaestroElemental maestro, Integer intensidad) throws FaltaMaestriaExcepcion {
        criatura.entrenar(maestro, intensidad);
    }

    // NUEVO: todas las transformaciones cuentan como transformadas
    @Override
    public boolean estaTransformada() {
        return true;
    }
}