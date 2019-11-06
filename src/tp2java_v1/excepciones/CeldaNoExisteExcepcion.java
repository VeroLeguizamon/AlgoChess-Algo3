package tp2java_v1.excepciones;

public class CeldaNoExisteExcepcion extends RuntimeException {
	@Override
	public String getMessage() {
		return message;
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message = "La celda que intenta alcanzar no existe";
}
