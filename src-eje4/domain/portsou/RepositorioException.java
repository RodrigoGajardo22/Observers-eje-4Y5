package domain.portsou;

public class RepositorioException extends RuntimeException {

	public RepositorioException(Exception e, String msg) {
		super(msg, e);
	}

	public RepositorioException(String msg) {
		super(msg);
	}

}
