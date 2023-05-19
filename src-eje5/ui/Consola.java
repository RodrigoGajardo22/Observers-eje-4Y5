package ui;

import domain.portsou.Observador;

public class Consola implements Observador {

	@Override
	public void actualizar(String monto) {
		System.out.println(" $ " + monto);

	}

}
