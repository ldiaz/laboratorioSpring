package factory;

import formas.Forma;
import impl.Circulo;
import impl.Cuadrado;
import impl.Rectangulo;
import impl.Triangulo;

public class FormaFactory {

	public Forma crearForma(String tipoForma) {
		if (tipoForma == null) {
			
			return null;
		}
		
		if (tipoForma.equalsIgnoreCase("circulo")) {
			
			return new Circulo();
		} else if (tipoForma.equalsIgnoreCase("cuadrado")) {
			
			return new Cuadrado();
		} else if (tipoForma.equalsIgnoreCase("triangulo")) {
			
			return new Triangulo();
		} else if (tipoForma.equalsIgnoreCase("rectangulo")){
			
			return new Rectangulo();
		}
		
		return null;
	}
}
