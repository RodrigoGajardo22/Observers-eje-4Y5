package domain.model;

import java.util.List;

import domain.portsin.DomainException;
import domain.portsin.Observable;
import domain.portsou.Observador;

//SUJETO - Observable - Observado 

public class SistemaDeRegistro implements Observable {

	private List<Observador> listaDeObservadores;

	public SistemaDeRegistro(List<Observador> listaDeObservadores) {

		this.listaDeObservadores = listaDeObservadores;
	}

	public void agregarIObservador(Observador obs) {
		this.listaDeObservadores.add(obs);
	}

	@Override
	public void nuevoRegistro(String nombre, String tel, String region, String email) throws DomainException {

		Participante participante = new Participante(nombre, tel, region, email);

		listaDeObservadores.forEach(observador -> observador.actualizar(participante.datos()));

	}

}
