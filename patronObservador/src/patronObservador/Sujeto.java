package patronObservador;

import java.util.ArrayList;
import java.util.List;

public class Sujeto {
	
	private  List<Observador> listadoObservadores = new ArrayList<Observador>();
	
	private String estado;
	
	public void register(Observador observador){
			listadoObservadores.add(observador);
	}
	
	public void notificarObservadores(){
		for(Observador observador : listadoObservadores){
			observador.actualizar();
		}
	}
}
