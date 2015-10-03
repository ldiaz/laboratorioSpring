package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import factory.FormaFactory;
import formas.Forma;

public class pruebaPatronFactory {

	
	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	FormaFactory generadorFormas = new FormaFactory();

        try {
            System.out.println("Ingrese la forma a dibujar (circulo, triangulo, cuadrado), escriba 'salir' para terminar.");
            String forma = "";
            while(!"salir".equals( forma = br.readLine())){
            	
            	Forma objetoForma = generadorFormas.crearForma(forma);
            	
            	if (null != objetoForma) {
            		
                	objetoForma.dibujar();
            	}else{
            		
            		System.out.println("Forma invalida");
            	}
            	
            };
			
		} catch (IOException e) {
//			e.printStackTrace();
			System.err.println("Error de i/o");
		}
        
        System.out.println("Aplicacion terminada");
	}
}
