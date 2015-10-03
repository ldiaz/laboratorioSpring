package patronObservador.observadores;

import patronObservador.Observador;
import patronObservador.Sujeto;

public class ObservadorUno extends Observador{

	public ObservadorUno( Sujeto sujeto){
		super(sujeto);
		
		this.sujeto = sujeto;
	}
	
	@Override
	public void actualizar() {
				System.out.println("     Sujeto reportó cambio en Observador Uno: "+ sujeto.getEstado());
	}

}
