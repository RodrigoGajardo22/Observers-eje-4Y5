package domain.model;

import java.util.List;

import domain.portsou.Observador;

//Observable - Observado 

public abstract class Sujeto {

	protected List<Observador> observadores;

	public Sujeto() {
		// this.observadores = new ArrayList<Observador>();
	}

	public void addObservers(Observador obs) {
		this.observadores.add(obs);
	}

	protected void notificar(String monto) {
		for (Observador obs : observadores) {
			obs.actualizar(monto);
		}

	}
}
