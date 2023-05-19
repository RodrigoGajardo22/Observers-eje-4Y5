package domain.portsin;

//Puente que conecta con la UI

//Observador

public interface Observable {

	public void nuevoRegistro(String nombre, String tel, String region, String email) throws DomainException;

}
