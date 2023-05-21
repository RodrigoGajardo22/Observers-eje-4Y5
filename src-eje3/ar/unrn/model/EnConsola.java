package ar.unrn.model;

public class EnConsola implements Componente {

	private Componente decorado;

	public EnConsola(Componente decorado) {
		this.decorado = decorado;
	}

	@Override
	public String leerTemperatura() {

		String aux = decorado.leerTemperatura();
		System.out.println(aux);

		return aux;
	}

}
