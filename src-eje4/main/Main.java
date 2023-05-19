package main;

import java.util.List;

import domain.model.SistemaDeRegistro;
import domain.portsin.Observable;
import domain.portsou.Observador;
import infraestructure.data.JdbcParticipantes;
import infraestructure.mail.Mail;
import infraestructure.ui.UI;

public class Main {

	public static void main(String[] args) {

		Observador repositorio = new JdbcParticipantes();
		Observador email       = new Mail();

		Observable   observable    = new SistemaDeRegistro(List.of(repositorio, email));

		UI         ui          = new UI(observable);

	}
}
