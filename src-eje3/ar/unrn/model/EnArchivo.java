package ar.unrn.model;

import java.io.File;
import java.io.FileWriter;

public class EnArchivo implements Componente {

	private File       file;
	private Componente decorado;

	public EnArchivo(File file, Componente decorado) {
		this.file     = file;
		this.decorado = decorado;
	}

	@Override
	public String leerTemperatura() {
		String aux = decorado.leerTemperatura();

		this.registrar(aux);

		return aux;
	}

	private void registrar(String datos) {

		try {

			FileWriter escribir = new FileWriter(file, true);

			escribir.write(datos);
			escribir.write("\r\n");
			escribir.close();
		} // Si existe un problema al escribir cae aqui
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
