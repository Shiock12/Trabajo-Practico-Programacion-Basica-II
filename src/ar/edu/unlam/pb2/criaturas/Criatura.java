package ar.edu.unlam.pb2.criaturas;

public interface Criatura {

    public String getNombre();

    public Integer getEnergia();

    public void setEnergia(Integer energia);

    public AfinidadElemental getAfinidadPrincipal();

    public EstadoEmocional getEstadoEmocional();

    public void setEstadoEmocional(EstadoEmocional estado);

    public void entrenar(MaestroElemental maestro, Integer intensidad) throws FaltaMaestriaExcepcion;

    public void pacificar();

    // NUEVO: necesario para reportes
    public boolean estaTransformada();
}
