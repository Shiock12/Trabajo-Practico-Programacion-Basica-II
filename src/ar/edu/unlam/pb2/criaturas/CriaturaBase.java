package ar.edu.unlam.pb2.criaturas;

public abstract class CriaturaBase implements Criatura {
	
	protected String nombre;
	protected Integer energia;
	protected AfinidadElemental afinidad;
	protected EstadoEmocional estado = EstadoEmocional.TRANQUILA;
	
	
	public CriaturaBase (String nombre, Integer energiaInicial, AfinidadElemental afinidad) {
		this.nombre = nombre;
		this.afinidad = afinidad;
		setEnergia(energiaInicial);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public Integer getEnergia() {
		return energia;
	}
	
	public void setEnergia (Integer energia) {
		if(energia <0) {
			this.energia = 0;
		}
		if(energia > 200) {
			energia = 200;
		}
		
		this.energia = energia;
	}
	
	public AfinidadElemental getAfinidadPrincipal() {
        return afinidad;
    }
	
	public EstadoEmocional getEstadoEmocional() {
        return estado;
    }

	public void setEstadoEmocional(EstadoEmocional estado) {
        this.estado = estado;
    }
	
	public void pacificar() {
        this.estado = EstadoEmocional.TRANQUILA;
    }
	
	// Cada tipo de criatura va a implementar su forma de entrenar
    @Override
    public abstract void entrenar(MaestroElemental maestro, Integer intensidad) throws FaltaMaestriaExcepcion;

}
