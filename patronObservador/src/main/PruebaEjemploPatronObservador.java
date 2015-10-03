package main;

import patronObservador.Sujeto;
import patronObservador.observadores.ObservadorDos;
import patronObservador.observadores.ObservadorUno;

public class PruebaEjemploPatronObservador {

	public static void main(String[] args) {
		
		Sujeto objetoObservable1 = new Sujeto();
		Sujeto objetoObservable2 = new Sujeto();
		
		ObservadorUno observador1 = new ObservadorUno(objetoObservable1);
		ObservadorDos observador2 = new ObservadorDos(objetoObservable1);
		
		System.out.println("Cambiando el estado del sujeto a 'estado uno'");
		objetoObservable1.setEstado("estado uno");
		
		System.out.println("Cambiando el estado del sujeto a 'estado dos'");
		objetoObservable1.setEstado("estado Dos");
		
		System.out.println("Cambiando el estado del sujeto2 a 'estado tres'");
		objetoObservable2.setEstado("estado tres");

		
	}

}
