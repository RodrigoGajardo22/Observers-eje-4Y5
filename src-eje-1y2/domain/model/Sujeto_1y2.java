package domain.model;

import java.util.List;

import domain.portsin.ISujeto;
import domain.portsin.Observador;

public abstract class Sujeto_1y2 implements ISujeto {

	private List<Observador> listaObservadores;

	public Sujeto_1y2(List<Observador> listaObservadores) {
		this.listaObservadores = listaObservadores;
	}

	public void agregarIObservador(Observador obs) {
		this.listaObservadores.add(obs);
	}

	public void notificar(String pronostico, String temperatura) {
		for (Observador observador : listaObservadores) {
			observador.actualizar(pronostico, temperatura);
		}
	}

}
