package tp2java.excepciones;

public class EntidadNoExisteExcepcion extends RuntimeException {

	@Override
	public String getMessage() {
		return message;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message = "No existe la entidad.";
	
}
