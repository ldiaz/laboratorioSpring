package patronObservador;

public abstract class Observador {
	
	protected Sujeto sujeto;
	
	public Observador(Sujeto sujeto){
		sujeto.register(this);
	}
	
	public abstract void actualizar();
}
