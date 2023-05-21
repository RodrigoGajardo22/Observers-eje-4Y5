package ar.unrn.model;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		String     ruta     = "C:\\Users\\Usuario\\Documents\\2 - UNIVERSIDAD RODRI\\Orientacion a Objetos 2\\Persistencia\\Temperatura.txt";
		File       archivo  = new File(ruta);

		Componente decorado = new EnArchivo(archivo, new EnConsola(new Medidor(new OpenWeather())));

		decorado.leerTemperatura();

	}

}
