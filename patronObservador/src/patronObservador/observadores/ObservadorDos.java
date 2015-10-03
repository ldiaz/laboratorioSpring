package patronObservador.observadores;

import patronObservador.Observador;
import patronObservador.Sujeto;

public class ObservadorDos extends Observador {

	public ObservadorDos( Sujeto sujeto){
		super(sujeto);
		
		this.sujeto = sujeto;
	}
	
	@Override
	public void actualizar() {
		System.out.println("Sujeto reportó cambio en Observador Dos: "+ sujeto.getEstado());
	}

}
