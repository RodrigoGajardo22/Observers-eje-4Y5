package ar.unrn.model;

public class OpenWeatherException extends RuntimeException {

	public OpenWeatherException(Exception e, String msg) {
		super(msg, e);
	}

	public OpenWeatherException(String msg) {
		super(msg);
	}

}
